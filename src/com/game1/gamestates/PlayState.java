package com.game1.gamestates;

import com.game1.managers.GameStateManager;

public class PlayState extends GameState {

	public PlayState(GameStateManager gsm) {
		super(gsm);

	}
	
	@Override
	public void init(){}


	@Override
	public void update(float dt) {
		System.out.println("Play state updating");
		
	}


	@Override
	public void draw() {
		System.out.println("Play state drawing");
		
	}


	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
