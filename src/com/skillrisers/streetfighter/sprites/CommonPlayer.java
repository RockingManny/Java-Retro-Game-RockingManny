package com.skillrisers.streetfighter.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.skillrisers.streetfighter.utils.GameConstants;

public abstract class CommonPlayer implements GameConstants {

	public class Health {
		protected int x_hb;
		protected int y_hb;
		protected int w_hb;
		protected int h_hb;
		public int getX_hb() {return x_hb;}
		public int getY_hb() {return y_hb;}
		public int getW_hb() {return w_hb;}
		public int getH_hb() {return h_hb;}
		public Color getColor() {return color;}
		public void setX_hb(int x_hb) {this.x_hb = x_hb;}
		public void setY_hb(int y_hb) {this.y_hb = y_hb;}
		public void setW_hb(int w_hb) {this.w_hb = w_hb;}
		public void setH_hb(int h_hb) {this.h_hb = h_hb;}
		public void setColor(Color color) {this.color = color;}
		
		Color color;
		public Health(int x, Color color) {
			x_hb = x;
			y_hb = 20;
			w_hb = 500;
			h_hb = 50;
			this.color = color;
		}
		
		public void printHealth(Graphics pen) {
			pen.setColor(getColor());
			pen.fillRect(getX_hb(), getY_hb(), getW_hb(), getH_hb());
		}
	}

	protected ArrayList<BufferedImage> idleImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> walkImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> jumpImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> crouchImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> LAttackImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> hitImages = new ArrayList<BufferedImage>();

	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int speed;
	protected int imageIndex;
	protected int currentMove;
	protected int force;
	protected BufferedImage playerImg;
	protected boolean flip;
	protected boolean isCollide;
	protected boolean isAttacking;
	
	
	public boolean isFlip() {return flip;}
	public void setFlip(boolean flip) {this.flip = flip;}
	public boolean isAttacking() {return isAttacking;}
	public void setAttacking(boolean isAttacking) {this.isAttacking = isAttacking;}
	public boolean isCollide() {return isCollide;}
	public void setCollide(boolean isCollide) {this.isCollide = isCollide;}
	public int getCurrentMove() {return currentMove;}
	public void setCurrentMove(int currentMove) {this.currentMove = currentMove;}
	
	public int getX() {return x;}
	public void setX(int x) {this.x = x;}
	
	public int getY() {return y;}
	public void setY(int y) {this.y = y;}
	
	public int getW() {return w;}
	public void setW(int w) {this.w = w;}
	
	public int getH() {return h;}
	public void setH(int h) {this.h = h;}
	
	public int getForce() {return force;}
		public void setForce(int force) {this.force = force;}

	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	
	public BufferedImage getPlayerImg() {return playerImg;}
	public void setPlayerImg(BufferedImage playerImg) {this.playerImg = playerImg;}
	public void flipPlayerImg() {this.playerImg = flip(defaultImage());}
	
	public void move() {if(!isCollide){x = x + speed;}}
	public void jump() {force = -40; y = y + force;}
	public void fall() {
		if(y + force > GROUND) {
			y = GROUND;
			return;
		}
		force = force + GRAVITY;
		y = y + force;
	}
	
	public void paintPlayer(Graphics pen) {
		if(flip==false)
			pen.drawImage(defaultImage(), x, y, w, h, null);
		else
			pen.drawImage(flip(defaultImage()), x, y, w, h, null);
	}

	public BufferedImage defaultImage() {
		if(currentMove == WALK) {
			return printWalk();
		}
		else if(currentMove == JUMP) {
			return printJump();
		}
		else if(currentMove == CROUCH) {
			return printCrouch();
		}
		else {
			return printIdle();
		}
		
	}

		
	public BufferedImage printIdle() {
		isAttacking = false;
		if(imageIndex >= idleImages.size()) {
			imageIndex = 0;
		}
		BufferedImage img = idleImages.get(imageIndex);
		imageIndex++;
		return img;
	}

	public BufferedImage printWalk() {
		if(imageIndex >= walkImages.size()) {
			imageIndex = 0;
			currentMove = WALK;
			isAttacking=false;
		}
		isAttacking=true;
		BufferedImage img = walkImages.get(imageIndex);
		imageIndex++;
		return img;
	}

	public BufferedImage printJump() {
		if(imageIndex >= jumpImages.size()) {
			imageIndex = 0;
			currentMove = JUMP;
		}
		BufferedImage img = jumpImages.get(imageIndex);
		imageIndex++;
		return img;
	}

	public BufferedImage printCrouch() {
		if(imageIndex >= crouchImages.size()) {
			imageIndex = 0;
			currentMove = CROUCH;
		}
		BufferedImage img = crouchImages.get(imageIndex);
		imageIndex++;
		return img;
	}

	public BufferedImage printLAttack() {
		if(imageIndex >= LAttackImages.size()) {
			imageIndex = 0;
			currentMove = ATTACK;
		}
		BufferedImage img = LAttackImages.get(imageIndex);
		imageIndex++;
		return img;
	}

	public BufferedImage printHit() {
		if(imageIndex >= hitImages.size()) {
			imageIndex = 0;
			currentMove = HIT;
		}
		BufferedImage img = hitImages.get(imageIndex);
		imageIndex++;
		return img;
	}


	public BufferedImage flip(BufferedImage sprite) {
        BufferedImage img = new BufferedImage(sprite.getWidth(),sprite.getHeight(),BufferedImage.TYPE_INT_ARGB);
		for(int xx = sprite.getWidth()-1;xx>0;xx--) {
			for(int yy = 0;yy < sprite.getHeight();yy++) {
				img.setRGB(sprite.getWidth()-xx, yy, sprite.getRGB(xx, yy));
			}
		}
		return img;
	}

}
