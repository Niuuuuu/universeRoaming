package com.game1.entities;

import com.game1.main.Game;

public class Player extends SpaceObject{

	private boolean left;
	private boolean right;
	private boolean up;
	
	private float maxSpeed;
	private float acceleration;
	private float decelaration;
	
	public Player(){
		
		x = Game.WIDTH /2;
		y = Game.HEIGHT /2;
		
		maxSpeed = 300;
		acceleration = 200;
		decelaration = 10;
		
		shapex = new float[4];
		shapey = new float [4];

		
	}
	
	
	private void setShape(){
		
		
		
		
	}
	
	
	
	
}
