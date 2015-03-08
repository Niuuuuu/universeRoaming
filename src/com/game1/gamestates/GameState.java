package com.game1.gamestates;

import com.game1.managers.GameStateManager;

public abstract class GameState {
	
	protected GameStateManager gsm;
	
	protected GameState (GameStateManager gsm) {
		this.gsm = gsm;
	}

	public abstract void init();
	public abstract void update( float dt);
	public abstract void draw();
	public abstract void handleInput();
	public abstract void dispose();
}
