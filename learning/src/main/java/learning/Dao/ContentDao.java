package learning.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import learning.Entity.Content;
import learning.Entity.Instructor;

@Repository
public interface ContentDao {
		
	public String addContent(Content content);
	
	public List<Content> getContent(int chapterId);
	
	public Content singleGetContent(int contentId);
	
	public List<Content> getAllContent();
	
	public List<Content> getAllContentByInstructor(int id);
	
	public List<String[]> getAllContentByChapterByCourse(int courseId);
}
