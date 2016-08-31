// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame
{
	private JFrame frame;
	private MenuPanel panel;

	public MenuFrame()
	{
		// Creates the frame.
        frame = new JFrame("Welcome to Pong!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Sets the icon image.
        Image image = new ImageIcon("Ball.jpg").getImage();
        frame.setIconImage(image);
        // Creates the panel.
        panel = new MenuPanel();
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