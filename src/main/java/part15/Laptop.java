package part15;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "studentLaptops")
	private List<Student> student = new ArrayList<Student>();
	
	public Laptop() {}
	
	public Laptop(int laptopId, String laptopBrand) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
	}
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId 
				+ ", laptopBrand=" + laptopBrand + "]";
	}
	
	
}
