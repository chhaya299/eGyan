package learning.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="chapter")
public class Chapter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="chapter_id")
	private int chapterId;
	
	@Column(name="course_id",nullable=false)
	private int chapterCourseId;
	
	@Column(name="chapter_title",nullable=false)
	private String chapterTitle;
	
	@Column(name="num_of_reading",nullable=false)
	@ColumnDefault("0")
	private int numOfReading;
	
	@Column(name="num_of_Video",nullable=false)
	@ColumnDefault("0")
	private int numOfVideo;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public int getChapterCourseId() {
		return chapterCourseId;
	}

	public void setChapterCourseId(int chapterCourseId) {
		this.chapterCourseId = chapterCourseId;
	}

	public String getChapterTitle() {
		return chapterTitle;
	}

	public void setChapterTitle(String chapterTitle) {
		this.chapterTitle = chapterTitle;
	}

	public int getNumOfReading() {
		return numOfReading;
	}

	public void setNumOfReading(int numOfReading) {
		this.numOfReading = numOfReading;
	}

	public int getNumOfVideo() {
		return numOfVideo;
	}

	public void setNumOfVideo(int numOfVideo) {
		this.numOfVideo = numOfVideo;
	}

	public Chapter(int chapterId, int chapterCourseId, String chapterTitle, int numOfReading, int numOfVideo) {
		super();
		this.chapterId = chapterId;
		this.chapterCourseId = chapterCourseId;
		this.chapterTitle = chapterTitle;
		this.numOfReading = numOfReading;
		this.numOfVideo = numOfVideo;
	}

	public Chapter() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Chapter [chapterId=" + chapterId + ", chapterCourseId=" + chapterCourseId + ", chapterTitle="
				+ chapterTitle + ", numOfReading=" + numOfReading + ", numOfVideo=" + numOfVideo + "]";
	}

	
}
