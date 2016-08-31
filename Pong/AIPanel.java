// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.*;
import java.io.*;

public class AIPanel extends JPanel implements ActionListener, KeyListener
{
	// Timer
	public static Timer time;
	// Delay
	private int del;
	// Clip
	private Clip clip;
	// Secret
	public static boolean coloredball = false;
	// Dimensions
	private int WIDTH = 500;
	private int HEIGHT = 300;
	// Coordinates of the Paddles
	private int locx1 = 15;
	private int locy1 = 120;
	private double locx2 = 480;
	private double locy2 = 120;
	// Variables that Change the Coordinates of the Paddles
	private int changeY1 = 0;
	private double changeY2 = 0;
	// Scores
	private int scoreA = 0;
	private int scoreB = 0;
	// Coordinates of the Ball
	private double locxB = WIDTH/2;
	private double locyB = HEIGHT/2;
	// Variables that Change the Direction of the Ball
	private boolean right = true;
	private boolean up = false;
	private boolean down = false;
	private boolean upmid = false;
	private boolean downmid = false;
	
	public AIPanel (int delay)
	{
		// Starts the timer.
		time = new Timer(delay,this);
		time.start();
		del = delay;
		// Adds a KeyListener.
		addKeyListener(this);
		setFocusable(true);
		// Adds sound effects.
		try		
		{
			File file = new File("PongSound.wav");
			URI uri = file.toURI();
			URL url = uri.toURL();
 			clip = AudioSystem.getClip();
 			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			clip.open(ais);
		}
		catch (Exception e) {}
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
		// Paddle 1
		Paddle p1 = new Paddle(locx1,locy1);
		p1.paintComponent(g);
		// Paddle 2
		Paddle p2 = new Paddle((int)locx2,(int)locy2);
		p2.paintComponent(g);
		// Ball
		Ball ball = new Ball((int)locxB,(int)locyB);
		ball.paintComponent(g);
		// Scores
		g.setColor(Color.GREEN);
		g.drawString(""+scoreA,p1.getX()+230,20);
		g.drawString(""+scoreB,p2.getX()-220,20);
		g.drawString("-",255,20);
		// Winner
		if (scoreA == 9)
		{
			g.drawString("Player 1 Wins!",220,100);
			if (coloredball != true)
			{
				coloredball = true;
				g.drawString("Multi-Colored Ball Unlocked!!",180,120);
			}
		}
		if (scoreB == 9)
			g.drawString("Computer Wins!",215,100);
		// Pause
		if (time.isRunning() == false && scoreA != 9 && scoreB != 9)
		{
			g.drawString("[PAUSED]",230,40);
			g.drawString("[Press Enter to Continue]",190,60);
		}
	}

	public void actionPerformed (ActionEvent e)
	{
		// Sets the delay.
		time.setDelay(del);
		// Changes the coordinates of the paddles.
		locy1 += changeY1;
		locy2 += changeY2;
		if (locy1 < 0)
		{
			changeY1 = 0;
			locy1 = 0;
		}
		if (locy1 > HEIGHT - 60)
		{
			changeY1 = 0;
			locy1 = HEIGHT - 60;
		}
		// Moves the ball left and right.
		if (locyB >= (locy1 - 10) && locyB <= (locy1 + 60) && (locx1) == locxB)
		{
			right = true;
			clip.loop(0);
			clip.setFramePosition(0);
		}
		if (locyB >= (locy2 - 10) && locyB <= (locy2 + 60) && (locx2 - 5) == locxB)
		{
			right = false;
			clip.loop(0);
			clip.setFramePosition(0);
		}
		if (right)
			locxB++;
		else
			locxB--;
		// Moves the ball up and down.
		if (locyB >= (locy1 - 10) && locyB <= (locy1 + 5) && (locx1) == locxB)
		{
			up = true;
			down = false;
			upmid = false;
			downmid = false;
		}
		if (locyB >= (locy2 - 10) && locyB <= (locy2 + 5) && (locx2 - 5) == locxB)
		{
			up = true;
			down = false;
			upmid = false;
			downmid = false;
		}
		if (locyB >= (locy1 + 5) && locyB <= (locy1 + 20) && (locx1) == locxB)
		{
			up = false;
			down = false;
			upmid = true;
			downmid = false;
		}
		if (locyB >= (locy2 + 5) && locyB <= (locy2 + 20) && (locx2 - 5) == locxB)
		{
			up = false;
			down = false;
			upmid = true;
			downmid = false;
		}
		if (locyB >= (locy1 + 30) && locyB <= (locy1 + 45) && (locx1) == locxB)
		{
			up = false;
			down = false;
			upmid = false;
			downmid = true;
		}
		if (locyB >= (locy2 + 30) && locyB <= (locy2 + 45) && (locx2 - 5) == locxB)
		{
			up = false;
			down = false;
			upmid = false;
			downmid = true;
		}
		if (locyB >= (locy1 + 45) && locyB <= (locy1 + 60) && (locx1) == locxB)
		{
			up = false;
			down = true;
			upmid = false;
			downmid = false;
		}
		if (locyB >= (locy2 + 45) && locyB <= (locy2 + 60) && (locx2 - 5) == locxB)
		{
			up = false;
			down = true;
			upmid = false;
			downmid = false;
		}
		if (locyB > (locy1 + 20) && locyB < (locy1 + 30) && (locx1) == locxB)
		{
			up = false;
			down = false;
			upmid = false;
			downmid = false;
		}
		if (locyB > (locy2 + 20) && locyB < (locy2 + 30) && (locx2 - 5) == locxB)
		{
			up = false;
			down = false;
			upmid = false;
			downmid = false;
		}
		if (locyB == 0)
		{
			up = false;
			down = true;
			upmid = false;
			downmid = false;
			clip.loop(0);
			clip.setFramePosition(0);
		}
		if (locyB == 290)
		{
			up = true;
			down = false;
			upmid = false;
			downmid = false;
			clip.loop(0);
			clip.setFramePosition(0);
		}
		if (up)
			locyB-=0.5;
		if (down)
			locyB+=0.5;
		if (upmid)
			locyB-=0.25;
		if (downmid)
			locyB+=0.25;
		// Determines how the computer player will move.
		if (right == true && locxB >= (WIDTH/2))
		{
			if (locyB > (locy2 + 10) && locy2 > 0 && locy2 < (HEIGHT - 60))
				changeY2 = 0.5;
			if (locyB < (locy2 + 10) && locy2 > 0 && locy2 < (HEIGHT - 60))
				changeY2 = -0.5;
			if (locy2 <= 0)
				changeY2 = 0.5;
			if (locy2 >= (HEIGHT - 60))
				changeY2 = -0.5;
			if (locyB > (locy2) && locyB < (locy2 + 50) && locy2 > 0 && locy2 < (HEIGHT - 60))
				changeY2 = 0;
		}
		else
			changeY2 = 0;
		// Resets the ball if it is out of bounds.
		if (locxB < 15)
		{
			locxB = WIDTH/2;
			locyB = HEIGHT/2;
			up = false;
			down = false;
			upmid = false;
			downmid = false;
			scoreB++;
			time.setDelay(300);
		}
		if (locxB > 485)
		{
			locxB = WIDTH/2;
			locyB = HEIGHT/2;
			up = false;
			down = false;
			upmid = false;
			downmid = false;
			scoreA++;
			time.setDelay(300);
		}
		// Game Over
		if (scoreA == 9 || scoreB == 9)
		{
			setFocusable(false);
			time.removeActionListener(this);
		}
		repaint();
	}
		
	public void keyPressed (KeyEvent e)
	{
		int code = e.getKeyCode();
		// Moves the paddle up and down when the keys are pressed.
		if (code == KeyEvent.VK_W)
			changeY1 = -1;
		if (code == KeyEvent.VK_S)
			changeY1 = 1;
		// Pauses the game.
		if (code == KeyEvent.VK_BACK_SPACE)
		{
			time.stop();
			repaint();
		}
		// Resumes the game.
		if (code == KeyEvent.VK_ENTER)
			time.start();
	}

	public void keyReleased (KeyEvent e)
	{
		int code = e.getKeyCode();
		// Stops the paddle from moving when the keys are released.
		if (code == KeyEvent.VK_W)
			changeY1 = 0;
		if (code == KeyEvent.VK_S)
			changeY1 = 0;
	}

	// Does nothing.
	public void keyTyped (KeyEvent e) 
	{
		
	}
}