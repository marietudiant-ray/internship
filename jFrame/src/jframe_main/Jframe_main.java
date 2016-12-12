package jframe_main;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;

import internship_work_test.*;
import jframe_frenquency_yp_id.Jframe_frenquency_yp_id;
import jframe_main.Info;
import yaopin.Medicine;
import yaopin.Medicine2;
import yaopin.Medicine4;
import jframe_frequency_province.*;
import jframe_frequency_yp_price.Jframe_frequence_yp_price;

import jframe_myprint.MyPrint;
public class Jframe_main {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static final long serialVersionUID=1L;
	
      JFrame f;
	public Jframe_main()
	{
        f=new JFrame();
		//JTabbedPane tb=new JTabbedPane();
		//JPanel p=new JPanel();
		f.setTitle("working interface");
		JMenuBar menubar=new JMenuBar();
		f.setJMenuBar(menubar);
	//	f.add(p);
	//	p.add(tb);
		JMenu menu2=new JMenu("file");
		menubar.add(menu2);
		JMenu menu1=new JMenu("analyze");
		menubar.add(menu1);
		JMenu menu3=new JMenu("tools");
		menubar.add(menu3);
		JMenu menu4=new JMenu("help");
		menubar.add(menu4);
		
		JMenu item13=new JMenu("input");
		menu2.add(item13);
		JMenu item1=new JMenu("basic analysis");
		menu1.add(item1);
		JMenu item14=new JMenu("advance analysis");
		menu1.add(item14);
		JMenuItem item19=new JMenuItem("ABC analysis");
		menu1.add(item19);
		JMenu item20=new JMenu("Classify Medicines");
		menu1.add(item20);
		
		JMenuItem item2=new JMenuItem("quit");
		menu2.add(item2);
		JMenuItem item3=new JMenuItem("add variable");
		menu3.add(item3);
		JMenu item4=new JMenu("variable capture");
		menu3.add(item4);
		JMenuItem item5=new JMenuItem("variable assignment");
		menu3.add(item5);
		JMenuItem item15=new JMenuItem("find factories");
		menu3.add(item15);
		JMenuItem item16=new JMenuItem("find prices");
		menu3.add(item16);
		JMenuItem item17=new JMenuItem("amount of medicine");
		menu3.add(item17);
		JMenuItem item18=new JMenuItem("medicine-price-amount");
		menu3.add(item18);
		JMenuItem item21=new JMenuItem("Classify by month");
		item20.add(item21);
		JMenuItem item22=new JMenuItem("Classify by quarter");
		item20.add(item22);
		JMenuItem item23=new JMenuItem("Classify by year");
		item20.add(item23);
		
		JMenu secitem1=new JMenu("frequence distribution analysis");
		item1.add(secitem1);
		JMenu secitem3=new JMenu("basic data");
		item1.add(secitem3);
		JMenuItem secitem2=new JMenuItem("province capture");
		item4.add(secitem2);
		JMenuItem secitem4=new JMenuItem("medicine-factory");
		item14.add(secitem4);
		JMenuItem secitem5=new JMenuItem("total price of one medicine");
		item14.add(secitem5);
		JMenuItem secitem6=new JMenuItem("variance of  medicine price");
		item14.add(secitem6);
		
		JMenuItem thirditem7=new JMenuItem("total sales of medicines");
		secitem3.add(thirditem7);
		JMenuItem thirditem6=new JMenuItem("total amount of medicine consumption");
		secitem3.add(thirditem6);
		JMenuItem thirditem5=new JMenuItem("number of different factory");
		secitem3.add(thirditem5);
		JMenuItem thirditem4=new JMenuItem("number of different medicine");
		secitem3.add(thirditem4);
		JMenuItem thirditem1=new JMenuItem("province distribution statics");
		secitem1.add(thirditem1);
		JMenuItem thirditem2=new JMenuItem("medicine frequency statics ");
		secitem1.add(thirditem2);
		JMenuItem thirditem3=new JMenuItem("medicine price statics");
		secitem1.add(thirditem3);
		
		item2.addActionListener(new Quit_Listener(this));
        f.setVisible(true);
        f.setSize(400, 350);
        f.setLocation(300, 200);
	//	p.add(tb);
        item3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent actionevent)
			{
				JFrame ff=new JFrame();
				JTabbedPane tb=new JTabbedPane();
                JPanel p=new JPanel();
				Info con1=new Info();
				ff.add(p);
			    p.add(tb);
                tb.addTab("con1", con1);
				tb.setEnabledAt(0, true);
				tb.setTitleAt(0, "variable information");
				tb.setPreferredSize(new Dimension(300,200));
				tb.setTabPlacement(JTabbedPane.TOP);
				tb.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			    ff.setVisible(true);
			    ff.setSize(400, 300);
			    ff.setLocation(400, 500);
			    //ff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
        secitem2.addActionListener(new Cut_Listener(this));
        secitem4.addActionListener(new Count_fac_quantity_of_medicine_Listener(this));
        secitem5.addActionListener(new Count_total_price_Listener(this));
        secitem6.addActionListener(new Count_Variance_Medicine_Price_Listener(this));
        thirditem1.addActionListener(new Frenquency_province_Listener(this));
        item5.addActionListener(new Assignment_Listener(this));
        item15.addActionListener(new Find_medicine_id_Listener(this));
        item16.addActionListener(new Find_medicine_price_Listener(this));
        item17.addActionListener(new Count_amount_each_medicine_Listener(this));
        item18.addActionListener(new Insert_amount_in_medicine_sale_amount_Listener(this));
        item19.addActionListener(new ABC_analysis_Listener(this));
        item21.addActionListener(new Classify_by_month_Listener(this));
        item22.addActionListener(new Classify_by_quarter_Listener(this));
        item23.addActionListener(new Classify_by_year_Listener(this));
        thirditem2.addActionListener(new Frenquency_yp_id_Listener(this));
        thirditem3.addActionListener(new Frenquency_yp_price_Listener(this));
        thirditem4.addActionListener(new Count_medicine_number_Listener(this));
        thirditem5.addActionListener(new Count_factory_number_Listener(this));
        thirditem6.addActionListener(new Count_amount_medicine_consumption_Listener(this));
        thirditem7.addActionListener(new Count_sales_medicine_Listener(this));
	}
	
	public void item2_actionPerformed(ActionEvent actionevent)
	{
		int i=JOptionPane.showConfirmDialog(null, "Do you really want to quit!", "quit", JOptionPane.YES_NO_CANCEL_OPTION);
		if(i==0)
		{
			System.exit(0);
		}		
	}
	
	public void item5_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Function.calculate(analysis, analysis.amount, analysis.price);
	    JOptionPane.showMessageDialog(null, "the new variable has already assigned", "completed", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void item15_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		String yp_id=JOptionPane.showInputDialog(null, "please enter a medicine id", "find factory", JOptionPane.QUESTION_MESSAGE);
		String str=Advance_data_information.find_yp_id(analysis, Integer.valueOf(yp_id));
		JOptionPane.showMessageDialog(null, str, "find factory", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void item16_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis  analysis=new Analysis();
		analysis.getData(analysis);
		String yp_id=JOptionPane.showInputDialog(null,"please enter a medicine id","find price",JOptionPane.QUESTION_MESSAGE);
		String str=Advance_data_information.find_yp_price(analysis, Integer.valueOf(yp_id));
		JOptionPane.showMessageDialog(null, str, "find price", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void item17_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Advance_data_information.tot_amount_medicine(analysis);
	}
	
	public void item18_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Advance_data_information.insert_amount(analysis);
	}
	
	public void item19_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		ABC_analysis.function_ABc_analysis(analysis);
	}
	
	
	public void item21_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Data_OF_Medicine_11685.classify_by_month(analysis);
		String str1="Year-month                             sales amount               "+"\n";
		for(int i=0;i<Analysis.medicinemonthlist.size();i++)
		{
		  BigDecimal b1=new BigDecimal(Analysis.medicinemonthlist.get(i).getPrice());
		  double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		  str1+=Analysis.medicinemonthlist.get(i).getDate()+"                                    "+b2+"\n";
		}
	    JOptionPane.showMessageDialog(null, str1, "Classify medicines in different months", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void item22_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Data_OF_Medicine_11685.classify_by_quarter(analysis);
		String str1="Year-quarter                             sales amount               "+"\n";
		for(int i=0;i<Analysis.medicinequarterlist.size();i++)
		{
		  BigDecimal b1=new BigDecimal(Analysis.medicinequarterlist.get(i).getPrice());
		  double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		  str1+=Analysis.medicinequarterlist.get(i).getDate()+"                                    "+b2+"\n";
		}
	    JOptionPane.showMessageDialog(null, str1, "Classify medicines in different quarters", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void item23_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Data_OF_Medicine_11685.classify_by_year(analysis);
		String str1="Year                                sales amount               "+"\n";
		for(int i=0;i<Analysis.medicineyearlist.size();i++)
		{
		  BigDecimal b1=new BigDecimal(Analysis.medicineyearlist.get(i).getPrice());
		  double b2=b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		  str1+=Analysis.medicineyearlist.get(i).getDate()+"                                    "+b2+"\n";
		}
	    JOptionPane.showMessageDialog(null, str1, "Classify medicines in different years", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void secitem2_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Function.cut_out(analysis.sc_fac, analysis.province);
		Function.getZone(analysis);
		Function.addProvince(analysis);
		JOptionPane.showMessageDialog(null, "the province has already captured","completed", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void secitem4_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Advance_data_information.different_yp_sc(analysis);
	    String str="";
	    for(Medicine medicine: Analysis.medicinelist)
	    {
	    	if(medicine.getquantitysc()>5)
	    	{
	    	str+=medicine.getMedicineId()+"       "+medicine.getquantitysc()+"\n";
	    	}
	    	//String sql="insert into 药品厂家频率 values ("+medicine.getMedicineId()+","+medicine.getquantitysc()+");";
	    	//analysis.connect.execute(sql);
	    }
	    JOptionPane.showMessageDialog(null, str, "completed", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void secitem5_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		//Advance_data_information.medicine_total_price(analysis);
		/*String str="";
		for(int i=0;i<10;i++)
		{
			str+=Analysis.medicine2list.get(i).getMedicineId()+"      "+Analysis.medicine2list.get(i).getMedicineTotalPrice();
		}
		JOptionPane.showMessageDialog(null, str,"top 10 of total medicine price", JOptionPane.INFORMATION_MESSAGE);*/
		String sql="select * from 药品总价格";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		List<Medicine2> medicine2list=new ArrayList<Medicine2>();
		do{
			BigDecimal b1=new BigDecimal(result.getDouble(2));
			Medicine2 medicine2=new Medicine2(result.getInt(1),b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
			medicine2list.add(medicine2);
		}while(result.next());
		String str="";
		for(int i=0;i<10;i++)
		{
			str+=medicine2list.get(i).getMedicineId()+"        "+medicine2list.get(i).getMedicineTotalPrice()+"\n";
		}
		JOptionPane.showMessageDialog(null, str, "top 10 of total medicine prrice", JOptionPane.INFORMATION_MESSAGE);
	}

	@SuppressWarnings("static-access")
	public void secitem6_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		String sql="select * from 药品价格方差;";
		ResultSet result=analysis.connect.query(sql);
		result.last();
		int length=result.getRow();
		result.first();
		int[] yp_id=new int[length];
		double[] yp_variance=new double[length];
		int[] yp_number=new int[length];
		int in=0;
		do{
			yp_id[in]=result.getInt(1);
			yp_variance[in]=result.getDouble(2);
			yp_number[in]=result.getInt(3);
			in++;
		}while(result.next());
		List<Medicine4> medicine4list=new ArrayList<Medicine4>();
		for(int i=0;i<10;i++)
		{
			double variance=Math.sqrt(yp_variance[i]);
			BigDecimal b1=new BigDecimal(variance);
			Medicine4 medicine4=new Medicine4(yp_id[i],b1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(),yp_number[i]);
			medicine4list.add(medicine4);
		}
		MyPrint myprint=new MyPrint();
		myprint.myprint(medicine4list);
	}
	
	public void thirditem1_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		new Jframe_frequency_province();
	}
	
	public void thirditem2_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		new Jframe_frenquency_yp_id();
	}
	
	public void thirditem3_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		new Jframe_frequence_yp_price();
	}
	public void thirditem4_actionPerformed(ActionEvent actionevent) throws SQLException
	{
	   Analysis analysis=new Analysis();
	   analysis.getData(analysis);
	   Basic_data_information.count_total_yp_id(analysis);
	   String str="the number of different medicine : "+Analysis.different_yp;
	   JOptionPane.showMessageDialog(null, str, "number of medicine", JOptionPane.INFORMATION_MESSAGE);
	   
	}
	public void thirditem5_actionPerformed(ActionEvent actionevent) throws SQLException
	{
	   Analysis analysis=new Analysis();
	   analysis.getData(analysis);
	   Basic_data_information.count_total_sc_fac(analysis);
	   String str="the number of different factory : "+Analysis.different_sc_fac;
	   JOptionPane.showMessageDialog(null, str, "number of factory", JOptionPane.INFORMATION_MESSAGE);
	   
	}
	public void thirditem6_actionPerformed(ActionEvent actionevent) throws SQLException
	{
	   Analysis analysis=new Analysis();
	   analysis.getData(analysis);
	   Basic_data_information.count_total_amount();
	   String str="total amount of medicine consumption : "+Analysis.total_amount;
	   JOptionPane.showMessageDialog(null, str, "total amount of medicine consumption", JOptionPane.INFORMATION_MESSAGE);
	   
	}
	
	public void thirditem7_actionPerformed(ActionEvent actionevent) throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Function.calculate(analysis, Analysis.amount, Analysis.price);
		Basic_data_information.count_tot_sales(analysis);
		String str="total sales of medicines: "+Analysis.total_sales;
		JOptionPane.showMessageDialog(null, str, "total sales of medicines", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	/*public static void main(String[] args)
	{
		new Jframe_main();
	}*/

}
