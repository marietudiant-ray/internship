package internship_work_test;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import yaopin.Medicine5;

public class Function {

	public static void printData(int[] id,int[] amount,double[] price,String[] sc_fac,Date[] fh_date)
	{
		String str="";
		for(int i=0;i<id.length;i++)
		{
			str+=id[i]+"    "+amount[i]+"    "+price[i]+"      "+sc_fac[i]+"      "+fh_date[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, str, "数据表", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void newprintData(int[] id,int[] amount,double[] price,String[] sc_fac,Date[] fh_date,String[] province)
	{
		String str="";
		for(int i=0;i<id.length;i++)
		{
			str+=id[i]+"    "+amount[i]+"    "+price[i]+"      "+sc_fac[i]+"      "+fh_date[i]+"      "+province[i]+"\n";
		}
		JOptionPane.showMessageDialog(null, str, "数据表", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static String[] cut_out(String[] sc_fac,String[] province)
	{
		for(int i=0;i<sc_fac.length;i++)
		{
			if(sc_fac[i] !=null && !"".equals(sc_fac))
			{
			province[i]=sc_fac[i].substring(0,2);
			}
			else{
				continue;
			}
		}
		return province;
	}
	
	public static void getZone(Analysis analysis) throws SQLException
	{
		String sql="select * from zone_new;";
		ResultSet result=analysis.connect.query(sql);
		int zone_length;
		result.last();
		zone_length=result.getRow();
		result.first();
		analysis.zone=new String[zone_length];
		int in=0;
		do
		{
			analysis.zone[in]=result.getString(1);
			in++;
			
		}while(result.next()&&in<analysis.zone.length);
	}
	
	public static void addProvince(Analysis analysis) throws SQLException
	{
		for(int i=0;i<analysis.zone.length;i++)
		{
		    String sql2="update 数据 set province='"+analysis.zone[i]+"' where left(sc_fac,2)='"+analysis.zone[i]+"';";
		    analysis.connect.execute(sql2);
		}	
	}
	public static void addVar(String variable,String type,Analysis analysis) throws SQLException
	{
		String sql="alter table 数据 add "+variable+" "+type;
		analysis.connect.execute(sql);
	}
	
	public static void calculate(Analysis analysis, int[] amount,double[] price) throws SQLException
	{
		Analysis.tot_price=new double[amount.length];
		for(int i=0;i<analysis.id.length;i++)
		{
		
			if(amount[i]!=0&&price[i]!=0)
			{ 
		
				Analysis.tot_price[i]=(double) amount[i]*price[i];
			}
			else
			{
				Analysis.tot_price[i]=0;
			}
		}
	
		/*long starTime=System.currentTimeMillis();
		for(int i=0;i<Analysis.tot_price.length;i++)
		{
		
			 String sql="update 新数据3 set tot_price="+Analysis.tot_price[i]+" where id= "+(i+1)+";";
			 analysis.connect.execute(sql);
				
		}
		long endTime=System.currentTimeMillis();
		 long time=endTime-starTime;
		 System.out.println(time);*/
	
		/*long starTime=System.currentTimeMillis();
		for(int i=0;i<Analysis.tot_price.length;i++)
		{
			analysis.connect.statement.addBatch("update 新数据3 set tot_price="+Analysis.tot_price[i]+" where id= "+(i+1)+";");
		
		}
		 analysis.connect.statement.executeBatch();
		 long endTime=System.currentTimeMillis();
		 long time=endTime-starTime;
		 System.out.println(time);*/
	}
	
}
