package my.project.gop.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class GameWindow extends JFrame {
    // To make the window a full screen
	  boolean fse = false;
	  int fsm = 0; // full screen mode
	  GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[1]; // how many screens do you have
	
	
	public GameWindow(String title, int width, int height) {
		setTitle(title); // show title of the game
		setSize(width, height); //set the window size
		setLocationRelativeTo(null); // puts the window into the center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when you close the program it shuts down the widow
	    setResizable(false); // Keep from resizing screen
	}
	
	// check to see if its full screen
     private void setfullscreen(){
    	 switch(fsm){
    	 case 0 :
    		 System.out.println("No Fullscreen");
    		 setUndecorated(false); 
    		 break;
    	 case 1 :
    		 setUndecorated(true); // removes bars and boxes such as minimize, fullscreen , and close applets
    		 setExtendedState(JFrame.MAXIMIZED_BOTH); // sets it to the largest size possible
    		 break;
    	 case 2 :
    		 setUndecorated(true); // removes bars and boxes such as minimize, fullscreen , and close applets
    		 device.setFullScreenWindow(this);
    		 break;
    	 }
     }
     
     // set the screen to be full screen
     public void setFullscreen(int fsnm){
       fse = true;
       if(fsm <= 2){
    	   this.fsm = fsnm;
    	   setfullscreen();
       }else{
          System.err.println("Error" + fsnm + "is not Supported!");
       }
     }
}
