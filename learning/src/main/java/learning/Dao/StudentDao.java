package learning.Dao;

import java.util.List;

import org.springframework.stereotype.Service;

import learning.Entity.Student;

@Service
public interface StudentDao {

	public String addStudent(Student student);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudent();
	
	public void updateStudent(Student student);
	
	public Student validUser(String email);
}
