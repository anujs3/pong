// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsButton extends JButton implements ActionListener
{
	private InstructionsFrame frame;
	
	public InstructionsButton (String str)
	{
		super(str);
		// Adds an action listener to the button.
		addActionListener(this);
	}
	
	// Opens the instructions.
	public void actionPerformed (ActionEvent e)
	{
		frame = new InstructionsFrame();
		frame.display();
	}
}