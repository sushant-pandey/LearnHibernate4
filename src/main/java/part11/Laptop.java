package part11;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LAPTOP_DETAILS")
public class Laptop {
	@Id
	@Column(name = "LAPTOP_ID")
	private int laptopId;
	
	@Column(name = "LAPTOP_BRAND")
	private String laptopBrand;
	
	@ManyToOne
	private Student student;
	
	public Laptop(int laptopId, String laptopBrand) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId 
				+ ", laptopBrand=" + laptopBrand + "]";
	}
	
	
}
