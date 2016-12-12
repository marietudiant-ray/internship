package yaopin;

public class Medicine3 implements Comparable{
	
	public int medicine_id;
	public Double medicine_price;
	public Integer medicine_amount;
	
	public Medicine3(int medicine_id,double medicine_price, int medicine_amount)
	{
		this.medicine_id=medicine_id;
		this.medicine_price=medicine_price;
		this.medicine_amount=medicine_amount;
	}
	
	public int getMedicineId()
	{
		return this.medicine_id;
	}
	 
	public double getMedicinePrice()
	{
		return this.medicine_price;
	}

	public int getMedicineAmount()
	{
	  return this.medicine_amount;
	}

	@Override
	public int compareTo(Object o) {
		Medicine3 medicine3=(Medicine3) o;
		return this.medicine_price.compareTo(medicine3.getMedicinePrice());
	}
	
	
}
