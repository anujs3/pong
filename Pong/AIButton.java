// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AIButton extends JButton implements ActionListener
{
	private AIFrame frame;
	
	public AIButton (String str)
	{
		super(str);
		// Adds an action listener to the button.
		addActionListener(this);
	}
	
	// Opens a new game.
	public void actionPerformed (ActionEvent e)
	{
		frame = new AIFrame(1);
		frame.display();
	}
}