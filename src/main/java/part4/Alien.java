package part4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Alien_Det")
public class Alien {
	
	@Id
	@Column(name="Alien_Id")
	private int alienId;
	
	@Column(name="Alien_Name")
	private String alienName;
	
	@Column(name="Alien_Color")
	private String alienColor;
	
	public int getAlienId() {
		return alienId;
	}
	public void setAlienId(int alienId) {
		this.alienId = alienId;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	public String getAlienColor() {
		return alienColor;
	}
	public void setAlienColor(String alienColor) {
		this.alienColor = alienColor;
	}	
}
