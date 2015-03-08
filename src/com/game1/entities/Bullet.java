package com.game1.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;

public class Bullet extends SpaceObject{

	
	private float lifetime;
	private float lifeTimer;
	
	private boolean remove;
	
	public Bullet(float x, float y, float radians){
		
		this.x =x;
		this.y= y;
		this.radians = radians;
		
		float speed = 350;
		dx = MathUtils.cos(radians) * speed;
		dy = MathUtils.sin(radians) * speed;
		
		width = height =2;
		
		lifetime =1;
		lifeTimer =0;
		
		
		
		
		
	}
	
	public boolean shouldRemove () { return remove;}

	public void update (float dt){
		
		x+= dx*dt;
		y+= dy*dt;
		
		wrap();
		
		lifeTimer += dt;
		if( lifeTimer > lifetime){
			remove =true;
			
			
		}
		
	}
	
	public void draw (ShapeRenderer sr){
		sr.setColor(1,1,1,1);
		
		sr.begin(ShapeType.Line);
		
		sr.circle(x - width/2, y- height/2, width /2);
		
		sr.end();
		
		
	}
}
