package com.game1.entities;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.game1.main.Game;

public class Player extends SpaceObject{

	private final int MAX_BULLETS =4;
	private ArrayList<Bullet> bullets;
	
	private float[] flamex;
	private float[] flamey;
	
	private boolean left;
	private boolean right;
	private boolean up;
	
	private float maxSpeed;
	private float acceleration;
	private float decelaration;
	private float pi= 3.141592654f;
	private float acceleratingTimer;
	
	public Player( ArrayList<Bullet> bullets){
		
		this.bullets = bullets;
		
		x = Game.WIDTH /2;
		y = Game.HEIGHT /2;
		
		maxSpeed = 300;
		acceleration = 200;
		decelaration = 10;
		
		shapex = new float[4];
		shapey = new float [4];
		flamex = new float[3];
		flamey = new float[3];

		radians = pi/2;
		rotationSpeed = 3;
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
	private void setFlame(){
		
		flamex[0] = x + MathUtils.cos(radians - 5*pi/6)*5;
		flamey[0] = y + MathUtils.sin(radians - 5*pi/6)*5;
		
		flamex[1] = x + MathUtils.cos(radians - pi) * 
				(6+ acceleratingTimer *50);
		flamey[1] = y + MathUtils.sin(radians - pi)* 
				(6+ acceleratingTimer *50);
		
		flamex[2] = x+ MathUtils.cos(radians + 5*pi/6)*5;
		flamey[2] = y+ MathUtils.sin(radians + 5*pi/6)*5;
		
		
	}
	
	public void setLeft (boolean b) {left =b;}
	public void setRight (boolean b) {right =b;}
	public void setUp (boolean b) {up =b;}
	
	
	public void shoot(){
		if(bullets.size() >= MAX_BULLETS) return;
		bullets.add(new Bullet(x,y,radians));
		
	}
	
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
			acceleratingTimer += dt;
			if (acceleratingTimer > 0.1f){
				acceleratingTimer = 0;
			}
		}
			else {
				
				acceleratingTimer = 0;
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
		x+= dx *dt;
		y+=dy *dt ;
		
		//set Shape
		setShape();
		
		//set flame
		if(up) {
			setFlame();
		}
		
		//screen wrap
		wrap();
		
		
	}
	
	
	public void draw(ShapeRenderer sr){
		//white
		sr.setColor(1,1,1,1);
		
		sr.begin(ShapeType.Line);
		
		//draw player
		for(int i=0, j= shapex.length -1;
			i< shapex.length;
			j= i++){
			
			sr.line(shapex[i], shapey[i],shapex[j],shapey[j]);
		}
		
		
		//draw flames
		if(up){
			for(int i=0, j= flamex.length -1;
					i< flamex.length;
					j= i++){
					
					sr.line(flamex[i], flamey[i],flamex[j],flamey[j]);
				}
		}
		
		
		
		sr.end();
	}
	
}
