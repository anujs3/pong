// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsPanel extends JPanel
{
	// Dimensions
	private int WIDTH = 500;
	private int HEIGHT = 300;
	
	public InstructionsPanel()
	{
		// Sets the font.
		Font font = new Font("Broadway",Font.BOLD,18);
		setFont(font);
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
		g.drawRect(0,0,WIDTH,HEIGHT);
		g.fillRect(0,0,WIDTH,HEIGHT);
		// Directions
		g.setColor(Color.GREEN);
		g.drawString("CONTROLS",15,20);
		g.drawString("Player 1 -",15,50);
		g.drawString("W: Move Up",15,70);
		g.drawString("S: Move Down",15,90);
		g.drawString("Player 2 -",15,120);
		g.drawString("Up Arrow: Move Up",15,140);
		g.drawString("Down Arrow: Move Down",15,160);
		g.drawString("Backspace: Pause Game",15,190);
		g.drawString("Enter: Resume Game",15,210);
		g.drawString("Objective:",15,240);
		g.drawString("Use the paddles to hit the ball.",15,260);
		g.drawString("The first person to score nine points wins.",15,280);
	}
}