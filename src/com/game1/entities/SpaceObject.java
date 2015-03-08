package com.game1.entities;

import com.game1.main.Game;

public class SpaceObject {

	protected float x;
	protected float y;
	
	protected float dx;
	protected float dy;

	protected float radians;
	protected float speed;
	protected float rotationSpeed;
	
	protected int width;
	protected int height;

	
	
	protected float[] shapex;
	protected float[] shapey;
	
	public float getx() {return x ;}
	public float gety() {return y ;}
	
	protected void wrap(){
		if (x< 0) x= Game.WIDTH;
		if (x> Game.WIDTH) x= 0;
		if (y< 0) y= Game.HEIGHT;
		if (y> Game.HEIGHT) y= 0;
	
		
		
	}

}

