package learning.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import learning.Entity.Chapter;
import learning.Entity.Content;
import learning.services.StudentServices;

@Controller
public class StudentSideCourse {
	
	@Autowired
	private StudentServices studentService;
	
	// After click open  course then show details......
		@RequestMapping(value="/showDetail/{courseID}")    
	    public String chapterForm(@PathVariable("courseID") int id, Model m){    
			Map<Chapter,List<Content>> map=this.studentService.getData(id);
			m.addAttribute("map",map);
	        return "courseDetailStudentSide";    
	    } 
	
}
