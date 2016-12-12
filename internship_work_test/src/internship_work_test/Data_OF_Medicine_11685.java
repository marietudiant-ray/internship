package internship_work_test;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import medicine11685.Medicine11685;

public class Data_OF_Medicine_11685 {
	
	public static void classify_by_month(Analysis analysis) throws SQLException
	{
		//String str1="Year-month                             sales amount               "+"\n";
		Analysis.Month=new String[48];
		Analysis.medicinemonthlist=new ArrayList<Medicine11685>();
		for(int i=0;i<Analysis.Month.length;i++)
		{
			int year=2007+((int)i/12);
			int month=(int) i%12+1;
			String str="";
			if(month<10){
			  str=year+"-0"+month;}
			else{
				str=year+"-"+month;
			}
			Analysis.Month[i]=str;
			//System.out.println(Analysis.Month[i]);
		}
		for(int i=0;i<Analysis.Month.length;i++)
		{
			double count =0;
			String sql="select tot_price from medicine11685new where fh_date like"+"\""+Analysis.Month[i]+"%"+"\";";
			ResultSet result=analysis.connect.query(sql);
			while(result.next())
			{
				count+=result.getDouble(1);				
			}
			Medicine11685 medicine=new Medicine11685(Analysis.Month[i],count);
			Analysis.medicinemonthlist.add(medicine);
			//BigDecimal b1=new BigDecimal(Analysis.medicinemonthlist.get(i).getPrice());
			//double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			//str1+=Analysis.medicinemonthlist.get(i).getDate()+"                                    "+b2+"\n";
		}
		//JOptionPane.showMessageDialog(null, str1, "Classify medicines in different months", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void classify_by_quarter(Analysis analysis) throws SQLException
	{
		classify_by_month(analysis);
		Analysis.medicinequarterlist=new ArrayList<Medicine11685>();
		double[] count=new double[16];
		for(int i=0;i<Analysis.medicinemonthlist.size();i++)
		{
			if(i<3&&i>=0)
			{
			    count[0]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<6&&i>=3)
			{
			    count[1]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<9&&i>=6)
			{
			    count[2]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<12&&i>=9)
			{
			    count[3]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<15&&i>=12)
			{
			    count[4]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<18&&i>=15)
			{
			    count[5]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<21&&i>=18)
			{
			    count[6]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<24&&i>=21)
			{
			    count[7]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<27&&i>=24)
			{
			    count[8]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<30&&i>=27)
			{
			    count[9]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<33&&i>=30)
			{
			    count[10]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<36&&i>=33)
			{
			    count[11]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<39&&i>=36)
			{
			    count[12]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<42&&i>=39)
			{
			    count[13]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<45&&i>=42)
			{
			    count[14]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
			if(i<48&&i>=45)
			{
			    count[15]+=Analysis.medicinemonthlist.get(i).getPrice();
			}
		}
	
			Medicine11685 medicine1=new Medicine11685("2007-01",count[0]);
			Medicine11685 medicine2=new Medicine11685("2007-02",count[1]);
			Medicine11685 medicine3=new Medicine11685("2007-03",count[2]);
			Medicine11685 medicine4=new Medicine11685("2007-04",count[3]);
			
			Medicine11685 medicine5=new Medicine11685("2008-01",count[4]);
			Medicine11685 medicine6=new Medicine11685("2008-02",count[5]);
			Medicine11685 medicine7=new Medicine11685("2008-03",count[6]);
			Medicine11685 medicine8=new Medicine11685("2008-04",count[7]);
			
			Medicine11685 medicine9=new Medicine11685("2009-01",count[8]);
			Medicine11685 medicine10=new Medicine11685("2009-02",count[9]);
			Medicine11685 medicine11=new Medicine11685("2009-03",count[10]);
			Medicine11685 medicine12=new Medicine11685("2009-04",count[11]);
			
			Medicine11685 medicine13=new Medicine11685("2010-01",count[12]);
			Medicine11685 medicine14=new Medicine11685("2010-02",count[13]);
			Medicine11685 medicine15=new Medicine11685("2010-03",count[14]);
			Medicine11685 medicine16=new Medicine11685("2010-04",count[15]);
			
			Analysis.medicinequarterlist.add(medicine1);
			Analysis.medicinequarterlist.add(medicine2);
			Analysis.medicinequarterlist.add(medicine3);
			Analysis.medicinequarterlist.add(medicine4);
			Analysis.medicinequarterlist.add(medicine5);
			Analysis.medicinequarterlist.add(medicine6);
			Analysis.medicinequarterlist.add(medicine7);
			Analysis.medicinequarterlist.add(medicine8);
			Analysis.medicinequarterlist.add(medicine9);
			Analysis.medicinequarterlist.add(medicine10);
			Analysis.medicinequarterlist.add(medicine11);
			Analysis.medicinequarterlist.add(medicine12);
			Analysis.medicinequarterlist.add(medicine13);
			Analysis.medicinequarterlist.add(medicine14);
			Analysis.medicinequarterlist.add(medicine15);
			Analysis.medicinequarterlist.add(medicine16);
			
	}
	
	public static void classify_by_year(Analysis analysis) throws SQLException
	{
		classify_by_quarter(analysis);
		Analysis.medicineyearlist=new ArrayList<Medicine11685>();
		double[] count=new double[4];
		for(int i=0;i<16;i++)
		{
			if(i<4&&i>=0)
			{
				count[0]+=Analysis.medicinequarterlist.get(i).getPrice();
			}
			if(i<8&&i>=4)
			{
				count[1]+=Analysis.medicinequarterlist.get(i).getPrice();
			}
			if(i<12&&i>=8)
			{
				count[2]+=Analysis.medicinequarterlist.get(i).getPrice();
			}
			if(i<16&&i>=12)
			{
				count[3]+=Analysis.medicinequarterlist.get(i).getPrice();
			}
		}
		Medicine11685 medicine1=new Medicine11685("2007",count[0]);
		Medicine11685 medicine2=new Medicine11685("2008",count[1]);
		Medicine11685 medicine3=new Medicine11685("2009",count[2]);
		Medicine11685 medicine4=new Medicine11685("2010",count[3]);
		
		Analysis.medicineyearlist.add(medicine1);
		Analysis.medicineyearlist.add(medicine2);
		Analysis.medicineyearlist.add(medicine3);
		Analysis.medicineyearlist.add(medicine4);
	}
	
	public static void input_month_medicine(Analysis analysis) throws SQLException
	{
		classify_by_month(analysis);
		String sql="create table month_medicine (medicine_date varchar(255), tot_price double);";
		analysis.connect.execute(sql);
		for(int i=0;i<Analysis.medicinemonthlist.size();i++)
		{
			BigDecimal b1=new BigDecimal(Analysis.medicinemonthlist.get(i).getPrice());
			double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			String sql2="insert into month_medicine values ("+"\""+Analysis.medicinemonthlist.get(i).getDate()+"\""+","+b2+");";
			//System.out.println(sql2);
			analysis.connect.execute(sql2);
		}
	}
	
	
	public static void input_quarter_medicine(Analysis analysis) throws SQLException
	{
		classify_by_quarter(analysis);
		String sql="create table quarter_medicine (medicine_date varchar(255), tot_price double);";
		analysis.connect.execute(sql);
		for(int i=0;i<Analysis.medicinequarterlist.size();i++)
		{
			BigDecimal b1=new BigDecimal(Analysis.medicinequarterlist.get(i).getPrice());
			double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			String sql2="insert into quarter_medicine values ("+"\""+Analysis.medicinequarterlist.get(i).getDate()+"\""+","+b2+");";
			analysis.connect.execute(sql2);
		}
	}
	
	
	public static void input_year_medicine(Analysis analysis) throws SQLException
	{
		classify_by_year(analysis);
		String sql="create table year_medicine (medicine_date varchar(255), tot_price double);";
		analysis.connect.execute(sql);
		for(int i=0;i<Analysis.medicineyearlist.size();i++)
		{
			BigDecimal b1=new BigDecimal(Analysis.medicineyearlist.get(i).getPrice());
			double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			String sql2="insert into year_medicine values ("+"\""+Analysis.medicineyearlist.get(i).getDate()+"\""+","+b2+");";
			//System.out.println(sql2);
			analysis.connect.execute(sql2);
		}
	}
	
	
	
	

}
