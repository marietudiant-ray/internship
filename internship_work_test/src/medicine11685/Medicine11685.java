package medicine11685;

public class Medicine11685 {
	
	public String fh_date;
	public double tot_price;
	
	public Medicine11685(String fh_date,double tot_price)
	{
		this.fh_date=fh_date;
		this.tot_price=tot_price;
	}
	
	public String getDate()
	{
		return this.fh_date;
	}
	
	public double getPrice()
	{
		return this.tot_price;
	}

}
