package part7;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlienName {
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String midName;
	
	public AlienName() {
	}
	
	public AlienName(String firstName, String lastName, String midName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.midName = midName;
	}

	@Override
	public String toString() {
		return "AlienName [firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", midName=" + midName + "]";
	}
	
	
}
