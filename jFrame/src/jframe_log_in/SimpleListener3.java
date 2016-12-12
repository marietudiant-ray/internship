package jframe_log_in;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleListener3 implements ActionListener
{
	private Jframe_log_in adapter;
	
	public SimpleListener3(Jframe_log_in adapter)
	{
		this.adapter=adapter;
	}
	public void actionPerformed(ActionEvent e)
	{
	   adapter.jButton3_action_performed(e);
	}

}
