package jframe_sign_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Quit_Listener implements ActionListener{

	private Jframe_sign_in adapter;
	
	public Quit_Listener(Jframe_sign_in adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		adapter.jButton2_actionPerformed(e);
	}


}
