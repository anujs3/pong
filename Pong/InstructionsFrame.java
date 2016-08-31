// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsFrame extends JFrame
{
	private JFrame frame;
	private InstructionsPanel panel;

	public InstructionsFrame()
	{
		// Creates the frame.
        frame = new JFrame("Instructions");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Sets the icon image.
        Image image = new ImageIcon("Ball.jpg").getImage();
        frame.setIconImage(image);
        // Creates the panel.
        panel = new InstructionsPanel();
        panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
        // Adds the panel to the frame.
        frame.getContentPane().add(panel);
	}

    // Shows the frame.
    public void display()
    {
    	frame.pack();
    	frame.setVisible(true);
    }
}