package com.game1.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game1.entities.Bullet;
import com.game1.entities.Player;
import com.game1.managers.GameKeys;
import com.game1.managers.GameStateManager;

public class PlayState extends GameState {

	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	
	
	
	public PlayState(GameStateManager gsm) {
		super(gsm);

	}
	
	@Override
	public void init(){
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullet>();
		
		player = new Player(bullets);
		
		
	}


	@Override
	public void update(float dt) {
		// get user input
		handleInput(); 
		
		//update player
		player.update(dt);
		
		//update player bullets
		for (int i=0; i<bullets.size(); i++){
			bullets.get(i).upate(dt);
			if(bullets.get(i).shouldRemove()) {
				bullets.remove(i);
				i--;
				
			}
			
		}
		
	}


	@Override
	public void draw() {
		//draw player
		player.draw(sr);
		
		//drae bullets
		for (int i=0; i<bullets.size(); i++){
			bullets.get(i).draw(sr);
			
		}
		
	}


	@Override
	public void handleInput() {
		//Gdx.input.isKeyPressed(Keys.LEFT) also works
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		if(Gdx.input.isKeyPressed(Keys.SPACE)){
			player.shoot();
		}
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
