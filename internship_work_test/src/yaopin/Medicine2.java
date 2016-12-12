package yaopin;

@SuppressWarnings("rawtypes")
public class Medicine2 implements Comparable{

	public Integer  medicine_id;
	public Double  medicine_total_price;
	
	public Medicine2(int medicine_id, double medicine_total_price)
	{
		this.medicine_id=medicine_id;
		this.medicine_total_price=medicine_total_price;
	}
	
	
	public double getMedicineTotalPrice()
	{
		return this.medicine_total_price;
	}
	
	public int getMedicineId()
	{
		return this.medicine_id;
	}
	@Override
	public int compareTo(Object o) {
		Medicine2 medicine2= (Medicine2) o;
		return this.medicine_total_price.compareTo(medicine2.getMedicineTotalPrice());
	}
	
}
