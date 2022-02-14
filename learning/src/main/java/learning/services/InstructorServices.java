package learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.InstructorDao;
import learning.Dao.LoginDao;
import learning.Entity.Instructor;
import learning.Entity.Login;


@Service
public class InstructorServices {
	
	@Autowired
	private InstructorDao instructorDao;
	@Autowired
	private LoginDao loginDao;
	
	 public void addInstructorService(Instructor instructor) {
		      int i=(Integer)this.instructorDao.addInstructor(instructor);
			System.out.println("insert the data in instructor");
		if(i!=0) {
		
				Login login = new Login();
				login.setEmail(instructor.getEmail());
				String pass = instructor.getFirstName();
				login.setPassword(pass);
				login.setType("instructor");
				this.loginDao.addLogin(login);
		}
		 }
		 
		public Instructor validate(Login login){
			
			if(this.loginDao.validUser(login)) {
				Instructor instructor =this.instructorDao.validUser(login.getEmail());
				if(instructor!=null) {
					return instructor;
				}
			 }
			 return  null;
		}
		
		public Instructor singleInstructor(int id) {
			  return (Instructor)this.instructorDao.getInstructor(id);
		}
		
		public void saveOrUpdate(Instructor inst) {
			 this.instructorDao.updateInstructor(inst);
		}
}
