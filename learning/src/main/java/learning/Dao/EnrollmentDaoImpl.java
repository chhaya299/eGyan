package learning.Dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import learning.Entity.Course;
import learning.Entity.Enrollment;
import learning.Entity.Instructor;
import learning.Entity.Student;
import learning.services.CourseService;
import learning.services.InstructorServices;
import learning.services.StudentServices;

@Component
public class EnrollmentDaoImpl implements EnrollmentDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility hiber;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorServices instructorService;
	
	@Autowired
	private StudentServices studentService;

	private String string = "";

	// add enroll student in particular course
	@Transactional
	public String enrollStudent(Enrollment enroll) {
		if(getSingleEnrollStudent(enroll)==null) {
			   int i =(Integer) this.hibernateTemplate.save(enroll);
			   if(i>0) {
				Course course= this.courseService.getSingleCourse(enroll.getEnrollCourseId());
				 Instructor instructor = this.instructorService.singleInstructor(course.getInstructorId());
				 instructor.setNumOfEnrolledStudents(instructor.getNumOfEnrolledStudents()+1);
				 instructorService.saveOrUpdate(instructor);
				 System.out.println("----update instructor  and Enroll Student in course----");
				Student s = this.studentService.getSingleStudent(enroll.getEnrollStudentId());
				s.setNumOfCoursesEnrolled(s.getNumOfCoursesEnrolled()+1);
				 this.studentService.updateStudent(s);
				 System.out.println("--------------student update-----------------");
			   }		   
		}
		return "Student Already Enrolled!!";
	}

	public Enrollment getSingleEnrollStudent(Enrollment enroll) {

		Session session = hiber.getQuery();
		string = "from Enrollment where enrollStudentId=:estudent and enrollCourseId=:ecourse";
		Query query = session.createQuery(string, Enrollment.class);
		query.setParameter("estudent", enroll.getEnrollStudentId());
		query.setParameter("ecourse", enroll.getEnrollCourseId());
		try {
			Enrollment enroll1 = (Enrollment) query.getSingleResult();
			return enroll;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	//filter according to student....
	public List<Enrollment> getEnrollStudentsByStudent(int studentId){
		Session session = hiber.getQuery();
		string = "from Enrollment where enrollStudentId=:estudent";
		Query query = session.createQuery(string, Enrollment.class);
		query.setParameter("estudent",studentId);
		try{
			List<Enrollment> listEnroll = query.getResultList();
			return listEnroll;
		 }catch (Exception e) {
			 return  null;  
		}
			
	}
	
	//all enroll data....
	public List<Enrollment> getAllEnrollStudent(){
		List<Enrollment> list = this.hibernateTemplate.loadAll(Enrollment.class);
		return list;
	}
	
	
	//filter according to course.....
	public List<Enrollment> getEnrollStudentsByCourse(int studentId){
		Session session = hiber.getQuery();
		string = "from Enrollment where enrollCourseId=:estudent";
		Query query = session.createQuery(string, Enrollment.class);
		query.setParameter("estudent",studentId);
		try{
			List<Enrollment> listEnroll = query.getResultList();
			return listEnroll;
		 }catch (Exception e) {
			 return  null;  
		}
			
	}
}
