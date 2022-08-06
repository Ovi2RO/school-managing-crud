package student.crud.dao;

import java.util.List;

import student.crud.beans.Student;


public interface StudentDAO {
	
	public boolean addStudent(Student student);
		
	public boolean updateStudent(Student student);
		
	public boolean deleteStudent(int idStudent);
	
	public List<Student> getAllStudents();
	
	public Student getStudent(int idStudent);	
}
