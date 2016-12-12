package yaopin;

@SuppressWarnings("rawtypes")
public class Medicine implements Comparable{
	public Integer  medicine_id;
	public Integer  quantity_sc_fac;

	
	public Medicine(int medicine_id, int quantity_sc_fac)
	{
		this.medicine_id=medicine_id;
		this.quantity_sc_fac=quantity_sc_fac;
	}
	
	
	

	public int getMedicineId()
	{
		return this.medicine_id;
	}
	public int getquantitysc()
	{
		return this.quantity_sc_fac;
	}


	@Override
	public int compareTo(Object o) {
		Medicine medicine= (Medicine) o;
		return this.quantity_sc_fac.compareTo(medicine.getquantitysc());
	}
	

  

}
