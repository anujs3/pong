// Author: Anuj Shah

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.*;
import java.io.*;

public class GameFrame extends JFrame implements WindowListener
{
	private JFrame frame;
	private GamePanel panel;
	private Clip clip;

	public GameFrame (int delay)
	{
		// Creates the frame.
        frame = new JFrame("Pong - 2 Player Mode");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Sets the icon image.
       	Image image = new ImageIcon("Ball.jpg").getImage();
        frame.setIconImage(image);
        // Creates the panel.
        panel = new GamePanel(delay);
        panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
        // Adds the panel to the frame.
        frame.getContentPane().add(panel);
        // Adds music.
		try		
		{
 			File file = new File("8Bit.wav");
			URI uri = file.toURI();
			URL url = uri.toURL();
 			clip = AudioSystem.getClip();
 			AudioInputStream ais = AudioSystem.getAudioInputStream(url);
			clip.open(ais);
		}
		catch (Exception e) {}
		// Adds a WindowListener.
		frame.addWindowListener(this);
	}

    // Shows the frame.
    public void display()
    {
    	frame.pack();
    	frame.setVisible(true);
    }
    
    // Starts music when the frame is opened.
    public void windowOpened (WindowEvent e)
 	{
 		clip.loop(Clip.LOOP_CONTINUOUSLY);
 	}
 	
    // Stops music when the frame is closed.
 	public void windowClosed (WindowEvent e)
 	{
 		clip.stop();
 		GamePanel.time.stop();
 		panel.repaint();
 	}
 	
 	// Plays music if the frame is active.
 	public void windowActivated (WindowEvent e)
 	{
 		clip.loop(Clip.LOOP_CONTINUOUSLY);
 	}
 	
 	// Stops music if the frame is not active.
 	public void windowDeactivated (WindowEvent e)
 	{
 		clip.stop();
 		GamePanel.time.stop();
 		panel.repaint();
 	}
 	
 	// Does nothing.
 	public void windowClosing (WindowEvent e) 
 	{
 	
 	}
 	
 	// Does nothing.
 	public void windowIconified (WindowEvent e) 
 	{
 		
 	}
 	
 	// Does nothing.
 	public void windowDeiconified (WindowEvent e) 
 	{
 		
 	}
}