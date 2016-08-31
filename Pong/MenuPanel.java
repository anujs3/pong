// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JPanel
{
	// Buttons
	private NormalButton button1;
	private FastButton button2;
	private AIButton button3;
	private InstructionsButton button4;
	// Dimensions
	private int WIDTH = 500;
	private int HEIGHT = 300;
	
	public MenuPanel()
	{
		setLayout(null);
		// Creates a new NormalButton.
		button1 = new NormalButton("NORMAL MODE");
		button1.setBounds(90,130,150,40);
		add(button1);
		// Creates a new FastButton.
		button2 = new FastButton("FAST MODE");
		button2.setBounds(90,190,150,40);
		add(button2);
		// Creates a new AIButton.
		button3 = new AIButton("VS COMPUTER");
		button3.setBounds(260,130,150,40);
		add(button3);
		// Creates a new InstructionsButton.
		button4 = new InstructionsButton("INSTRUCTIONS");
		button4.setBounds(260,190,150,40);
		add(button4);
	}
	
	// Returns the width of the panel.
	public int getWidth()
	{
		return WIDTH;
	}

	// Returns the height of the panel.
	public int getHeight()
	{
		return HEIGHT;
	}
	
	// Draws the panel.
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		// Background
		g.setColor(Color.BLACK);
		g.drawRect(0,0,500,300);
		g.fillRect(0,0,500,300);
		// Author
		g.setColor(Color.GREEN);
		g.drawString("Anuj Shah",5,20);
		// Title
		Font font = new Font("Broadway",Font.BOLD,50);
		g.setFont(font);
		g.drawString("PONG",170,100);
	}
}