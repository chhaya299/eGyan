package learning.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import learning.Entity.Chapter;

@Component
public class ChapterImpl  implements ChapterDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private HibernateQueryUtility hiber;
	
	private Chapter chapterImpl;
	//add chapter
	
	@Transactional
	public int addChapter(Chapter chapter) {
			
			int i = (Integer)this.hibernateTemplate.save(chapter);
			if(i!=0)
				System.out.println("chapter add :"+chapter);
			return i;
	}
	
	
	//get all chapter instructor wise.
	public List<Chapter> getChapters(int instructorId){
		 //for nested Query instructor wise course and chapter show
		
		String q  = "select chapter_id,chapter.course_id,chapter_title,num_of_reading,num_of_Video from chapter inner join (select course_id from course where instructor_id=?) course_instructor on chapter.course_id=course_instructor.course_id;";
		
		Session session = this.hiber.getQuery();
		Query query = session.createNativeQuery(q);
		query.setParameter(1, instructorId);
		List<Object[]> olist = query.getResultList();
		List<Chapter> list = new ArrayList<Chapter>();
		for(Object[] l:olist) {
			chapterImpl =new Chapter();
			chapterImpl.setChapterId((Integer)l[0]);
			chapterImpl.setChapterCourseId((Integer)l[1]);
			chapterImpl.setChapterTitle((String)l[2]);
			chapterImpl.setNumOfReading((Integer)l[3]);
			chapterImpl.setNumOfVideo((Integer)l[4]);
			list.add(chapterImpl);
			}
		System.out.println("chapter dao data is:"+list.get(0).getChapterId()+" "+list.get(0).getChapterCourseId()+" "+list.get(0).getChapterTitle());
			return list;
	}
	
	public Chapter getChapter(int Cid){
			 Chapter chapter = this.hibernateTemplate.get(Chapter.class, Cid);
		 	return chapter;
	}
	
	@Transactional
	public void updateChapter(Chapter chapter) {
		this.hibernateTemplate.saveOrUpdate(chapter);
	}


	public List<Chapter> courseWiseChapter(int courseId) {
		
		Session session = this.hiber.getQuery();
		
		Query query = session.createQuery("from Chapter where chapterCourseId=:courseId",Chapter.class);
		query.setParameter("courseId", courseId);
		return null;
	}
	
	
}
