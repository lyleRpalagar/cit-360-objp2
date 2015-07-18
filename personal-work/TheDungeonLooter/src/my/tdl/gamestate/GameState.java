package my.tdl.gamestate;

import java.awt.Graphics2D;

public abstract class GameState {

	public GameStateManager gsm;
	
	
	public GameState(GameStateManager gsm) {
		// TODO Auto-generated constructor stub
	 this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void tick(double deltaTime);  // if you extend GameState it will import automatically
	public abstract void render(Graphics2D g);

}
