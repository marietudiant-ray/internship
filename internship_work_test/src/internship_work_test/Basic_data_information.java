package internship_work_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import yaopin.Medicine3;


public class Basic_data_information {

	 public static void  recover_medicine_price(Analysis analysis) throws SQLException
	 {
		 String sql="select * from 药品价格;";
		 ResultSet result=analysis.connect.query(sql);
		 Analysis.medicine3list=new ArrayList<Medicine3>();
		 result.last();
		 int length=result.getRow();
		 result.first();
		 do{
			 Medicine3 medicine3=new Medicine3(result.getInt(1),result.getDouble(2),result.getInt(3));
			 Analysis.medicine3list.add(medicine3);
		 }while(result.next());
	 }
	 
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void calculate_variance_medicine_price(Analysis analysis, int yp_id)
	 {
		 double variance=0;
		 int count;
		 ArrayList<Double> medicine_price=new ArrayList<Double>();
		 ArrayList<Integer> medicine_amount=new ArrayList<Integer>();
		 for(int i=0;i<Analysis.medicine3list.size();i++)
		 {
			 if(Analysis.medicine3list.get(i).getMedicineId()==yp_id)
			 {
				 medicine_price.add(Analysis.medicine3list.get(i).getMedicinePrice());
				 medicine_amount.add(Analysis.medicine3list.get(i).getMedicineAmount());
			 }
		 }
		 count=medicine_price.size();
		 double avg=0;
		 int count1=0;
		 for(int i=0;i<medicine_price.size();i++)
		 {
			 avg+=medicine_price.get(i)*medicine_amount.get(i);
			 count1+=medicine_amount.get(i);		 
		 }
		 avg=avg/count1;
	     for(int i=0;i<medicine_price.size();i++)
	     {
	    	 variance+=medicine_amount.get(i)*Math.pow((medicine_price.get(i)-avg), 2);
	     }
	     variance=(double)variance/count1;
	     Analysis.yp_number=count;
	     Analysis.yp_variance=variance;
	 }
	 
	 public static double count_total_price_of_medicine(Analysis analysis,int yp_id) throws SQLException
	 {
		 double total_price=0;
		 String sql="select yp_amount,ls_price from 数据 where yp_id="+yp_id+";";
		 ResultSet result=analysis.connect.query(sql);
		 result.last();
		 int length=result.getRow();
		 result.first();
		 int[] amount=new int[length];
		 double[] price=new double[length];
		 int in=0;
		 do{
			 amount[in]=result.getInt(1);
			 price[in]=result.getDouble(2);
			 in++;
		 }while(result.next());
		 for(int i=0;i<amount.length;i++)
		 {
			 total_price+=(double) amount[i]*price[i];
		 }
		 return total_price;
	 }
	 public static int count_amount_sc_yp(Analysis analysis, int yp_id, String sc_fac) throws SQLException
	 {
		 int amount=0;
		 int[] amount2;
		 String sql="select yp_amount from 数据 where yp_id="+yp_id+"&& sc_fac="+"\""+sc_fac+"\""+";";
		 ResultSet result=analysis.connect.query(sql);
		 result.last();
		 int length=result.getRow();
		 result.first();
		 amount2=new int[length];
		 int in=0;
		 do{
			 amount2[in]=result.getInt(1);
			 in++;
		 }while(result.next());
		 for(int i=0;i<amount2.length;i++)
		 {
			 amount+=amount2[i];
		 }
		 return amount;
	 }
	 
	/* public static void count_amount_price_yp(Analysis analysis) throws SQLException
	 {
		 String sql="select * from 药品价格;";
		 ResultSet result=analysis.connect.query(sql);
		 List<Medicine3> medicine3list=new ArrayList<Medicine3>();
		 result.last();
		 int length=result.getRow();
		 result.first();
		 do{
			 Medicine3 medicine=new Medicine3(result.getInt(1),result.getDouble(2));
			 medicine3list.add(medicine);
		 }while(result.next());
		 for(int i=0;i<medicine3list.size();i++)
		 {
			 String sql2="select yp_amount from 数据 where yp_id="+medicine3list.get(i).getMedicineId()+" && "+" ls_price="+medicine3list.get(i).getMedicinePrice()+";";
			 ResultSet result2=analysis.connect.query(sql2);
			 int count=0;
			 while(result2.next())
			 {
				 count+=result2.getInt(1);
			 }
			 String sql3="update 药品价格 set yp_amount="+count+" where yp_id="+medicine3list.get(i).getMedicineId()+" && "+"ls_price="+medicine3list.get(i).getMedicinePrice()+";";
			 analysis.connect.execute(sql3);
		 }
		 System.out.println("we've done here!");
	 }*/
	 public static void count_total_amount()
	 {
		 int count=0;
		 for(int i=0;i<Analysis.yp_id.length;i++)
		 {
			 count+=Analysis.amount[i];
		 }
		 Analysis.total_amount=count;
	 }
	 
	 public static void count_total_yp_id(Analysis analysis) throws SQLException
	 {
		// analysis.connect();
		 String sql="select count(distinct yp_id) aa from 数据;";
		 ResultSet result=analysis.connect.query(sql);
		 int count=0;
		if(result.next())
		{
			count=result.getInt("aa");
		}
		Analysis.different_yp=count;
	 }
	 
	 public static void count_total_sc_fac(Analysis analysis) throws SQLException
	 {
		 String sql="select count(distinct sc_fac) bb from 数据;";
		 ResultSet result=analysis.connect.query(sql);
		 int count=0;
		if(result.next())
		{
			count=result.getInt("bb");
		}
		Analysis.different_sc_fac=count;
	 }
	 public static void count_tot_sales(Analysis analysis) throws SQLException
	 {
		 Function.calculate(analysis, Analysis.amount, Analysis.price);
		 double count=0;
		 for(int i=0;i<Analysis.tot_price.length;i++)
		 {
			 count+=Analysis.tot_price[i];
		 }
		 Analysis.total_sales=count;
	 }
	 
	 public static int count_tot_amount_medicine(Analysis analysis,int yp_id) throws SQLException
	 {
		 int amount=0;
		 String sql="select * from 药品价格 where yp_id="+yp_id;
		 ResultSet result=analysis.connect.query(sql);
		 while(result.next())
		 {
			 amount+=result.getInt(3);
		 }
		 return amount;
	 }
}
