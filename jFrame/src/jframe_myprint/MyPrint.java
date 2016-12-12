package jframe_myprint;

import java.util.List;

import javax.swing.JOptionPane;

import yaopin.Medicine4;

public class MyPrint {
	
	public MyPrint()
	{
		
	}
	
	public static void myprint(List<Medicine4> a)
	{
	   String str="";
	   str+="medicine id"+"    "+"medicine price variance"+"    "+"medicine different price number"+"\n";
	   for(int i=0;i<a.size();i++)
	   {
		   str+=a.get(i).getMedicineId()+"                 "+a.get(i).getMedicineVariance()+"                                         "+a.get(i).getMedicineNumber()+"\n";
	   }
	   JOptionPane.showMessageDialog(null, str, "variance of medicine price", JOptionPane.INFORMATION_MESSAGE);
	}
}
