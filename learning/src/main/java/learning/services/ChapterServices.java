package learning.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.Dao.ChapterDao;
import learning.Entity.Chapter;
import learning.Entity.Course;
import learning.Entity.Instructor;

@Service
public class ChapterServices {

	@Autowired
	private ChapterDao chapterDao;
	@Autowired
	private CourseService courseService;

	//save chapter data...
	public void saveChapter(Chapter chapter) {
		System.out.println("save and update chapter and course");
		int i = (Integer) this.chapterDao.addChapter(chapter);
		if (i != 0) {
			Course course1 = (Course) this.courseService.getSingleCourse(chapter.getChapterCourseId());
			course1.setNumOfChapters(course1.getNumOfChapters() + 1);
			this.courseService.saveOrUpadte(course1);
			System.out.println("save and update chapter and course");
		}

	}

	public List<Chapter> getAllChapter(Instructor i) {
			List<Chapter> list = (List<Chapter>) this.chapterDao.getChapters(i.getId());
		return list;
	}

	public Chapter getChapter(int chId) {
		Chapter chapter = this.chapterDao.getChapter(chId);
		return chapter;
	}

	public void Update(Chapter ch) {
		this.chapterDao.updateChapter(ch);
	}

	public List<Chapter> getChapterCourseWise(int courseId){
		return this.chapterDao.courseWiseChapter(courseId);
	}
}
