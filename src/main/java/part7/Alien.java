package part7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="Alien_Details")
public class Alien {
	
	@Id
	@Column(name="Alien_Id")
	private int alienId;
	
	private AlienName alienName;
	
	@Column(name="Alien_Color")
	private String alienColor;	
	
	public Alien(int alienId, AlienName alienName, String alienColor) {
		super();
		this.alienId = alienId;
		this.alienName = alienName;
		this.alienColor = alienColor;
	}

	@Override
	public String toString() {
		return "Alien [alienId=" + alienId 
				+ ", alienName=" + alienName 
				+ ", alienColor=" + alienColor + "]";
	}
	
	
}
