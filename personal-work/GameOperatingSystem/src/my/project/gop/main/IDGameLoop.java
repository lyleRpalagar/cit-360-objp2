package my.project.gop.main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class IDGameLoop extends JPanel implements Runnable{
  private Thread thread;
  private boolean running;
  
  private int fps;
  private int tps;
  
  private int width;
  private int height;
  
  public Graphics2D graphics2D;
  private BufferedImage img; //draw everything inside this buffer image
  
  
  public static double currFPS = 120D; // 120 frames per sec
  
 
  
	public IDGameLoop(int width, int height)  {
       this.width  = width;
       this.height = height;
       
       //setting default
       setPreferredSize(new Dimension(width,height));
       setFocusable(false);
	}
	
	@Override
		public void addNotify() {
			super.addNotify();			
			if(thread == null){
				thread = new Thread(this);
				thread.start();
			}
		}
	
	@Override
	public void run(){
		 // running the game loop
		/*INIT */
		init(); // intialize our overall game objs.
		
		//variables
		long lastTime = System.nanoTime(); // returns the current time in precise nano time
		double nsPerTick = 1000000000D / currFPS;
		int frames = 0;
		int ticks = 0;
		long lastTimer = System.currentTimeMillis(); //returns the current time in mill secs.
		double deltaTime = 0; // delta time will speed up the game if it goes slow
		
		
		while(running){
			long now = System.nanoTime();
			deltaTime += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = false; // set it to specify FPS
			
			while(deltaTime >= 1){
				ticks++;
				/*TICK + DeltaTime */
				tick(deltaTime); // passing the deltaTime into our tick, this will also speed up any functions that are going slow
				deltaTime -=1;
				shouldRender = true;
			}
			
			if(shouldRender == true){
				frames++;
				/*Render*/
				render();
			}
			
			//sleepy
			try {Thread.sleep(2);}catch (InterruptedException e){e.printStackTrace();}
		  if(System.currentTimeMillis() - lastTimer >= 1000){
			  lastTimer += 1000;
			  tps = frames;
			  fps = ticks;
			  frames = 0;
			  ticks = 0;
		  }
		}
	}
	
	public void init() {
		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2D = (Graphics2D) img.getGraphics();
		running = true;
		
	}
	
	
	public void tick(double deltaTime) {
	}

	public void render() {		
	graphics2D.clearRect(0, 0, width, height);
	}

	public void clear(){
		Graphics g2 = getGraphics();
		if(img !=null){
			g2.drawImage(img, 0, 0, null);
		}
		g2.dispose();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
