package learning.Dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import learning.Entity.Course;

@Component
public class CourseDaoImpl implements CourseDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private HibernateQueryUtility hiber;
	
	@Transactional
	public String addCourse(Course course) {
		List<Course> courseList = this.hibernateTemplate.loadAll(Course.class);
		 for(Course list:courseList) {
			 if(list.getCourseTitle().equals(course.getCourseTitle())
					 && list.getCourseBrief().equals(course.getCourseBrief()))
				 return "Course already Exist!";
			}
		int i = (Integer) this.hibernateTemplate.save(course);
		System.out.println("courseDao insert " + course);
		return "Inserted Course";
	}

	public List<Course> getCourses() {
		List<Course> courses = this.hibernateTemplate.loadAll(Course.class);
		System.out.println(courses);
		return courses;
	}

	public Course getCourse(int cid) {
		Course course = (Course) this.hibernateTemplate.get(Course.class, cid);
		return course;
	}

	@Transactional
	public void updateCourse(Course course) {
		this.hibernateTemplate.saveOrUpdate(course);

	}

	public boolean isExistCourse(String title, String brief) {
		 Session session =this.hiber.getQuery();
		 Query query = session.createQuery("from Course where courseTitle=:coursetitle and courseBrief=:coursebrief", Course.class);
		 query.setParameter("coursetitle", title);
		 query.setParameter("coursebrief", brief);
		 Course course = (Course) query.getSingleResult();
		 if(course!=null)
			 return true;
		 return false;
	}

	public List<Course> getCourses(int instructorId) {
		Session session =this.hiber.getQuery();
	    Query query = session.createQuery("from Course where instructorId=:instructorid", Course.class);
		query.setParameter("instructorid",instructorId);
		List<Course> course = query.getResultList();
		return course;
	}

}
