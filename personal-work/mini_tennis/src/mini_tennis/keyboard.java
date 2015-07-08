package mini_tennis;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class keyboard extends JPanel{

	public keyboard() {
		KeyListener listener = new MyKeyListener(); // create the listener so that the JPanel can receive the notifications
		addKeyListener(listener);
		setFocusable(true); // allows KeyboardExample to receive the focus
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mini Tennis");
		keyboard keyboardExample = new keyboard();
		frame.add(keyboardExample);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
// This will write on the console , the name of the method and the key which are affected by the event.
	public class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
	}
}
	

