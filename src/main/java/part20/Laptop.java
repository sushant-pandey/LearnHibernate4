package part20;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LAPTOP")
public class Laptop {
	
	@Id
	@Column(name="ID")
	private int laptopId;
	
	@Column(name="BRAND")
	private String laptopBrand;
	
	@Column(name="PRICE")
	private int laptopPrice;
	
	public Laptop() {}

	public Laptop(int laptopId, String laptopBrand, int laptopPrice) {
		super();
		this.laptopId = laptopId;
		this.laptopBrand = laptopBrand;
		this.laptopPrice = laptopPrice;
	}

	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId 
				+ ", laptopBrand=" + laptopBrand 
				+ ", laptopPrice=" + laptopPrice 
				+ "]";
	}
	
	
}
