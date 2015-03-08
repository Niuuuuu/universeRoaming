package com.game1.entities;

import com.badlogic.gdx.math.MathUtils;
import com.game1.main.Game;

public class Player extends SpaceObject{

	private boolean left;
	private boolean right;
	private boolean up;
	
	private float maxSpeed;
	private float acceleration;
	private float decelaration;
	private float pi= 3.141592654f;
	
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
		
		//setting up the player's shape by doing simple calculation from the 
		// center of the game, check pic folder for diagram explanation
		//first point, the point above center
		shapex[0]= x+ MathUtils.cos(radians) *8;
		shapey[0]= y + MathUtils.sin(radians) *8;
		//second point, bottom left point
		shapex[1]= x + MathUtils.cos(radians - 4*pi /5) *8;
		shapey[1]= y + MathUtils.sin(radians -  4*pi/5) *8;
		//third point, the point below center 
		shapex[2]= x+ MathUtils.cos(radians +pi) *5;
		shapey[2]= y + MathUtils.sin(radians +pi)*5;		
		//forth point, the bottom right point
		shapex[3]= x + MathUtils.cos(radians + 4*pi /5) *8;
		shapey[3]= y + MathUtils.sin(radians +  4*pi/5) *8;
		
	}
	
	public void setLeft (boolean b) {left =b;}
	public void setRight (boolean b) {right =b;}
	public void setUp (boolean b) {up =b;}
	
	public void update(float dt){
		//turning
		if (left){
			
			radians += rotationSpeed*dt;
		}
		else if(right){
			radians -= rotationSpeed*dt;
		}
		
		// accelerating
		if(up){
			dx += MathUtils.cos(radians) * acceleration *dt;
			dy += MathUtils.sin(radians) * acceleration *dt;
		}
		
		//decleration
		//triangle, z= sqrt(x^2+y^2) 
		//if player is still moving( either left or right), friction will apply
		//to slow player down
		float vec =(float) Math.sqrt(dx *dx + dy*dy);
		
		if (vec > 0){
			dx -= (dx/vec ) *decelaration *dt; 
			dy -= (dy/vec ) *decelaration *dt; 
	
		}
		if (vec > maxSpeed){
			dx = (dx / vec ) *maxSpeed;
			dy = (dy /vec) *maxSpeed;
			
		}
		
		//set position
		x+= dx;
		y+=dy;
		
		//set Shape
		setShape();
		
		//screen wrap
		wrap();
		
		
	}
	
	
}
