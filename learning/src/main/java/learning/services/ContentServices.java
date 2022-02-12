package learning.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.ContentDao;
import learning.Entity.Chapter;
import learning.Entity.Content;

@Service
public class ContentServices {

		@Autowired
		private ContentDao contentDao;
		
		@Autowired
		private ChapterServices chapterService;
	
	public String saveContent(Content con) {
		String string= this.contentDao.addContent(con);
			if(string.equals("data inserted")) {
				 Chapter chapter=this.chapterService.getChapter(con.getChapterContentId());
				 if(con.getContentType().equals("video/mp4"))
					 chapter.setNumOfVideo(chapter.getNumOfVideo()+1);
				 else
					 chapter.setNumOfReading(chapter.getNumOfReading()+1);
				 this.chapterService.Update(chapter);
				 return "data inserted successfully";
			}
			return "data not inserted!!!";
		}
	
      public List<Content> getAllContentChpterWise(int chapterId){
    	  List<Content> content = this.contentDao.getContent(chapterId);
    	  for(Content c1:content)
    		  	System.out.println("content  service:"+ c1.getContentTitle()+"  chapter id "+c1.getChapterContentId());
    	  	return content;
      }

	public List<Content> getContentInstructorWise(int id) {
	 List<Content> list = this.contentDao.getAllContentByInstructor(id);
		return list;
	}
	
	public List<String[]> getContentCourseWise(int courseId){
		return null;
	}
}
