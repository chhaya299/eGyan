package learning.Entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="course_id")
	private int courseID;
	
	@Column(name="course_title",nullable=false)
	private String courseTitle;
	
	@Column(name="course_brief",nullable=false)
	private String courseBrief;
	
	@Column(name="instructor_id",nullable=false)
	private int instructorId;
	
	@Column(name="num_of_chapters",nullable=false)
	@ColumnDefault("0")
	private int numOfChapters;
	
	@Column(name="course_fee",nullable=false)
	private int courseFee;

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseBrief() {
		return courseBrief;
	}

	public void setCourseBrief(String courseBrief) {
		this.courseBrief = courseBrief;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public int getNumOfChapters() {
		return numOfChapters;
	}

	public void setNumOfChapters(int numOfChapters) {
		this.numOfChapters = numOfChapters;
	}

	public int getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(int courseFee) {
		this.courseFee = courseFee;
	}

	public Course(int courseID, String courseTitle, String courseBrief, int instructorId, int numOfChapters,
			int courseFee) {
		super();
		this.courseID = courseID;
		this.courseTitle = courseTitle;
		this.courseBrief = courseBrief;
		this.instructorId = instructorId;
		this.numOfChapters = numOfChapters;
		this.courseFee = courseFee;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseTitle=" + courseTitle + ", courseBrief=" + courseBrief
				+ ", instructorId=" + instructorId + ", numOfChapters=" + numOfChapters + ", courseFee=" + courseFee
				+ "]";
	}
	
	
}
