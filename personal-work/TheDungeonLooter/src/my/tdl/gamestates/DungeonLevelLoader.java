package my.tdl.gamestates;

import java.awt.Graphics2D;

import my.tdl.gamestate.GameState;
import my.tdl.gamestate.GameStateManager;

public class DungeonLevelLoader extends GameState {

	public DungeonLevelLoader(GameStateManager gsm) {
		super(gsm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(double deltaTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawString("hello world", 200, 200);
		
	}

}
