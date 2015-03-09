package com.game1.managers;

import com.game1.gamestates.GameState;
import com.game1.gamestates.MenuState;
import com.game1.gamestates.PlayState;

public class GameStateManager {

	// current game state
	private GameState gameState;
	
	public static final int MENU = 0;
	public static final int PLAY = 100;
	
	public GameStateManager(){
		setState(MENU);
		
	}
	
	public void setState (int state ){
		if(gameState != null) gameState.dispose();
		
		if(state ==MENU) {
			
			gameState = new MenuState(this);
		}
		 
		if(state == PLAY){
			
			//Switch to play
			gameState = new PlayState(this);
		
		}
			
	}
	
	public void update (float dt){
		
		gameState.update(dt);
	}
	
	public void draw(){
		gameState.draw();
		
	}
	
}
