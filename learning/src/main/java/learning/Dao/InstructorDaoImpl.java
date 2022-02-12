package learning.Dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import learning.Entity.Instructor;

@Component
public class InstructorDaoImpl implements InstructorDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility hiber;
	
	//  new instructor registration add data.
	@Transactional
	public int addInstructor(Instructor instructor) {
	 int i =(Integer)this.hibernateTemplate.save(instructor);
	return i;
		
	}
	
	//update
	
	@Transactional
	public void updateInstructor(Instructor instructor) {
	 this.hibernateTemplate.saveOrUpdate(instructor);
	
	}
	
	
	
	//get all instructor data
	
	public List<Instructor> getInstructors(){
		List<Instructor>  instructors = this.hibernateTemplate.loadAll(Instructor.class);
		return instructors;
	}
	
	//delete the single instructor
	
	@Transactional
	public  void deleteInstructor(int Iid) {
		
		Instructor instructor =this.hibernateTemplate.load(Instructor.class, Iid);
		this.hibernateTemplate.delete(instructor);
	 }
	
	//get the single instructor
	public  Instructor getInstructor(int Iid) {
		Instructor instructor = this.hibernateTemplate.get(Instructor.class, Iid);
		        return instructor;
		}

	//get instructor sorted by email.
	public Instructor validUser(String email) {
		 Session session  = this.hiber.getQuery();
		 Query query =session.createQuery("from Instructor where email=:courseId", Instructor.class);
		 query.setParameter("courseId", email);
		 Instructor I =(Instructor) query.getSingleResult();
		 return I;
	}
}
