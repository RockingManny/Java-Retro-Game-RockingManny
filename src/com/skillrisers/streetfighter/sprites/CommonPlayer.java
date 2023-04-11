package com.skillrisers.streetfighter.sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.skillrisers.streetfighter.utils.GameConstants;

public abstract class CommonPlayer implements GameConstants {
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int speed;
	protected BufferedImage playerImg;
	protected int imageIndex;
	protected int currentMove;
	protected int force;
	public abstract BufferedImage printIdle();
	public abstract BufferedImage printWalk();
	public abstract BufferedImage printJump();
	public abstract BufferedImage printCrouch();
	public abstract BufferedImage printLAttack();
	public abstract BufferedImage printHit();
	protected boolean isCollide;
	protected boolean isAttacking;
	
	
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
	
	// public int getForce() {return force;}
	//	public void setForce(int force) {this.force = force;}

	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}
	
	public BufferedImage getPlayerImg() {return playerImg;}
	public void setPlayerImg(BufferedImage playerImg) {this.playerImg = playerImg;}
	public void flipPlayerImg() {this.playerImg = flip(defaultImage());}
	
	public void move() {if(!isCollide){x = x + speed;}}
	public void crouch() {}
	public void jump() {force = -10; y = y + force;}
	public void fall() {
		if(y + force > GROUND) {
			y = GROUND;
			return;
		}
		force = force + GRAVITY;
		y = y + force;
	}
	
	public void paintPlayer(Graphics pen) {
		pen.drawImage(defaultImage(), x, y, w, h, null);
	}
	public void paintFlipPlayer(Graphics pen) {
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
