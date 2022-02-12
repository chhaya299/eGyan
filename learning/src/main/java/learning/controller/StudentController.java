package learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import learning.Entity.Login;
import learning.Entity.Student;
import learning.services.StudentServices;

@Controller
public class StudentController {

	private HttpSession session =null; 
	
	@Autowired
	private StudentServices studentServices;
	
	@RequestMapping("/register-student")
	public String register() {
		return "registerFormStudent";
	}
	
	@RequestMapping(value= "/handle-register-student", method = RequestMethod.POST)
	public String registerHandler(@ModelAttribute Student student) {
	
		return "login-student";	
	}
	
	@RequestMapping("/login-student")
	public String login() {
		return "LoginStudent";
	}
	@RequestMapping(value="/handle-loginStudent",  method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute Login login,HttpServletRequest req) {
		// verify login and to  then go to student homes
		Student student = this.studentServices.validate(login);
		if(student!=null) {
		 session = req.getSession();
	     session.setAttribute("student", student);
	     		return "";
	     }
			return "";
	}
	
	public Student getUser() {
    	return (Student) session.getAttribute("student");
    }
	
}
