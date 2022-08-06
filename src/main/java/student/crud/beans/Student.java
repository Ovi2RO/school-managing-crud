package student.crud.beans;

import java.util.Objects;

public class Student {
	private int idStudent;
	private String studentFirstName;
	private String studentLastName;
	private String studentAddress;
	private String studentEmail;
	private String studentPhone;
	
	private Double studentTotalFee;
	private Double studentPaidFee;
	private Double studentRemainingFee;
	
	
	public Student() {
		super();
	}
	
	public Student(int idStudent, String studentFirstName, String studentLastName, String studentAddress, String studentEmail,
			String studentPhone, Double studentTotalFee, Double studentPaidFee, Double studentRemainingFee) {
		super();
		this.idStudent = idStudent;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAddress = studentAddress;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentTotalFee = studentTotalFee;
		this.studentPaidFee = studentPaidFee;
	}

	public Student(String studentFirstName, String studentLastName, String studentAddress, String studentEmail,
			String studentPhone, Double studentTotalFee, Double studentPaidFee, Double studentRemainingFee) {
		super();
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentAddress = studentAddress;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
		this.studentTotalFee = studentTotalFee;
		this.studentPaidFee = studentPaidFee;
	}

	public Student(String studentFirstName, String studentLastName, String studentPhone, Double studentTotalFee,
			Double studentPaidFee) {
		super();
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentPhone = studentPhone;
		this.studentTotalFee = studentTotalFee;
		this.studentPaidFee = studentPaidFee;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	public Double getStudentTotalFee() {
		return studentTotalFee;
	}

	public void setStudentTotalFee(Double studentTotalFee) {
		this.studentTotalFee = studentTotalFee;
	}

	public Double getStudentPaidFee() {
		return studentPaidFee;
	}

	public void setStudentPaidFee(Double studentPaidFee) {
		this.studentPaidFee = studentPaidFee;
	}

	public Double getStudentRemainingFee() {
		return studentRemainingFee;
	}
	
	public void setStudentRemainingFee(Double studentRemainingFee) {
		this.studentRemainingFee = studentRemainingFee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStudent);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return idStudent == other.idStudent;
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentAddress=" + studentAddress + ", studentEmail=" + studentEmail
				+ ", studentPhone=" + studentPhone + ", studentTotalFee=" + studentTotalFee + ", studentPaidFee="
				+ studentPaidFee + ", studentRemainingFee=" + studentRemainingFee + "]";
	}	
}
