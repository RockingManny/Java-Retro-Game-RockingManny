package com.skillrisers.streetfighter.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.skillrisers.streetfighter.utils.GameConstants;
import com.skillrisers.streetfighter.utils.SpriteImageUtils;

public abstract class CommonPlayer implements GameConstants {

	public class Health {
		protected int x_hb_bg;
		protected int y_hb_bg = 20;
		protected int w_hb_bg;
		protected int h_hb_bg = 50;
		protected int x_hb;
		protected int y_hb;
		protected int w_hb;
		protected int h_hb;
		public int getX_hb() {return x_hb;}
		public int getY_hb() {return y_hb;}
		public int getW_hb() {return w_hb;}
		public int getH_hb() {return h_hb;}
		public void setX_hb(int x_hb) {this.x_hb = x_hb;}
		public void setY_hb(int y_hb) {this.y_hb = y_hb;}
		public void setW_hb(int w_hb) {this.w_hb = w_hb;}
		public void setH_hb(int h_hb) {this.h_hb = h_hb;}
		
		Color h_bg_color = Color.RED;
		Color h_color = Color.RED;
		public Health(int x, Color color) {
			x_hb_bg = x;
			w_hb_bg = MAX_HEALTH;
			x_hb = x_hb_bg;
			y_hb = y_hb_bg;
			w_hb = w_hb_bg;
			h_hb = h_hb_bg;
			this.h_color = color;
		}

		public void setHealth() {
			if(health>0)
			{
				health = health - (int)(MAX_HEALTH * 0.01);
			}
			w_hb = health;
		}
		
		public void printHealth(Graphics pen) {
			pen.setColor(h_bg_color);
			pen.fillRect(x_hb_bg, y_hb_bg, w_hb_bg, h_hb_bg);
			pen.setColor(h_color);
			pen.fillRect(x_hb, y_hb, w_hb, h_hb);
		}
	}

	public class PowerEffect {
		protected int x_pw;
		protected int y_pw;
		protected int w_pw;
		protected int h_pw;

		protected ArrayList<BufferedImage> powerImg = new ArrayList<BufferedImage>();

		public PowerEffect()
		{
			x_pw = (!isFlip())? (getSpan()-30):(getX()+30);
			y_pw = (y+(getBase()-y)/2)-95;
			w_pw = 39;
			h_pw = 97;
			speed=SPEED;
			loadPowerImg();
		}

		public int getPos() {
			return (x_pw+w_pw);
		}
		private void loadPowerImg() {
			powerImg.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(1027,3433,39,97)));
		}

		public BufferedImage printPower() {
			isAttacking = false;
			if(imageIndex >= powerImg.size()) {
				imageIndex = 0;
			}
			BufferedImage img = powerImg.get(imageIndex);
			imageIndex++;
			return img;
		}

		public void printPower(Graphics pen) {
			pen.drawImage(printPower(), x_pw, y_pw, w_pw, h_pw, null);
			move_pw();
		}
		private void move_pw() {if(!isFlip()) x_pw = x_pw + (speed+90);
								else x_pw = x_pw - (speed+90);}
	}
	protected ArrayList<BufferedImage> idleImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> walkImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> jumpImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> crouchImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> LAttackImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> hitImages = new ArrayList<BufferedImage>();
	protected ArrayList<BufferedImage> powerImages = new ArrayList<BufferedImage>();

	protected int health = MAX_HEALTH;

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
	protected boolean isCrouching;
	protected boolean isFlying;
	protected boolean isFlyingNearGround;
	protected boolean isPowerAttacking;
	protected boolean isPowerSuccess;


	public boolean isPowerAttacking() {return isPowerAttacking;}
	public void setPowerAttacking(boolean isPowerAttacking) {this.isPowerAttacking = isPowerAttacking;}
	public boolean isPowerSuccess() {return isPowerSuccess;}
	public void setPowerSuccess(boolean isPowerSuccess) {this.isPowerSuccess = isPowerSuccess;}
	public int getHealth() {return health;}
	public void setHealth(int health) {this.health = health;}
	public boolean isFlyingNearGround() {return isFlyingNearGround;}
	public void setFlyingNearGround(boolean isFlyingNearGround) {this.isFlyingNearGround = isFlyingNearGround;}
	public boolean isFlying() {return isFlying;}
	public void setFlying(boolean isFlying) {this.isFlying = isFlying;}
	public boolean isCrouching() {return isCrouching;}
	public void setCrouching(boolean isCrouching) {this.isCrouching = isCrouching;}
	public boolean isFlip() {return flip;}
	public void setFlip(boolean flip) {this.flip = flip;}
	public boolean isAttacking() {return isAttacking;}
	public void setAttacking(boolean isAttacking) {this.isAttacking = isAttacking;}
	public boolean isCollide() {return isCollide;}
	public void setCollide(boolean isCollide) {this.isCollide = isCollide;}
	public int getCurrentMove() {return currentMove;}
	public void setCurrentMove(int currentMove) {this.currentMove = currentMove;}
	
	public int getBase() {return (y+w);}
	public int getSpan() {return (x+w);}
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
	
	protected ArrayList<PowerEffect> powers= new ArrayList<PowerEffect>();

	public ArrayList<PowerEffect> getPowers() {
		return powers;
	}
	public void dispose_power(int pos) {
		if(powers.size()>0)
		{
			if(!isFlip())
			{
				if((powers.get(0).getPos())>=pos||powers.get(0).getPos()>=SCREENWIDTH)
				{
					powers.remove(0);
					setPowerSuccess(true);
				}
			}
			else
			{
				if((powers.get(0).getPos())<=pos||powers.get(0).getPos()<=0)
				{
					powers.remove(0);
					setPowerSuccess(true);
				}
			}
		}
	}
	public void power() {
		powers.add(new PowerEffect());
	}
	public void move() {if(!isCollide){x = x + speed;}}
	public void jump() {
		force = -40; 
		if(y + force < 0)
		{
			y = 0;
			return;
		}
		y = y + force;
	}
	public void fall() {
		if(getBase()<(GROUND-50)) {
			setFlying(true);
			setFlyingNearGround(false);
		}
		else if(getBase()>=(GROUND-50)&&getBase()<GROUND) {
			setFlying(false);
			setFlyingNearGround(true);
		}
		else {
			setFlying(false);
			setFlyingNearGround(false);
		}
		force = force + GRAVITY;
		if(getBase() + force > GROUND) {
			y = GROUND - w;
			return;
		}
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
		else if(currentMove == LATTACK)
		{
			return printLAttack();
		}
		else if(currentMove == HIT)
		{
			return printHit();
		}
		else if(currentMove == POWER)
		{
			return printPower();
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
		setAttacking(false);
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
		}
		isAttacking=true;
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

	public BufferedImage printPower() {

		if(imageIndex >= powerImages.size()) {
			imageIndex = 0;
			currentMove = HIT;
		}
		BufferedImage img = powerImages.get(imageIndex);
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
