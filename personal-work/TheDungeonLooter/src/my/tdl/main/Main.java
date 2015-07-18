package my.tdl.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import my.project.gop.main.GameWindow;
import my.project.gop.main.SpriteSheet;
import my.tdl.gameloop.GameLoop;


public class Main {
    
	// how to make the screen full size
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();
	
	public static void main(String[] args) {
        GameWindow frame = new GameWindow("TheDLooter", width, height); // wont be needed after we extended it to make it a full screen
	    frame.setFullscreen(1);
	    frame.add(new GameLoop(width,height));
	    frame.setVisible(true);
	}

}
