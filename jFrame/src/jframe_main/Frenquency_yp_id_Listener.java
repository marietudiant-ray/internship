package jframe_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Frenquency_yp_id_Listener implements ActionListener {
	
    private Jframe_main adapter;
	
	public Frenquency_yp_id_Listener(Jframe_main adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionevent)
	{
		try {
			adapter.thirditem2_actionPerformed(actionevent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
