package com.game1.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game1.entities.Player;
import com.game1.managers.GameStateManager;

public class PlayState extends GameState {

	private ShapeRenderer sr;
	
	private Player player;
	
	
	
	public PlayState(GameStateManager gsm) {
		super(gsm);

	}
	
	@Override
	public void init(){
		
		sr = new ShapeRenderer();
		
		player = new Player();
		
		
	}


	@Override
	public void update(float dt) {
		player.update(dt);
		
	}


	@Override
	public void draw() {
		player.draw(sr);
		
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
