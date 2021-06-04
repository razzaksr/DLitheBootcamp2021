package medical.application.console.dlithe.bootcamp.DLitheMedicalBootCamp.models;

import java.util.Arrays;
import java.util.Date;

public class Medicine 
{
	private String name, brand;
	private String[] purpose;
	private Integer quantity, cost;
	private Date expiry;
	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Medicine(String name, String brand, String[] purpose, Integer quantity, Integer cost, Date expiry) {
		super();
		this.name = name;
		this.brand = brand;
		this.purpose = purpose;
		this.quantity = quantity;
		this.cost = cost;
		this.expiry = expiry;
	}
	@Override
	public String toString() {
		return "Medicine [name=" + name + ", brand=" + brand + ", purpose=" + Arrays.toString(purpose) + ", quantity="
				+ quantity + ", cost=" + cost + ", expiry=" + expiry + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String[] getPurpose() {
		return purpose;
	}
	public void setPurpose(String[] purpose) {
		this.purpose = purpose;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
}
