// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NormalButton extends JButton implements ActionListener
{
	private GameFrame frame;
	
	public NormalButton (String str)
	{
		super(str);
		// Adds an action listener to the button.
		addActionListener(this);
	}
	
	// Opens a new game.
	public void actionPerformed (ActionEvent e)
	{
		frame = new GameFrame(1);
		frame.display();
	}
}