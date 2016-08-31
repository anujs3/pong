// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paddle extends JComponent
{
	private int locx;
	private int locy;

	// locx is the x-coordinate of the paddle.
	// locy is the y-coordinate of the paddle.
	public Paddle (int x, int y)
	{
		locx = x;
		locy = y;
	}

	// Returns the x-coordinate of the paddle.
	public int getX()
	{
		return locx;
	}

	// Returns the y-coordinate of the paddle.
	public int getY()
	{
		return locy;
	}

	// Draws a green paddle.
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillRect(locx,locy,5,60);
		g.setColor(Color.WHITE);
		g.drawRect(locx,locy,5,60);
	}
}