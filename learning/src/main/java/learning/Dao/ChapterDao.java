package learning.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import learning.Entity.Chapter;
import learning.Entity.Course;

@Repository
public interface ChapterDao {
	
	
    public int addChapter(Chapter chapter) ;
	
    public List<Chapter> getChapters(int instructorId);
	
    public Chapter getChapter(int chapterId);
	
    public void updateChapter(Chapter chapter) ;
	
    public List<Chapter> courseWiseChapter(int courseId);
}
