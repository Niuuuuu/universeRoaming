package com.game1.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game1.entities.Asteroid;
import com.game1.entities.Bullet;
import com.game1.entities.Player;
import com.game1.managers.GameKeys;
import com.game1.managers.GameStateManager;

public class PlayState extends GameState {

	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	
	
	
	public PlayState(GameStateManager gsm) {
		super(gsm);

	}
	
	@Override
	public void init(){
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullet>();
		
		player = new Player(bullets);
		
		asteroids = new ArrayList<Asteroid>();
		asteroids.add(new Asteroid(100,100,Asteroid.LARGE));
		asteroids.add(new Asteroid(200,100,Asteroid.MEDIUM));
		asteroids.add(new Asteroid(300,100,Asteroid.SMALL));
		
	}


	@Override
	public void update(float dt) {
		// get user input
		handleInput(); 
		
		//update player
		player.update(dt);
		
		//update player bullets
		for (int i=0; i<bullets.size(); i++){
			bullets.get(i).update(dt);
			if(bullets.get(i).shouldRemove()) {
				bullets.remove(i);
				i--;
				
			}
			
		}
		
		
		//update asteroids
		for (int i=0; i<asteroids.size(); i++){
			asteroids.get(i).update(dt);
			if(asteroids.get(i).shouldRemove()) {
				asteroids.remove(i);
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
		
		//draw asteroids
		for (int i=0; i<asteroids.size(); i++){
			asteroids.get(i).draw(sr);
		}
	}


	@Override
	public void handleInput() {
		//Gdx.input.isKeyPressed(Keys.LEFT) also works
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)){
			player.shoot();
		}
	}


	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
