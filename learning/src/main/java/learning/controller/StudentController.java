package learning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learning.Entity.Course;
import learning.Entity.Enrollment;
import learning.Entity.Login;
import learning.Entity.Student;
import learning.services.CourseService;
import learning.services.StudentServices;

@Controller
public class StudentController {

	public HttpSession session =null; 
	
	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private CourseService courseServices;
	
	@RequestMapping("/register-student")
	public String register() {
		return "registerFormStudent";
	}
	
	@RequestMapping(value= "/handle-register-student", method = RequestMethod.POST)
	public String registerHandler(@ModelAttribute Student student,Model m) {
	   String st =	this.studentServices.saveStudent(student);
	   if(!st.equals("data inserted"))
		{
		   m.addAttribute("msg","Student Already  Registered !");
		   return "registerFormStudent";
	     }
		return "LoginStudent";	
	}
	
	@RequestMapping("/login-student")
	public String login() {
		return "LoginStudent";
	}
	
	//loginform action
	@RequestMapping(value="/handle-loginStudent",  method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute Login login,HttpServletRequest req,Model m) {
		// verify login and to  then go to student homes
		Student student = this.studentServices.validate(login);
		if(student!=null) {
		 session = req.getSession();
	     session.setAttribute("stud", student);
	   
	     List<Course> list =	this.courseServices.getCourses();
	 	System.out.println("student home page"+list);
	 	m.addAttribute("courseList1", list);
	 		return "forward:student";
	     }
			m.addAttribute("msg", "please Enter Correct Email and Password! ");
			return "LoginStudent";
	}
	
	
	//student home page
	@RequestMapping(value="/student",method = RequestMethod.POST)
	public String studentHome(Model m) {
	List<Course> list =	this.courseServices.getCourses();
	System.out.println("student home page"+list);
	m.addAttribute("List", list);
	m.addAttribute("student1",getUser());
		return "studentHome";
	}
	
	public Student getUser() {
    	return (Student) session.getAttribute("stud");
    }
	
	
	
	//enroll student 
	@RequestMapping(value="/enrollStudent/{courseID}")    
    public String chapterForm(@PathVariable("courseID") int id, Model m){    
           Student student = getUser();
          Enrollment enroll = new Enrollment();
          enroll.setEnrollStudentId(student.getStudentId());
          enroll.setEnrollCourseId(id);
          this.studentServices.addenrollStudent(enroll);
        return "";    
    } 
	
	
}
