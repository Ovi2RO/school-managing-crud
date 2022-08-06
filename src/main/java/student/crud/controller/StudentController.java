package student.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.crud.beans.Student;
import student.crud.dao.StudentDAO;
import student.crud.dao.StudentDAOImpl;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDAO studentDAO = null;
    
    public StudentController() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	
    	studentDAO = new StudentDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("StudentController - doPost() Started!");
		
		String action = request.getServletPath();
		System.out.println("doPost Action: " + action);
		
		switch (action) {
			case "/add":
				addNewStudent(request, response);
				break;
				
			case "/update":
				updateStudent(request, response);
				break;
	
			case "/delete":
				deleteStudent(request, response);
				break;
			
			case "/list":
				getAllStudents(request, response);
				break;
			
			case "/get":
				getStudent(request, response);
				break;
			
			default:
				getAllStudents(request, response);
				break;
		}
	}

	private void getStudent(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getStudent");
		
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		System.out.println("getStudent, Student Id: " + idStudent);
		
		Student student = studentDAO.getStudent(idStudent);
		System.out.println("getStudent, Student is: " + student);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentsView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

	private void getAllStudents(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start getAllStudents");
		
		List<Student> students = studentDAO.getAllStudents();
		System.out.println("getAllStudents, students size: " + students.size());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentsView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start deleteStudent");
		
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		
		boolean result = studentDAO.deleteStudent(idStudent);
		System.out.println("deleteStudent, result is: " + result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/StudentsView.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start updateStudent");
		
		int idStudent = Integer.parseInt(request.getParameter("idStudent"));
		String studentFirstName = request.getParameter("studentFirstName");
		String studentLastName = request.getParameter("studentLastName");
		String studentAddress = request.getParameter("studentAddress");
		String studentEmail = request.getParameter("studentEmail");
		String studentPhone = request.getParameter("studentPhone");
		Double studentTotalFee = Double.parseDouble(request.getParameter("studentTotalFee"));
		Double studentPaidFee = Double.parseDouble(request.getParameter("studentPaidFee"));
		Double studentRemainingFee = Double.parseDouble(request.getParameter("studentRemainingFee"));
		
		Student student = new Student(idStudent, studentFirstName, studentLastName, studentAddress, studentEmail, studentPhone, studentTotalFee, studentPaidFee, studentRemainingFee);
		System.out.println("updateStudent, Student details: " + student);
		
		boolean result = studentDAO.updateStudent(student);
		System.out.println("updateStudent, result is: " + result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentsView");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}

	private void addNewStudent(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Start addNewStudent");
		
		String studentFirstName = request.getParameter("studentFirstName");
		String studentLastName = request.getParameter("studentLastName");
		String studentAddress = request.getParameter("studentAddress");
		String studentEmail = request.getParameter("studentEmail");
		String studentPhone = request.getParameter("studentPhone");
		Double studentTotalFee = Double.parseDouble(request.getParameter("studentTotalFee"));
		Double studentPaidFee = Double.parseDouble(request.getParameter("studentPaidFee"));
		Double studentRemainingFee = Double.parseDouble(request.getParameter("studentRemainingFee"));
		
		Student student = new Student(studentFirstName, studentLastName, studentAddress, studentEmail, studentPhone, studentTotalFee, studentPaidFee, studentRemainingFee);
		System.out.println("addNewStudent, Student details: " + student);
		
		boolean result = studentDAO.addStudent(student);
		System.out.println("addNewStudent, result is: " + result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studentsView");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}		
	}
}
