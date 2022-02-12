package learning.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;
import learning.Entity.Course;
import learning.Entity.Instructor;

@Repository
public interface CourseDao {
	
	public String addCourse(Course course) ;
	
	public List<Course> getCourses(int instructorId);
	public Course getCourse(int cid) ;
	public void updateCourse(Course course);
	
	public boolean isExistCourse(String title,String brief);
}
