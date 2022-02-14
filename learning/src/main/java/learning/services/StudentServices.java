package learning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.LoginDao;
import learning.Dao.StudentDao;
import learning.Entity.Instructor;
import learning.Entity.Login;
import learning.Entity.Student;

@Service
public class StudentServices {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private LoginDao loginDao;
	
	public Student validate(Login login){
		
		
		 if(this.loginDao.validUser(login))
		 {
			Student student =this.studentDao.validUser(login.getEmail());
			if(student!=null) {
				return student;
			}
		 }
		 return  null;
	}
	
	
	public  String saveStudent(Student s) {
		String st = this.studentDao.addStudent(s);
		if(st.equals("data inserted"))
		{
			Login login = new Login();
			login.setEmail(s.getEmail());
			String pass = s.getFirstName();
			login.setPassword(pass);
			login.setType("student");
			this.loginDao.addLogin(login);
		}
	     return st;
	}
}
