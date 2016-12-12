package jframe_sign_in;

import java.awt.BorderLayout;
import jframe_log_in.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Jframe_sign_in extends JFrame{
	
	private Connection connection;
	private Statement statement;
	private final String url="jdbc:mysql://localhost:3306/internship";
	private final String user="root";
	private final String password="mari901214";
	private final String Driver_Mysql="com.mysql.jdbc.Driver";
	private ResultSet result;
	
	private JButton jButton1=new JButton();
	private JButton jButton2=new JButton();
	private JLabel jLabel1=new JLabel();
	private JLabel jLabel2=new JLabel();
	private JLabel jLabel3=new JLabel();
	private JLabel jLabel4=new JLabel();
	private JTextField jUser=new JTextField();
	private JPasswordField jPass=new JPasswordField();
	private JPasswordField jPassNew=new JPasswordField();
	public MyPanel mp;
	
    private Font font=new Font("楷体",Font.PLAIN,16);
    private Font newfont=new Font("宋体",Font.BOLD,20);
	
	public void jInit()
	{
	    setTitle("sign up interface");
		mp=new MyPanel();
		mp.setLayout(null);
		
		jButton1.setText("sign up");
		jButton1.setBounds(new Rectangle(50,250,100,45));
		jButton1.setForeground(Color.DARK_GRAY);
		jButton1.setFont(font);
		
		jButton2.setText("quit");
		jButton2.setBounds(new Rectangle(250,250,100,45));
		jButton2.setForeground(Color.DARK_GRAY);
		jButton2.setFont(font);
		
		jLabel1.setText("user :");
		jLabel1.setBounds(new Rectangle(50,50,70,40));
		jLabel1.setForeground(Color.yellow);
		jLabel1.setFont(font);
		
		jLabel2.setText("password :");
		jLabel2.setBounds(new Rectangle(50,100,70,40));
		jLabel2.setForeground(Color.yellow);
		jLabel2.setFont(font);
        		
		jLabel3.setText("enter it again ：");
		jLabel3.setBounds(new Rectangle(50,150,150,40));
		jLabel3.setForeground(Color.yellow);
		jLabel3.setFont(font);
		
		jLabel4.setText("Ray");
		jLabel4.setBounds(0, 0, 100, 50);
		jLabel4.setForeground(Color.CYAN);
		jLabel4.setFont(newfont);
		
		jUser.setBounds(new Rectangle(200,50,150,40));
		jPass.setBounds(new Rectangle(200,100,150,40));
		jPassNew.setBounds(new Rectangle(200,150,150,40));
		
		mp.add(jButton1);
		mp.add(jButton2);
		mp.add(jLabel1);
		mp.add(jLabel2);
		mp.add(jLabel3);
		mp.add(jLabel4);
	    mp.add(jPass);
	    mp.add(jPassNew);
	    mp.add(jUser);
	    
	    this.getContentPane().setLayout(new BorderLayout());
	    this.add(mp);
	    this.setBounds(300,200, 400, 350);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    jButton1.addActionListener(new Registed_Listener(this));
	    jButton2.addActionListener(new Quit_Listener(this));
	}
	
	public void jButton1_actionPerformed(ActionEvent e) throws SQLException
	{
	
	    String jusername=jUser.getText().trim();
		char[] jpass=jPass.getPassword();
		String jpass1=new String(jpass);
		char[] jpassnew=jPassNew.getPassword();
		String jpass2=new String(jpassnew);
		int pass1=0,pass2=0;
	    int missingPassword=0;
		if(jpass1.equals("")|| jpass2.equals(""))
		{
             
			JOptionPane.showMessageDialog(this, "password can't be null", "error", JOptionPane.ERROR_MESSAGE);
	        missingPassword++;	
		}
		else
		{
			pass1=Integer.valueOf(jpass1);
			pass2=Integer.valueOf(jpass2);
		}
        if(missingPassword==0)
        {
		if(jusername.equals(""))
		{
			JOptionPane.showMessageDialog(this, "user name can't be null", "error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			try {
				Class.forName(Driver_Mysql);
				System.out.println("mysql load successful");
				connection=DriverManager.getConnection(url, user, password);
				statement=connection.createStatement();
				String sql="select name from 用户 where name="+"\""+jusername+"\";";
				result=statement.executeQuery(sql);
				if(result.next())
				{
					JOptionPane.showConfirmDialog(this, "user name already exits","duplicate name", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(pass1==pass2)
					{
						String sql2="insert into 用户 (name,password) values "+"("+"\""+jusername+"\","+pass1+");";
					//	System.out.println(sql2);
						statement.execute(sql2);
						JOptionPane.showMessageDialog(this, "you have successfully registed", "successful registry", JOptionPane.INFORMATION_MESSAGE);
						this.dispose();
						new Jframe_log_in();
						
					}
					else{
						JOptionPane.showMessageDialog(this, "two enters different", "error", JOptionPane.ERROR_MESSAGE);
					}
				}
			 
			
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally{
				    if(result !=null) result.close();
				    if(connection !=null) connection.close();
				    if(statement !=null)  statement.close();
			}
		}
	}
        
	}
	
	public void jButton2_actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}
	
	public Jframe_sign_in()
	{
		jInit();
	}
	
	
	/*public static void main(String[] args)
	{
		Jframe_sign_in jf=new Jframe_sign_in();
	}*/

}
