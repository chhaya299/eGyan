package learning.Dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import learning.Entity.Course;
import learning.Entity.Enrollment;
import learning.Entity.Instructor;
import learning.services.CourseService;
import learning.services.InstructorServices;

@Repository
public interface EnrollmentDao {

	
	public String enrollStudent(Enrollment enroll); 

	public Enrollment getSingleEnrollStudent(Enrollment enroll) ;
	
	//filter according to student....
	public List<Enrollment> getEnrollStudentsByStudent(int studentId);
			
	
	//all enroll data....
	public List<Enrollment> getAllEnrollStudent();
	
	//filter according to course.....
	public List<Enrollment> getEnrollStudentsByCourse(int courseId);
	}
