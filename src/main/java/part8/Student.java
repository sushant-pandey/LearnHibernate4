package part8;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DETAILS")
public class Student {
	
	@Id
	@Column(name = "ROLL_NUMBER")
	private int rollNum;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@Column(name = "STUDENT_MARKS")
	private int marks;
	
	public Student(int rollNum, String studentName, int marks) {
		super();
		this.rollNum = rollNum;
		this.studentName = studentName;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum 
				+ ", studentName=" + studentName 
				+ ", marks=" + marks + "]";
	}
	
	
}
