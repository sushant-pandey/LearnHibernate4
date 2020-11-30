package part2;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Alien {
	
	@Id
	private int alienId;
	private String alienName;
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
