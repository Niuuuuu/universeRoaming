package com.game1.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.game1.managers.GameInputProcessor;
import com.game1.managers.GameKeys;

public class Game implements ApplicationListener {
	
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera cam;
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
		
	
	}
	public void render(){
		
		//clear screens to black
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		
		GameKeys.update();
		
	}

	public void resize ( int width, int height) {}
	public void pause() {}
	public void resume(){}
	public void dispose(){}






}
