package mini_tennis;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
	// variables for detecting collision
	
	// we use these static variables because the value is used in both the paint method as in getBounds().
	// with this constant we can change the values here rather than in both places.
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	
	// racquet movement
	int x = 0; 
	int xa = 0; 
	
	private Game game;

	public Racquet(Game game) {
		this.game= game;
	}

	// moves the racquet but also makes sure that the racquet doesnt move the boarder.
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth()- WIDTH)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT); // color and size of the racquet sprite
	}

	// when the user no longer holds down the key stroke ( left or right ) it will move the sprite back to 0
	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	// depending on the key stroke ( left or right ) it will add 1 movement either directions
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.speed;
	}
	
	// getBounds() is in java lib. it will return a rectangle type of object, indicating the position of the racquet.
	
	// java.awt.Rectangle has an intersecting method which we are using. This will return true when two rectangles occupy
	// the same space.
	
	// detecting collision
	public Rectangle getBounds(){
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}
	
	public int getTopY(){
		return Y;
	}
}