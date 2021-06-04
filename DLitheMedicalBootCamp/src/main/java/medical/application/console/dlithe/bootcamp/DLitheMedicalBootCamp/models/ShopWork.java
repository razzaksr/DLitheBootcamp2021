package medical.application.console.dlithe.bootcamp.DLitheMedicalBootCamp.models;

public interface ShopWork 
{
	public void placeNewOrder(Medicine object);
	public Double sale();
	public String ToString();
	public int reportBySale();
	public int reportByQuantity();
	public String findByPurpose(String purpose);
	public String findByName(String name);
}
