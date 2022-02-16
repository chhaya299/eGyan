package learning.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.EnrollmentDao;
import learning.Dao.HibernateQueryUtility;
import learning.Dao.LoginDao;
import learning.Dao.StudentDao;
import learning.Entity.Chapter;
import learning.Entity.Content;
import learning.Entity.Course;
import learning.Entity.Enrollment;
import learning.Entity.Login;
import learning.Entity.Student;

@Service
public class StudentServices {

	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private EnrollmentDao enroll;
	
	@Autowired
	private  ChapterServices chapterService;
	
	@Autowired
	private  ContentServices contentService;
	
	@Autowired
	private HibernateQueryUtility hiber;
	
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
	
	
	public String addenrollStudent(Enrollment enroll) {
			return	this.enroll.enrollStudent(enroll);
	}
	
	
	//student enroll courses data find
	public  List<Course> courseFiterByEnrollment(int studentID){
		List<Enrollment> enroll = this.enroll.getEnrollStudentsByStudent(studentID);
		List<Course> course = new ArrayList<Course>();
		for(Enrollment e :enroll) {
				course.add(this.courseService.getSingleCourse(e.getEnrollCourseId()));
		}
		 return course;
	}
	
	
	//get Single Student by id
	
	public Student getSingleStudent(int id){
			return this.studentDao.getStudent(id);
	}

	//update Student data
	public void updateStudent(Student s) {
		 this.studentDao.updateStudent(s);
	}
	
	//map create using content chapter wise.....
	public Map<Chapter,List<Content>> getData(int courseId){
	List<Chapter> chapterlist =  this.chapterService.getChapterCourseWise(courseId);
	Map<Chapter,List<Content>> map = new HashMap<Chapter, List<Content>>();
	for(Chapter ch:chapterlist) {
	List<Content> content =	this.contentService.getAllContentChpterWise(ch.getChapterId());
	 map.put(ch, content);
	}
	System.out.println("------------------------------------------------");
	System.out.println("map contains chapter wist content list "+map);
	
      return map;
	}
	
}
