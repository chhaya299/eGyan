package learning.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import learning.Entity.Instructor;
import learning.Entity.Login;
import learning.services.InstructorServices;

@Controller

public class InstructorsController {

	private HttpSession session = null;
	@Autowired
	InstructorServices instructorSerices;

	
	
	@RequestMapping("/register-instructor")
	public String registeration(Model m) {
		m.addAttribute("title", "add instructor");
		return "register_form_instructor";
	}

	
	
	@RequestMapping("/LoginInstructor")
	public String login(Model m) {
		return "Login";
	}

	
	
	@RequestMapping(value = "/handle-instructor", method = RequestMethod.POST)
	public RedirectView registrationHandler(@ModelAttribute Instructor instructor, HttpServletRequest req) {
		System.out.println(instructor);
		this.instructorSerices.addInstructorService(instructor);
		RedirectView redirectView = new RedirectView();
		// System.out.println(id);
		redirectView.setUrl(req.getContextPath() + "/" + "Login");
		return redirectView;
	}
	
	
	
    @RequestMapping(value = "/handle-login", method = RequestMethod.POST)
	public String loginHandler(@ModelAttribute Login login,HttpServletRequest req,Model m) {
		ModelAndView mws = null;
			Instructor inst = (Instructor) this.instructorSerices.validate(login);
			System.out.println("login result :" + inst);
		    
		if (inst != null) {
			 session = req.getSession();
		     session.setAttribute("USERNAME", inst);
			  m.addAttribute("USERNAME",inst);
			return "forward:showCourses";
			
		} 
		else {
				m.addAttribute("msg","please check your email  and password !!");
				return "Login";
			}
	}

    
    public Instructor getUser() {
    	return (Instructor) session.getAttribute("USERNAME");
    }
}
