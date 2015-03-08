package com.game1.managers;

import com.game1.gamestates.GameState;

public class GameStateManager {

	// current game state
	private GameState gameState;
	
	public static final int MENU = 0;
	public static final int PLAY = 100;
	
	public GameStateManager(){
		
	}
	
	public void setState (int state ){
		
		if(state ==MENU) {
			
			//Switch to menu
		}
		
		if(state == PLAY){
			
			//Switch to play
		}
			
	}
	
	public void update (float dt){
		
		gameState.update(dt);
	}
	
	public void draw(){
		gameState.draw();
		
	}
	
}
