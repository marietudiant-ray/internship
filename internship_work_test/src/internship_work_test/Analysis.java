package internship_work_test;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import internship_work_test.Function;
import medicine11685.Medicine11685;
import yaopin.Medicine;
import yaopin.Medicine2;
import yaopin.Medicine3;
import yaopin.Medicine4;
import yaopin.Medicine5;

public class Analysis {
	
	public static int[] id;
	public static int data_length;
	public Connect_Sql connect;
	public static int[] yp_id; 
	public static int[] amount;
	public static double[] price;
	public static  String[] sc_fac;
	public static  Date[] fh_date;
	public static  String[] province;
	public static  String[] zone;
	public static double[] freauency_zone;
	public static int[] frequency_zn;
	public static double[] frenquency_yp_id;
	public static int[] frequency_yi;
	public static double[] tot_price;
	public static ArrayList<Integer> different_yp_id;
	public static int[] frequency_yp_price;
	public static double[] frequency_yp;
	public static double[] new_price;
	public static int[] new_yp_id;
	public static int total_amount;
	public static double total_sales;
	public static int different_yp;
	public static int different_sc_fac;
	public static int[] yp_id_in_yc; // create a new array where save the yp_id data in database “药品厂家”;
	public static String[] sc_fac_in_yc; // create a new array where save the sc_fac data in database "药品厂家" ;
	public static int[][] yp_sc;
	public static int yp_number;
	public static double yp_variance;
	public static List<Medicine> medicinelist;
	public static ArrayList<String> find_yp_id;
	public static List<Medicine2> medicine2list;
	public static List<Medicine3> medicine3list;
	public static List<Medicine4> medicine4list;
	public static List<Medicine5> medicine5list;
	public static List<Medicine3> ClassAlist;
	public static List<Medicine3> ClassBlist;
	public static List<Medicine3> ClassClist;
	public static double  A_price_count=0,B_price_count=0,C_price_count=0;
	public static int  A_amount_count=0, B_amount_count=0,C_amount_count=0;
	public static String[] Month;
	public static List<Medicine11685> medicinemonthlist;
	public static List<Medicine11685> medicinequarterlist;
	public static List<Medicine11685> medicineyearlist;
	
	
	public Analysis()
	{
		
	}
	public void connect()
	{
		connect=new Connect_Sql();
		System.out.println("the database connection is successful! ");
	    
	}
	
	public void disconnect()
	{
		try {
			connect.statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getData(Analysis analysis) throws SQLException
	{
		   analysis.connect();
		   String sql="select * from 数据";// select 10 data in the table 数据
		   ResultSet result=analysis.connect.query(sql);
		   result.last();// cursor on the last of line
		   data_length=result.getRow();
		   result.first(); // cursor back on the head of line
		   id=new int[data_length];
		   yp_id=new int[data_length];
		   amount=new int[data_length];
		   price=new double[data_length];
		   sc_fac=new String[data_length];
		   fh_date=new Date[data_length];
		   province=new String[data_length];
		   int in=0;
		   do{
			   yp_id[in]=result.getInt(1);
			   amount[in]=result.getInt(2);
			   price[in]=result.getDouble(3);
			   sc_fac[in]=result.getString(5);
			   fh_date[in]=result.getDate(6);
			   id[in]=result.getInt(7);
			   in++;
		   }while(result.next()&&in<data_length);
	}
	
	
	public static void main(String[] args) throws SQLException
	{
		
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		/*Function.calculate(analysis, amount, price);*/
		//Basic_data_information.count_total_amount();
		//Basic_data_information.count_tot_sales(analysis);
		//System.out.println(total_sales);
		//System.out.println(total_amount);
		//Frenquency_Analysis.yp_price_frequency_analysis(analysis);
	    /*Basic_data_information.count_total_yp_id(analysis);
	    System.out.println(different_yp);
	    Basic_data_information.count_total_sc_fac(analysis);;
	    System.out.println(different_sc_fac);
		/*Function.addVar("province", "varchar(255)", analysis);
		Function.cut_out(sc_fac, province);
		Function.getZone(analysis);
		Function.addProvince(analysis);*/
		/*Frenquency_Analysis.zone_frequency_anlalysis(analysis);
		Function.addVar("tot_price", "double", analysis);
		//Function.calculate(analysis, amount, price);
		Frenquency_Analysis.yp_id_frequency_analysis(analysis);
		Frenquency_Analysis.yp_price_frequency_analysis(analysis);*/
	    //Advance_data_information.different_yp_sc(analysis);
		/*String str=Advance_data_information.find_yp_id(analysis, 11886);
		JOptionPane.showMessageDialog(null, str);*/
		//System.out.println(Basic_data_information.count_total_price_of_medicine(analysis, 11886));
		/*Frenquency_Analysis.yp_id_frequency_analysis(analysis);
		System.out.println(different_yp_id.size());*/
        //Basic_data_information.recover_medicine_price(analysis);
        //ArrayList a=new ArrayList();
        //a=Basic_data_information.calculate_variance_medicine_price(analysis, 12791);
		//Basic_data_information.count_amount_price_yp(analysis);
		//Advance_data_information.variance_yp(analysis);
		/*int amount=Basic_data_information.count_tot_amount_medicine(analysis, 12791);
		System.out.println(amount);*/
		//Advance_data_information.tot_amount_medicine(analysis);
		//ABC_analysis.function_ABc_analysis(analysis);
		//Data_OF_Medicine_11685.classify_by_month(analysis);
		Data_OF_Medicine_11685.input_month_medicine(analysis);
		Data_OF_Medicine_11685.input_quarter_medicine(analysis);
		Data_OF_Medicine_11685.input_year_medicine(analysis);
		System.out.println("finished");
	}
    
}
