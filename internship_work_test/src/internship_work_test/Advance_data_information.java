package internship_work_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import yaopin.Medicine;
import yaopin.Medicine2;
import yaopin.Medicine4;
import yaopin.Medicine5;

public class Advance_data_information {
	
	
	
	public static void insert_amount(Analysis analysis) throws SQLException
	{
		Analysis.medicine5list=new ArrayList<Medicine5>();
		String sql="select * from 药品总数量;";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		do{
			Medicine5 medicine=new Medicine5(result.getInt(1),result.getInt(2));
			Analysis.medicine5list.add(medicine);
		}while(result.next());
		for(int i=0;i<Analysis.medicine5list.size();i++)
		{
			String sql2="update 药品总价格 set yp_amount="+Analysis.medicine5list.get(i).getMedicineAmount()+" where yp_id="+Analysis.medicine5list.get(i).getMedicineID()+";";
			analysis.connect.execute(sql2);
		}
		JOptionPane.showMessageDialog(null,"successful");
	}
	
	
	public static void tot_amount_medicine(Analysis analysis) throws SQLException
	{
		Analysis.medicine5list=new ArrayList<Medicine5>();
		String sql="select distinct yp_id from 药品价格;";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		int[] yp_id=new int[length];
		int in=0;
		do
		{
			yp_id[in]=result.getInt(1);
			in++;
			
		}while(result.next());
	    for(int i=0;i<length;i++)
	    {
	    	int yp_amount=Basic_data_information.count_tot_amount_medicine(analysis, yp_id[i]);
	    	Medicine5 medicine5=new Medicine5(yp_id[i],yp_amount);
	    	Analysis.medicine5list.add(medicine5);
	    }
		for(Medicine5 medicine5: Analysis.medicine5list)
		{
			String sql2="insert into 药品总数量 values "+"("+medicine5.getMedicineID()+","+medicine5.getMedicineAmount()+");";
			analysis.connect.execute(sql2);
			//System.out.println("coucou");
		}
		JOptionPane.showMessageDialog(null, "successful");
	}
	
	
	@SuppressWarnings("unchecked")
	public static void variance_yp(Analysis analysis) throws SQLException
	{
		System.out.println("let's begin");
		Analysis.medicine4list=new ArrayList<Medicine4>();
		Basic_data_information.recover_medicine_price(analysis);
		String sql="select distinct yp_id from 药品价格;";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		int[] yp_id=new int[length];
		int in=0;
		do{
			yp_id[in]=result.getInt(1);
			in++;
		}while(result.next());
		for(int i=0;i<yp_id.length;i++)
		{
			Basic_data_information.calculate_variance_medicine_price(analysis, yp_id[i]);
			Medicine4 medicine4=new Medicine4(yp_id[i],Analysis.yp_variance,Analysis.yp_number);
			Analysis.medicine4list.add(medicine4);
			System.out.println("录入 "+i);
		}
		Collections.sort(Analysis.medicine4list);
		Collections.reverse(Analysis.medicine4list);
		for(int i=0;i<yp_id.length;i++)
		{
			String sql2="insert into 药品价格方差 values "+"("+Analysis.medicine4list.get(i).getMedicineId()+","+Analysis.medicine4list.get(i).getMedicineVariance()+","+Analysis.medicine4list.get(i).getMedicineNumber()+");";
			analysis.connect.execute(sql2);
			System.out.println("写入"+" "+i);
		}
	}
	@SuppressWarnings("unchecked")
	public static void different_yp_sc(Analysis analysis) throws SQLException
	{
		String sql="select * from 药品厂家;";
		ResultSet result=analysis.connect.query(sql);	
		result.last();
	    int length=result.getRow();
		result.first();
		Analysis.yp_id_in_yc=new int[length];
		Analysis.sc_fac_in_yc=new String[length];
		int in=0;
		do{
		   Analysis.yp_id_in_yc[in]=result.getInt(1);
		   Analysis.sc_fac_in_yc[in]=result.getString(2);
		   in++;
		}while(result.next());
	    String sql2="select distinct yp_id from 药品厂家;";
	    ResultSet result2=analysis.connect.query(sql2);
	    result2.last();
	    int count=result2.getRow();
	    result2.first();
	    Analysis.yp_sc=new int[count][2];
	    in=0;
	    do{
	    	Analysis.yp_sc[in][0]=result2.getInt(1);
	    	Analysis.yp_sc[in][1]=0;
	    	in++;
	    }while(result2.next());
	    for(int i=0;i<length;i++)
	    {
	    	for(int j=0;j<count;j++)
	    	{
	    		if(Analysis.yp_id_in_yc[i]==Analysis.yp_sc[j][0])
	    		{
	    			Analysis.yp_sc[j][1]++;
	    		}
	    	}
	    }
	    Analysis.medicinelist=new ArrayList<Medicine>();
	    for(int i=0;i<count;i++)
	    {
	    	Medicine medicine=new Medicine(Analysis.yp_sc[i][0],Analysis.yp_sc[i][1]);
	    	//System.out.println(medicine.getMedicineId());
	    	Analysis.medicinelist.add(medicine);
	    }
	    Collections.sort(Analysis.medicinelist);
        Collections.reverse(Analysis.medicinelist);
    }
	
	public static String find_yp_id(Analysis analysis, int yp_id) throws SQLException
	{
		different_yp_sc(analysis);
		String str="";
		str+="The pharmaceutical factories of medicine "+yp_id+" ："+"\n";
	    for(int i=0;i<Analysis.yp_id_in_yc.length;i++)
	    {
		    if(Analysis.yp_id_in_yc[i]==yp_id)
		    {
		      int amount=Basic_data_information.count_amount_sc_yp(analysis, yp_id, Analysis.sc_fac_in_yc[i]);
			  str+="\t\t\t"+Analysis.sc_fac_in_yc[i]+"\t\t\t"+amount+"\n";
		    }
	    }
		return str;
	}
	
	public static String find_yp_price(Analysis analysis,int yp_id) throws SQLException
	{
		String str="the different prices of medicie "+yp_id+" and its corresponding sales"+"\n";
		String sql="select * from 药品价格 where yp_id="+yp_id+";";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		do{
			str+="                           "+result.getDouble(2)+"                              "+result.getInt(3)+"\n";
		}while(result.next());
		return str;
	}
	@SuppressWarnings("unchecked")
	public static void medicine_total_price(Analysis analysis) throws SQLException
	{
		Analysis.medicine2list=new ArrayList<Medicine2>();
	    Frenquency_Analysis.yp_id_frequency_analysis(analysis);
	    for(int i=0;i<Analysis.different_yp_id.size();i++)
	    {
	    	double total_price=Basic_data_information.count_total_price_of_medicine(analysis, Analysis.different_yp_id.get(i));
	    	Medicine2 medicine2=new Medicine2(Analysis.different_yp_id.get(i),total_price);
	    	Analysis.medicine2list.add(medicine2);
	    	//System.out.println(medicine2.getMedicineId()+"       "+medicine2.getMedicineTotalPrice());
	    }
	    Collections.sort(Analysis.medicine2list);
	    Collections.reverse(Analysis.medicine2list);
	    for(int i=0;i<Analysis.medicine2list.size();i++)
	    {
	       String sql="insert into 药品总价格 values "+"("+Analysis.medicine2list.get(i).getMedicineId()+","+Analysis.medicine2list.get(i).getMedicineTotalPrice()+");";
	       analysis.connect.execute(sql);
	     //  System.out.println("coucou");
	    }
	}
    
	
}