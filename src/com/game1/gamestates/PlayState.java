package com.game1.gamestates;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.game1.entities.Asteroid;
import com.game1.entities.Bullet;
import com.game1.entities.Player;
import com.game1.main.Game;
import com.game1.managers.GameKeys;
import com.game1.managers.GameStateManager;

public class PlayState extends GameState {

	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	
	private int level;
	private int totalAsteroids;
	private int numAsteroidsLeft;
	
	
	public PlayState(GameStateManager gsm) {
		super(gsm);

	}
	
	@Override
	public void init(){
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullet>();
		
		player = new Player(bullets);
		
		asteroids = new ArrayList<Asteroid>();
		// testing different size
		asteroids.add(new Asteroid(100,100,Asteroid.LARGE));
		asteroids.add(new Asteroid(200,100,Asteroid.MEDIUM));
		asteroids.add(new Asteroid(300,100,Asteroid.SMALL));
		
		level = 1;
		spawnAsteroids();{
			
		}
		
	}

	private void spawnAsteroids(){
		
		asteroids.clear();
		
		int numToSpawn =4 + level -1 ;
		totalAsteroids = numToSpawn *7;
		numAsteroidsLeft = totalAsteroids;
		
		for (int i= 0; i< numToSpawn; i++){
			
			float x = MathUtils.random(Game.WIDTH);
			float y = MathUtils.random(Game.HEIGHT);
			
			float dx = x - player.getx();
			float dy = y - player.gety();
			float dist = (float) Math.sqrt(dx*dx+dy*dy);
			
			// check if the point is not within the 100 pixels of the player
			while(dist<100){
				 x = MathUtils.random(Game.WIDTH);
				 y = MathUtils.random(Game.HEIGHT);
				
				 dx = x - player.getx();
				 dy = y - player.gety();
				 dist = (float) Math.sqrt(dx*dx+dy*dy);
				
			}
			
			asteroids.add(new Asteroid(x,y,Asteroid.LARGE));
		}
		
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
