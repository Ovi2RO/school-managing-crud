package student.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import school.crud.db.DBConnection;
import student.crud.beans.Student;

public class StudentDAOImpl implements StudentDAO {
	
	private static Connection connection = DBConnection.connection;

	@Override
	public boolean addStudent(Student student) {
		System.out.println("Start add");
		
		try {
			String insertStatement = "INSERT INTO school_schema.students(studentFirstName, studentLastName, studentAddress, studentEmail, studentPhone, studentTotalFee, studentPaidFee) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, student.getStudentFirstName());
			preparedStatement.setString(2, student.getStudentLastName());
			preparedStatement.setString(3, student.getStudentAddress());
			preparedStatement.setString(4, student.getStudentEmail());
			preparedStatement.setString(5, student.getStudentPhone());
			preparedStatement.setDouble(6, student.getStudentTotalFee());
			preparedStatement.setDouble(7, student.getStudentPaidFee());
			
			int result = preparedStatement.executeUpdate();
			return result == 1? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student student) {
		System.out.println("Start update");
		
		try {
			String insertStatement = "UPDATE school_schema.students set studentFirstName = ?, studentLastName = ?, studentAddress = ?, studentEmail = ?, studentPhone = ?, studentTotalFee = ?, studentPaidFee = ? WHERE idStudent = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setString(1, student.getStudentFirstName());
			preparedStatement.setString(2, student.getStudentLastName());
			preparedStatement.setString(3, student.getStudentAddress());
			preparedStatement.setString(4, student.getStudentEmail());
			preparedStatement.setString(5, student.getStudentPhone());
			preparedStatement.setDouble(6, student.getStudentTotalFee());
			preparedStatement.setDouble(7, student.getStudentPaidFee());
			preparedStatement.setInt(8, student.getIdStudent());
			
			int result = preparedStatement.executeUpdate();
			return result == 1? true : false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteStudent(int idStudent) {
		System.out.println("Start delete");
		
		try {
			String insertStatement = "DELETE FROM school_schema.students WHERE idStudent = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, idStudent);
			
			int result = preparedStatement.executeUpdate();
			return result == 1? true : false;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		System.out.println("Start getAll");
		
		try {
			String insertStatement = "SELECT * FROM school_schema.students";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Student> students = new ArrayList<Student>();
			
			while (resultSet.next()) {
				Student student = new Student();
				
				student.setIdStudent(resultSet.getInt("idStudent"));
				student.setStudentFirstName(resultSet.getString("studentFirstName"));
				student.setStudentLastName(resultSet.getString("studentLastName"));
				student.setStudentAddress(resultSet.getString("studentAddress"));
				student.setStudentEmail(resultSet.getString("studentEmail"));
				student.setStudentPhone(resultSet.getString("studentPhone"));
				student.setStudentTotalFee(resultSet.getDouble("studentTotalFee"));
				student.setStudentPaidFee(resultSet.getDouble("studentPaidFee"));
				student.setStudentRemainingFee(resultSet.getDouble("studentRemainingFee"));
				
				students.add(student);
			}
			
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Student getStudent(int idStudent) {
		System.out.println("Start getOne");
		
		try {
			String insertStatement = "SELECT * FROM school_schema.students WHERE idStudent = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);
			preparedStatement.setInt(1, idStudent);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			Student student = new Student();
			
			while (resultSet.next()) {
				
				student.setIdStudent(resultSet.getInt("idStudent"));
				student.setStudentFirstName(resultSet.getString("studentFirstName"));
				student.setStudentLastName(resultSet.getString("studentLastName"));
				student.setStudentAddress(resultSet.getString("studentAddress"));
				student.setStudentEmail(resultSet.getString("studentEmail"));
				student.setStudentPhone(resultSet.getString("studentPhone"));
				student.setStudentTotalFee(resultSet.getDouble("studentTotalFee"));
				student.setStudentPaidFee(resultSet.getDouble("studentPaidFee"));
				student.setStudentRemainingFee(resultSet.getDouble("studentRemainingFee"));
			}
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
