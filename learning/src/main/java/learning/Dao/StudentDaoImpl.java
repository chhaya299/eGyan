package learning.Dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import learning.Entity.Instructor;
import learning.Entity.Login;
import learning.Entity.Student;

@Component
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility hiber;

	@Transactional
	public String addStudent(Student student) {
		 if(validUser(student.getEmail())!=null)
			  return "Email already Exist";
				
		int i = (Integer) this.hibernateTemplate.save(student);
		
		return "data inserted";
	}

	public Student getStudent(int id) {
		
		return this.hibernateTemplate.get(Student.class, id);
	}

	public List<Student> getAllStudent() {
		
		return this.hibernateTemplate.loadAll(Student.class);
	}

	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
		}

	
	
	public Student validUser(String email) {
	
		 Session session  = this.hiber.getQuery();
		 Query query =session.createQuery("from Student where email=:courseId", Student.class);
		 query.setParameter("courseId", email);
		 Student I = null;
		 try{
			I  =(Student) query.getSingleResult();
		 }catch (NoResultException e) {
			 return null;
		}
		 return I;
	}

	
}
