package learning.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import learning.Entity.Course;
import learning.Entity.Instructor;
import learning.Entity.Login;
import learning.services.CourseService;

@Controller
@SessionAttributes("USERNAME")
public class CourseController {
	@Autowired
	private InstructorsController instructor;
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/handle-course", method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute Course course,Model m) {
		String msg= this.courseService.saveCourse(course);
		if(msg.equals("Course already Exist"))
		{
			 m.addAttribute("msg","Course already Exist");
			  return "courseForm";
		}
		System.out.println("course add :" + course);
	     return "forward:showCourses";
	}
	
	
	@RequestMapping("/showCourses")
	public String showCourses(Model m,HttpServletRequest req){
		Instructor I = instructor.getUser();
		List<Course> list =this.courseService.getAllCourses(I.getId());
		 m.addAttribute("courselist",list);
		return "showCourses";
	}
	
	
	@RequestMapping("/courseForm")
	public String courseForm(){
		return "courseForm";
	}
	
	@RequestMapping("/Home")
	public String home(HttpServletRequest req){
		return "Home";
	}
}
