package jframe_sign_in;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class MyPanel extends JPanel{
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ImageIcon image=new ImageIcon("/Users/marui/Documents/workspace/jframe_log_in/signup.jpg");
        g.drawImage(image.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
     }

}
