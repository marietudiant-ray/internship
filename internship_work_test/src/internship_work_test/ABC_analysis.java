package internship_work_test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import yaopin.Medicine3;

public class ABC_analysis {
	
	public ABC_analysis()
	{
		
	}
	
	@SuppressWarnings("unchecked")
	public static void function_ABc_analysis(Analysis analysis) throws SQLException
	{
		Analysis.ClassAlist=new ArrayList<Medicine3>();
		Analysis.ClassBlist=new ArrayList<Medicine3>();
		Analysis.ClassClist=new ArrayList<Medicine3>();
		
		Basic_data_information.count_total_amount();
		Basic_data_information.count_tot_sales(analysis);
		//System.out.println(Analysis.total_amount+"     "+Analysis.total_sales);
	
		String sql="select * from 药品总价格";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		Analysis.medicine3list=new ArrayList<Medicine3>();
		do{
			Medicine3 medicine3=new Medicine3(result.getInt(1),result.getDouble(2),result.getInt(3));
			Analysis.medicine3list.add(medicine3);
			//System.out.println(Analysis.medicine3list.size());
		}while(result.next());
		//Collections.sort(Analysis.medicine3list);
	//	Collections.reverse(Analysis.medicine3list);
		//System.out.println(Analysis.medicine3list.get(1).getMedicineId()+"    "+Analysis.medicine3list.get(1).getMedicinePrice()+"    "+Analysis.medicine3list.get(1).getMedicineAmount());
		for(int i=0;i<Analysis.medicine3list.size() && Analysis.A_price_count<(0.7*Analysis.total_sales);i++)
		{
			Medicine3 A=new Medicine3(Analysis.medicine3list.get(i).getMedicineId(),Analysis.medicine3list.get(i).getMedicinePrice(),Analysis.medicine3list.get(i).getMedicineAmount());
			Analysis.ClassAlist.add(A);
		   Analysis.A_price_count+=A.getMedicinePrice();
		    Analysis.A_amount_count+=A.getMedicineAmount();
		}
		for(int i=Analysis.ClassAlist.size();i<Analysis.medicine3list.size() && Analysis.B_price_count<(0.25*Analysis.total_sales);i++)
		{
			Medicine3 B=new Medicine3(Analysis.medicine3list.get(i).getMedicineId(),Analysis.medicine3list.get(i).getMedicinePrice(),Analysis.medicine3list.get(i).getMedicineAmount());
			Analysis.ClassBlist.add(B);
			Analysis.B_price_count+=B.getMedicinePrice();
			Analysis.B_amount_count+=B.getMedicineAmount();
		}
		//System.out.println(Analysis.ClassAlist.size()+Analysis.ClassBlist.size());
		//System.out.println(Analysis.A_amount_count+Analysis.B_amount_count);
		for(int i=(Analysis.ClassAlist.size()+Analysis.ClassBlist.size());i<Analysis.medicine3list.size();i++)
		{
			Medicine3 C=new Medicine3(Analysis.medicine3list.get(i).getMedicineId(),Analysis.medicine3list.get(i).getMedicinePrice(),Analysis.medicine3list.get(i).getMedicineAmount());
			Analysis.ClassClist.add(C);
			Analysis.C_price_count+=C.getMedicinePrice();
			Analysis.C_amount_count+=C.getMedicineAmount();
		}
		//System.out.println(Analysis.A_amount_count+"    "+Analysis.total_amount);
		String str="Class          Sum of Sales Amount                percentage                   Sum of Quantity             percentage"+"\n";
		str+="A"+"             "+Analysis.A_price_count+"              "+(Analysis.A_price_count/Analysis.total_sales)*100+"%"+"               "+Analysis.A_amount_count+"    "+((double)Analysis.A_amount_count/Analysis.total_amount)*100+"%"+"\n";
		str+="B"+"             "+Analysis.B_price_count+"              "+(Analysis.B_price_count/Analysis.total_sales)*100+"%"+"               "+Analysis.B_amount_count+"    "+((double)Analysis.B_amount_count/Analysis.total_amount)*100+"%"+"\n";
		str+="C"+"             "+Analysis.C_price_count+"              "+(Analysis.C_price_count/Analysis.total_sales)*100+"%"+"               "+Analysis.C_amount_count+"    "+((double)Analysis.C_amount_count/Analysis.total_amount)*100+"%"+"\n";
        JOptionPane.showMessageDialog(null, str,"Class ABC of medicines",JOptionPane.INFORMATION_MESSAGE);
        
        System.out.println(Analysis.ClassAlist.size()+"     "+Analysis.ClassBlist.size()+"     "+Analysis.ClassClist.size());
	}
}
