package yaopin;

@SuppressWarnings("rawtypes")
public class Medicine4 implements Comparable{
	
	public int yp_id;
	public Double yp_variance;
	public int yp_number;
	
	public Medicine4(int yp_id, double yp_variance,int yp_number)
	{
		this.yp_id=yp_id;
		this.yp_variance=yp_variance;
		this.yp_number=yp_number;
	}
	
	public int getMedicineId()
	{
		return this.yp_id;
	}
	
	public double getMedicineVariance()
	{
		return this.yp_variance;
	}
	
	public int getMedicineNumber()
	{
		return this.yp_number;
	}
	

	@Override
	public int compareTo(Object o) {
		Medicine4 medicine4=(Medicine4) o;
		return this.yp_variance.compareTo(medicine4.getMedicineVariance());
	}
}
