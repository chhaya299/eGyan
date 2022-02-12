package learning.Entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name="instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "instructor_id", nullable = false)
	private int id;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "email_id", nullable = false)
	private String email;
	@Column(name = "registration_date", nullable = false)
	private Date registrationDate = Date.valueOf(LocalDate.now());
	

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", registrationDate=" + registrationDate + ", qualification=" + qualification
				+ ", numOfPublishedCourses=" + numOfPublishedCourses + ", numOfEnrolledStudents="
				+ numOfEnrolledStudents + "]";
	}

	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Instructor(int id, String firstName, String lastName, String email, Date registrationDate,
			String qualification, int numOfPublishedCourses, int numOfEnrolledStudents) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.registrationDate = registrationDate;
		this.qualification = qualification;
		this.numOfPublishedCourses = numOfPublishedCourses;
		this.numOfEnrolledStudents = numOfEnrolledStudents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getNumOfPublishedCourses() {
		return numOfPublishedCourses;
	}

	public void setNumOfPublishedCourses(int numOfPublishedCourses) {
		this.numOfPublishedCourses = numOfPublishedCourses;
	}

	public int getNumOfEnrolledStudents() {
		return numOfEnrolledStudents;
	}

	public void setNumOfEnrolledStudents(int numOfEnrolledStudents) {
		this.numOfEnrolledStudents = numOfEnrolledStudents;
	}

	@Column(name = "Qualification", nullable = false)
	private String qualification;
	@Column(name = "num_of_published_courses", nullable = false)
	@ColumnDefault("0")
	private int numOfPublishedCourses;
	@Column(name = "num_of_entrolled_student", nullable = false)
	@ColumnDefault("0")
	private int numOfEnrolledStudents;
}
