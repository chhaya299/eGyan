package learning.Entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="student_id")
	private int studentId;
	
	@Column(name="first_name" ,nullable=false)
	private String firstName;
	
	@Column(name="last_name" ,nullable=false)
	private String lastName;
	
	@Column(name="email" ,nullable=false,unique = true)
	private String email;
	
	@Column(name="registration",nullable=false)
	private Date  registration=Date.valueOf(LocalDate.now());
	
	@Column(name="num_of_course_enrolled",nullable =false)
	@ColumnDefault("0")
	private int numOfCoursesEnrolled;
	
	@Column(name="num_of_course_completed",nullable =false)
	@ColumnDefault("0")
	private int NumOfCourseCompleted;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}

	public int getNumOfCoursesEnrolled() {
		return numOfCoursesEnrolled;
	}

	public void setNumOfCoursesEnrolled(int numOfCoursesEnrolled) {
		this.numOfCoursesEnrolled = numOfCoursesEnrolled;
	}

	public int getNumOfCourseCompleted() {
		return NumOfCourseCompleted;
	}

	public void setNumOfCourseCompleted(int numOfCourseCompleted) {
		NumOfCourseCompleted = numOfCourseCompleted;
	}

	public Student(int studentId, String firstName, String lastName, String email, Date registration,
			int numOfCoursesEnrolled, int numOfCourseCompleted) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.registration = registration;
		this.numOfCoursesEnrolled = numOfCoursesEnrolled;
		NumOfCourseCompleted = numOfCourseCompleted;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", registration=" + registration + ", numOfCoursesEnrolled=" + numOfCoursesEnrolled
				+ ", NumOfCourseCompleted=" + NumOfCourseCompleted + "]";
	}
	
	
	
}
