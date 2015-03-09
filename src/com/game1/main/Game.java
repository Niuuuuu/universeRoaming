package com.game1.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.game1.managers.GameInputProcessor;
import com.game1.managers.GameKeys;
import com.game1.managers.GameStateManager;
import com.game1.managers.Jukebox;

public class Game implements ApplicationListener {
	
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera cam;
	
	private GameStateManager gsm;
	
	public void create(){
		
		
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT= Gdx.graphics.getHeight();

		//setting up camera, moving camera into right place 
		cam = new OrthographicCamera(WIDTH,HEIGHT);
		cam.translate(WIDTH/2, HEIGHT/2);
		cam.update();
		Gdx.input.setInputProcessor(
			new GameInputProcessor()
		);
		
		//loading sounds
		Jukebox.load("sounds/explode.ogg", "explode");
		Jukebox.load("sounds/extralife.ogg", "extralife");
		Jukebox.load("sounds/largesaucer.ogg", "largesaucer");
		Jukebox.load("sounds/pulsehigh.ogg", "pulsehigh");
		Jukebox.load("sounds/pulselow.ogg", "pulselow");
		Jukebox.load("sounds/saucershoot.ogg", "saucershoot");
		Jukebox.load("sounds/shoot.ogg", "shoot");
		Jukebox.load("sounds/smallsaucer.ogg", "smallsaucer");
		Jukebox.load("sounds/thruster.ogg", "thruster");
		
		gsm = new GameStateManager();
		
	
	}
	public void render(){
		
		//clear screens to black
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		//the time spent since last time of calling render, getDeltaTime
		// this is to find out how much to make the game forward
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();
		
		
		GameKeys.update();
		
	}

	public void resize ( int width, int height) {}
	public void pause() {}
	public void resume(){}
	public void dispose(){}






}
