package jframe_frequency_province;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTable;
import internship_work_test.*;

public class Jframe_frequency_province {
	
	public Jframe_frequency_province() throws SQLException
	{
		Analysis analysis=new Analysis();
		analysis.getData(analysis);
		Function.cut_out(analysis.sc_fac, analysis.province);
		Function.getZone(analysis);
		Frenquency_Analysis.zone_frequency_anlalysis(analysis);
		JFrame jf=new JFrame();
		Object[][] info= {
				{Analysis.zone[0],Analysis.frequency_zn[0],Analysis.freauency_zone[0]},
				{Analysis.zone[1],Analysis.frequency_zn[1],Analysis.freauency_zone[1]},
				{Analysis.zone[2],Analysis.frequency_zn[2],Analysis.freauency_zone[2]},
				{Analysis.zone[3],Analysis.frequency_zn[3],Analysis.freauency_zone[3]},
		};
		String[] Name={"地区","数量","所占比率"};
		JTable table=new JTable(info,Name);
		table.setPreferredScrollableViewportSize(new Dimension(1000,500));
		jf.getContentPane().add(table,BorderLayout.CENTER);
		jf.getContentPane().add(table.getTableHeader(), BorderLayout.NORTH);
		jf.setTitle("城市频率分布表");
		jf.pack();
		jf.setVisible(true);
	//	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocation(800, 700);
	}
	
	/*public static void main(String[] args) throws SQLException
	{
		new Jframe_frequency_province();
	}*/

}

