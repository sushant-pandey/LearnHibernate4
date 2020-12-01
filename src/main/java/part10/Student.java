package part10;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToMany
	private List<Laptop> studentLaptops = new ArrayList<Laptop>();
	
	public Student(int rollNum, String studentName, int marks) {
		super();
		this.rollNum = rollNum;
		this.studentName = studentName;
		this.marks = marks;
	}

	public List<Laptop> getStudentLaptops() {
		return studentLaptops;
	}

	public void setStudentLaptops(List<Laptop> studentLaptops) {
		this.studentLaptops = studentLaptops;
	}

	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum 
				+ ", studentName=" + studentName 
				+ ", marks=" + marks + "]";
	}
	
	
}
