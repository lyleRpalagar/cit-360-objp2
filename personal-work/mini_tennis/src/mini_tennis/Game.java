package mini_tennis;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Game extends JPanel{	
	
	
	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;
	
	private int getScore() {
		return speed - 1;
	}
	
	public Game() throws MalformedURLException {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
		 // TO DO: find good .wav background music 
		//URL BackUrl = new URL("");
		 //AudioClip BACK = Applet.newAudioClip(BackUrl);
		 //BACK.loop();
	}
	
	
	private void move() throws Exception{
		ball.moveBall();
		racquet.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		
		// number font color 
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}
	
	// launches a pop up with the message "Game Over" and a button to accept. This will be called from the Ball class when it 
	// detects that it has got to the lower border of the canvas 
	 URL BackUrl = new URL("http://www.shockwave-sound.com/sound-effects/explosion-sounds/mortar%20cannon.wav");
	 AudioClip BACK = Applet.newAudioClip(BackUrl);
	 public void gameOver() throws MalformedURLException {
	 BACK.stop();
		
		URL GameOverUrl = new URL("http://themushroomkingdom.net/sounds/wav/smb/smb_gameover.wav");
		AudioClip GAMEOVER = Applet.newAudioClip(GameOverUrl);
		GAMEOVER.play();
		
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT); // once you hit accept it will abort the game. without this it will give make the popup a loop
	}
	
	
	public static void main(String[] args) throws Exception{	
				
		// creating the window for the game
		JFrame frame = new JFrame("Mini Tennis"); // Title for the window bar
		
		Game game = new Game(); // create the game object
		frame.add(game); // add the paint to the frame
		
		frame.setSize(300,400); // Set the size of the window that will be displayed
		frame.setVisible(true); // Shows the window 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program 
		frame.setLocationRelativeTo(null); // puts your window to the middle of the screen
		

		
		// Start the game loop where you call the moveBall() and the repaint () 
		while (true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
