package jframe_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Add_Listener implements ActionListener
{
	private Info adapter;
	
	public Add_Listener(Info adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionevent)
	{
		try {
			adapter.additionbutton_actionPerformed(actionevent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
