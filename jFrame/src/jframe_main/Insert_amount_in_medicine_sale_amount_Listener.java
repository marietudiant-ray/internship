package jframe_main;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Insert_amount_in_medicine_sale_amount_Listener implements ActionListener
{
	private Jframe_main adapter;
	
	public Insert_amount_in_medicine_sale_amount_Listener(Jframe_main adapter)
	{
		this.adapter=adapter;
	}
	
	public void actionPerformed(ActionEvent actionevent)
	{
		try {
			adapter.item18_actionPerformed(actionevent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}