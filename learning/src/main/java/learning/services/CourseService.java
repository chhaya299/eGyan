package learning.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.CourseDao;
import learning.Entity.Course;
import learning.Entity.Instructor;

@Service
public class CourseService {
	@Autowired	
	private CourseDao courseDao;
	@Autowired
	private InstructorServices instructorService;
	
		public String saveCourse(Course course) {
			if(courseDao.isExistCourse(course.getCourseTitle(), course.getCourseBrief()))
					return "Course already Exist";
			String i = this.courseDao.addCourse(course);
		    Instructor  instructor =this.instructorService.singleInstructor(course.getInstructorId());
			instructor.setNumOfPublishedCourses(instructor.getNumOfPublishedCourses()+1);
		    this.instructorService.saveOrUpdate(instructor);
		   System.out.println("update course table");
		   return "Inserted Course";
			
		}

		public List<Course> getAllCourses(int instrutorId) {
			    List<Course> course1 = (List<Course>) this.courseDao.getCourses(instrutorId);
			    return course1;
		}
		
		public  Course getSingleCourse(int id) {
			Course course1=(Course) this.courseDao.getCourse(id);
			return course1;
		}
		
		public void  saveOrUpadte(Course course) {
			this.courseDao.updateCourse(course);
		}
		
		public List<Course> getCourses(){
			List<Course> courseList = this.courseDao.getCourses();
			return courseList;
		}
}
