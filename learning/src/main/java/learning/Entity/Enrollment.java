package learning.Entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enrollment")
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="enrollment_id")
	private int enrollmentId;
	
	@Column(name="enrollment_student_id",nullable=false)
	private int enrollStudentId;
	
	@Column(name = "enrollment_course_id",nullable=false)
	private int enrollCourseId;
	
	@Column(name="enrollment_date",nullable=false)
	private Date enrollDate=Date.valueOf(LocalDate.now());

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public int getEnrollStudentId() {
		return enrollStudentId;
	}

	public void setEnrollStudentId(int enrollStudentId) {
		this.enrollStudentId = enrollStudentId;
	}

	public int getEnrollCourseId() {
		return enrollCourseId;
	}

	public void setEnrollCourseId(int enrollCourseId) {
		this.enrollCourseId = enrollCourseId;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Enrollment(int enrollmentId, int enrollStudentId, int enrollCourseId, Date enrollDate) {
		super();
		this.enrollmentId = enrollmentId;
		this.enrollStudentId = enrollStudentId;
		this.enrollCourseId = enrollCourseId;
		this.enrollDate = enrollDate;
	}

	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Enrollment [enrollmentId=" + enrollmentId + ", enrollStudentId=" + enrollStudentId + ", enrollCourseId="
				+ enrollCourseId + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
