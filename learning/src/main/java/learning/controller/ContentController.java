package learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import learning.Dao.HibernateQueryUtility;
import learning.Entity.Content;
import learning.Entity.Instructor;
import learning.services.ContentServices;
import learning.services.CourseService;
@Controller
@SessionAttributes(names="USERNAME")
public class ContentController {
	
	private int chapterid=0;
	@Autowired
	private InstructorsController instructor;
	
	@Autowired
	private ContentServices contentService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private HibernateQueryUtility hiber;
	
	@RequestMapping(value="/addContents/{chapterId}")  
	public String content(@PathVariable("chapterId") int id,Model m){
		System.out.println("chapter Ids "+id);
	//	this.chapterid = id;
		m.addAttribute("chapterId",id);  
        return "contentForm";  
	}
	
	@RequestMapping(value="addContents/handle-content",method = RequestMethod.POST)
	public String actionContent(@RequestParam("contentType") String contentType,
			@RequestParam("contentTitle") String contentTitle,
			@RequestParam("chapterContentId") int chapterContentId,
			@RequestParam("data") CommonsMultipartFile file
			,Model m)
	{
		Content content = new Content();
		content.setContentType(file.getContentType());
		content.setContentTitle(contentTitle);
		content.setChapterContentId(chapterContentId);
		content.setData(file.getBytes());
		
		String msg	= this.contentService.saveContent(content);
		System.out.println("handler content"+msg);
		if(msg.equals("data inserted successfully")) {
		List<Content> content1 =	this.contentService.getAllContentChpterWise(chapterContentId);
			m.addAttribute("content", content1);
			return "redirect:/showContent";
		}
		return "redirect:contentForm";
	}
	
	@RequestMapping("/showContent")
	public String Showcontent(Model m) {
	Instructor I = instructor.getUser();
	List<Content> content1 =this.contentService.getContentInstructorWise(I.getId());
	List<Content> original =this.hiber.convertContent(content1); 
	
	System.out.println("----------------------------------------------------");
	for(Content ch: original)
		System.out.println(ch.getFileName());
	if(content1!=null)
		{
		m.addAttribute("content", original);
	
		}
	else
		m.addAttribute("msg","Something Wrong !!");
		return "showContentChapterWise";
		
	}
	
	
}
