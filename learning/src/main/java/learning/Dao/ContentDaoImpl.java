package learning.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import learning.Entity.Content;
import learning.Entity.Instructor;
@Component
public class ContentDaoImpl implements ContentDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility  hiber;
	
	@Transactional
	public String addContent(Content content) {
		 
		int i = (Integer) this.hibernateTemplate.save(content);
		if(i>0)
				return "data inserted";
		return "Content not inserted";
	}

	public List<Content> getContent(int chapterId) {
		Session session=this.hiber.getQuery();
		Query query =session.createQuery("from Content where chapterContentId=:cid",Content.class);
		query.setParameter("cid", chapterId);
		List<Content> list =query.getResultList();
	    return list;
	}

	public Content singleGetContent(int contentId) {
		Content content = this.hibernateTemplate.get(Content.class, contentId);
		return null;
	}

	public List<Content> getAllContent() {
		List<Content> list=this.hibernateTemplate.loadAll(Content.class);
		return list;
	}

	public List<Content> getAllContentByInstructor(int id) {
		Session session =hiber.getQuery();
		String q ="select content.content_id,content.content_type,content.chapter_content_id,"
				+ "content.content_title ,content.FILE_DATA from"
				+ " course ,chapter,content where "
				+ "content.chapter_content_id = chapter.chapter_id and "
				+ "chapter.course_id = course.course_id and "
				+ "course.instructor_id=?;";
		Query query  = session.createNativeQuery(q);
		query.setParameter(1, id);
		List<Object[]> l = null;
	try {
		l =query.getResultList();
	}catch(SQLGrammarException sql) {
		return null;
	}
		List<Content> content = new ArrayList<Content>();
		
		for(Object[] obj:l) {
			Content content1 = new Content();
			content1.setContentId((Integer)obj[0]);
			content1.setContentTitle((String)obj[3]);
			content1.setChapterContentId((Integer)obj[2]);
			content1.setContentType((String)obj[1]);
			content1.setData((byte[])obj[4]);
			content.add(content1);
		}
	  return content;
	}

	public List<String[]> getAllContentByChapterByCourse(int courseId) {
		//course innerjoin with chapter their result inner join with content course name chapter name content type content file.
		String q ="select content.content_id,chapter.chapter_id,course.course_id "
				+ "content.content_type ,chapter.chapter_title ,course_title from"
				+ " course ,chapter,content,instructor where "
				+ "content.chapter_content_id = chapter.chapter_id and "
				+ "chapter.course_id = course.course_id and "
				+ "course.instructor_id=?";
		
		return null;
	}

}
