package jframe_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Frenquency_province_Listener implements ActionListener {
	
    private Jframe_main adapter;
	
	public Frenquency_province_Listener(Jframe_main adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionevent)
	{
		try {
			adapter.thirditem1_actionPerformed(actionevent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
