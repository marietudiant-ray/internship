package jframe_main;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import internship_work_test.*;


public class Info extends JPanel
{
	  static int exit_in=0;
	  static String varname;
	  static String vartype;
	  JLabel var;
	  JLabel type;
	  JTextField  varInput;
	  JComboBox comboBox;
      public void add(Component c,GridBagConstraints constraints,int x,int y,int w,int h)
      {
    	  constraints.gridx=x;
    	  constraints.gridy=y;
    	  constraints.gridwidth=w;
    	  constraints.gridheight=h;
    	  add(c,constraints);
      }
      
      public Info()
     {
    	GridBagLayout lay=new GridBagLayout();
    	setLayout(lay);
    	var=new JLabel("变量: ");
    	type=new JLabel("类型: ");
        varInput=new JTextField(10);
    	comboBox=new JComboBox();
    	comboBox.addItem("int");
    	comboBox.addItem("varchar(255)");
    	comboBox.addItem("text");
    	comboBox.addItem("date");
    	comboBox.addItem("double");
    	JButton additionbutton=new JButton("添加");
    	JButton exitbutton=new JButton("退出");
    	GridBagConstraints constraints=new GridBagConstraints();
    	constraints.fill=GridBagConstraints.NONE;
    	constraints.weightx=4;
    	constraints.weighty=6;
    	add(var,constraints,0,1,1,1);
    	add(type,constraints,0,2,1,1);
    	add(varInput,constraints,1,1,1,1);
    	add(comboBox,constraints,1,2,1,1);
        add(additionbutton,constraints,0,3,1,1);	
        add(exitbutton,constraints,1,3,1,1);
        additionbutton.addActionListener(new Add_Listener(this));
     }
      
      public void additionbutton_actionPerformed(ActionEvent actionevent) throws SQLException
      {
    	  varname=varInput.getText().trim();
    	  vartype=comboBox.getSelectedItem().toString();
    	  System.out.println(varname+"   "+vartype);
    	  JOptionPane.showMessageDialog(null,"已添加");
    	  Analysis analysis=new Analysis();
    	  analysis.getData(analysis);
    	  Function.addVar(varname, vartype, analysis);
      }

}
