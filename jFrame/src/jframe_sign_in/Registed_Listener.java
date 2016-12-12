package jframe_sign_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Registed_Listener implements ActionListener{

	private Jframe_sign_in adapter;
	
	public Registed_Listener(Jframe_sign_in adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		try {
			adapter.jButton1_actionPerformed(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}



