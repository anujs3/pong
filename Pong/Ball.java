// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ball extends JComponent
{
	private int x;
	private int y;
	private Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.MAGENTA};
	
	// x is the x-coordinate of the ball.
	// y is the y-coordinate of the ball.
	public Ball (int a, int b)
	{
		x = a;
		y = b;
	}
	
	// Draws a ball.
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		if (AIPanel.coloredball == true)
		{
			int rand = (int) (Math.random() * 6);
			g.setColor(colors[rand]);
		}
		else
			g.setColor(Color.GREEN);
		g.drawOval(x,y,10,10);
		g.fillOval(x,y,10,10);		
	}
}