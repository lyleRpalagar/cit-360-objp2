package mini_tennis;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.net.MalformedURLException;
import java.net.URL;


public class Ball {
	// give the ball the exact diameter in size to help detect the collision
	   private static final int DIAMETER = 30;
	
	// starting position of the ball
		int x = 0;
		int y = 0;
		
		// intial speed and direction of the ball
		int xa = 1; 
		int ya = 1;
		
		// refrence the Game object
		private Game game;
		
		public Ball (Game game){
			this.game = game;
		}
		
		// adding coord to move the ball 
		public void moveBall() throws MalformedURLException{
			boolean changeDirection = true;
			// each if sentence limits a border of the canvas
			
			if (x + xa < 0)
				xa = game.speed; // move the ball to the right
			else if (x + xa > game.getWidth() - DIAMETER)
				xa = -game.speed; // move the ball to the left
			else if (y + ya < 0)
				ya = game.speed; // move the ball down	
			// if the ball is under the racquet or touches the bottom border , gameOver() will be enable (see Game.java)
			else if (y + ya > game.getHeight() - DIAMETER)
				game.gameOver();
			
			// if the ball collides with the racquet it will provide new coordinates
			else if (collision()){
				ya = -game.speed;
				y = game.racquet.getTopY() - DIAMETER;
				game.speed++;
			}else{
				changeDirection = false;
			}
			if (changeDirection){
				//plays sound
				 URL BallUrl = new URL("http://www.shockwave-sound.com/sound-effects/explosion-sounds/mortar%20cannon.wav");
				 AudioClip BALL = Applet.newAudioClip(BallUrl);
				 BALL.play();
			}
			
			x = x + xa;
			y = y + ya;
		}
		
		// if the collision takes place, the change of direction and the position of the ball will change.
		private boolean collision() {
			return game.racquet.getBounds().intersects(getBounds());
		}

		public void paint(Graphics2D g) {
			g.fillOval(x, y, DIAMETER, DIAMETER);
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, DIAMETER, DIAMETER);
		}
		
}
