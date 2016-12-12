package jframe_frequency_yp_price;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import internship_work_test.Analysis;
import internship_work_test.Basic_data_information;
import internship_work_test.Frenquency_Analysis;

public class Jframe_frequence_yp_price {

	public Jframe_frequence_yp_price() throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Basic_data_information.count_total_amount();
		Frenquency_Analysis.yp_price_frequency_analysis(analysis);
		String str="";
		for(int i=0;i<10;i++)
		{
			BigDecimal decimal = new BigDecimal((double)i/10);
			BigDecimal decimal1 = new BigDecimal((double)(i+1)/10);
			//åSystem.out.println(decimal1.setScale(1, BigDecimal.ROUND_HALF_UP));
			str+="["+decimal.setScale(1, BigDecimal.ROUND_HALF_UP)+","+decimal1.setScale(1, BigDecimal.ROUND_HALF_UP)+"]"+"          "+Analysis.frequency_yp_price[i]+"          "+Analysis.frequency_yp[i]+"\n";
		}
		for(int i=1;i<100;i++)
		{
			str+="["+i+","+(i+1)+"]"+"          "+Analysis.frequency_yp_price[i+9]+"          "+Analysis.frequency_yp[i+9]+"\n";
		}
		for(int i=1;i<10;i++)
		{
			str+="["+i*100+","+(i*100+100)+"]"+"          "+Analysis.frequency_yp_price[i+108]+"          "+Analysis.frequency_yp[i+108]+"\n";
		}
		str+="[1000，-]"+"       "+Analysis.frequency_yp_price[118]+"         "+Analysis.frequency_yp[118];
		JOptionPane.showMessageDialog(null, str, "药品价格频率", JOptionPane.INFORMATION_MESSAGE);
	}
}
