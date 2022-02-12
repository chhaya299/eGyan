package learning.Dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import learning.Entity.Instructor;

@Repository
public interface InstructorDao {
	

	public int addInstructor(Instructor instructor) ;
	
	public void updateInstructor(Instructor instructor);
	//get all instructor data
	
	public List<Instructor> getInstructors();
	//delete the single instructor
	
	
	public  void deleteInstructor(int Iid);
	
	//get the single instructor
	public  Instructor getInstructor(int Iid);
	
	public  Instructor validUser(String email);
	
}
