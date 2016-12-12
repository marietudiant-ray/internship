package jframe_frenquency_yp_id;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;

import internship_work_test.Analysis;
import internship_work_test.Frenquency_Analysis;
import internship_work_test.Function;

public class Jframe_frenquency_yp_id {
	
	public Jframe_frenquency_yp_id() throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Frenquency_Analysis.yp_id_frequency_analysis(analysis);
		JFrame jf=new JFrame();
		Object[][] info= {
				{Analysis.different_yp_id.get(0),Analysis.frequency_yi[0],Analysis.frenquency_yp_id[0]},
				{Analysis.different_yp_id.get(1),Analysis.frequency_yi[1],Analysis.frenquency_yp_id[1]},
				{Analysis.different_yp_id.get(2),Analysis.frequency_yi[2],Analysis.frenquency_yp_id[2]},
				{Analysis.different_yp_id.get(3),Analysis.frequency_yi[3],Analysis.frenquency_yp_id[3]},
		};
		String[] Name={"药品id","数量","所占比率"};
		JTable table=new JTable(info,Name);
		table.setPreferredScrollableViewportSize(new Dimension(1000,500));
		jf.getContentPane().add(table,BorderLayout.CENTER);
		jf.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		jf.setTitle("药品频率分布表");
		jf.pack();
		jf.setVisible(true);
	//	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(800, 700);
	}

}
