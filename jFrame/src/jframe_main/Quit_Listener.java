package jframe_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quit_Listener implements ActionListener{

	private Jframe_main adapter;
	
	public Quit_Listener(Jframe_main adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionevent)
	{
		adapter.item2_actionPerformed(actionevent);
	}
}
