package learning.controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Controller
public class HomeController {
		
	@RequestMapping("/")
		public String home() {
			System.out.println("this is home url");
			return "index";
		}
		
	@RequestMapping("/Upload")
	public String fileForm() {
		System.out.println("this is home url");
		return "fileUpload";
	}
	
	@RequestMapping("/home/{id}")
	public String getUserDestail(@PathVariable("id") int userid) {
		System.out.println(userid);
		return "index";
	}
	
	@RequestMapping(path="/uploadimage",method=RequestMethod.POST)
	public String fileupload(@RequestParam("file") CommonsMultipartFile file,HttpSession s,Model m)  {
		System.out.println("file upload handler");
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		//many method on file
		byte[] data =file.getBytes();
		
	String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"image"+File.separator+
				File.separator+file.getOriginalFilename();
		System.out.println(path);
	/*try {	FileOutputStream fos = new FileOutputStream(path);
		fos.write(data);
		fos.close();
			m.addAttribute("msg", "uploaded successfully");
			m.addAttribute("filename",file.getOriginalFilename());
	}catch(IOException e) {
			e.printStackTrace();
			m.addAttribute("msg", "uploaded error");
			System.out.println("uploading error");
		}*/
		System.out.println("file upload success fully");
		
		return "filesuccess";
	}
}
