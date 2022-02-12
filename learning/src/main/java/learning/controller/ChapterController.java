package learning.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import learning.Entity.Chapter;
import learning.Entity.Course;
import learning.Entity.Instructor;
import learning.services.ChapterServices;
import learning.services.CourseService;

@Controller
@SessionAttributes("USERNAME")

public class ChapterController {
	
	@Autowired
	private InstructorsController instructor;
	
	@Autowired
	private ChapterServices chapterService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/addChapters/{courseID}")    
    public String chapterForm(@PathVariable("courseID") int id, Model m,HttpServletRequest req){    
    	m.addAttribute("courseid",id);  
        return "chapterForm";    
    }  
	
	@RequestMapping(value="addChapters/handle-chapter",method = RequestMethod.POST)    
	public String addchapter(@ModelAttribute Chapter chapter,Model m) {
		System.out.println("controller se "+chapter);
		this.chapterService.saveChapter(chapter);
		return "forward:showchapter";
		}
	
	@RequestMapping("/showchapter")
	public String  show(Model m) {
	   Instructor I = instructor.getUser();
		System.out.println("-----------------------"+I.getFirstName()+"-------------------------------");
		List<Chapter> chapter =this.chapterService.getAllChapter(I);
		System.out.println("show chapter by instructor :"+chapter);
		m.addAttribute("chapterlist",chapter);
		return  "showChapters";
	}
	
	
	
	
	
}
























