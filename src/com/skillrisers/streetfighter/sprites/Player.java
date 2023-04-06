package com.skillrisers.streetfighter.sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.skillrisers.streetfighter.utils.GameConstants;

public class Player extends CommonPlayer implements GameConstants {
	
	private BufferedImage idleImages[] = new BufferedImage[6];
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[6];
	
	public Player() throws Exception {
		x = 150;
		y = GROUND;
		w = 200;
		h = 300;
		speed = 0;
		playerImg = ImageIO.read(Player.class.getResource(PLAYER_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
	}
	
	private void loadIdleImages() {
		idleImages[0] = playerImg.getSubimage(9,36,52,84);
		idleImages[1] = playerImg.getSubimage(63,36,52,84);
		idleImages[2] = playerImg.getSubimage(116,36,52,84);
		idleImages[3] = playerImg.getSubimage(168,36,52,84);
		idleImages[4] = playerImg.getSubimage(222,36,52,84);
		idleImages[5] = playerImg.getSubimage(276,36,52,84);
	}

	private void loadWalkImages() {
		walkImages[0] = playerImg.getSubimage(9,36,52,84);
		walkImages[1] = playerImg.getSubimage(63,36,52,84);
		walkImages[2] = playerImg.getSubimage(116,36,52,84);
		walkImages[3] = playerImg.getSubimage(168,36,52,84);
		walkImages[4] = playerImg.getSubimage(222,36,52,84);
		walkImages[5] = playerImg.getSubimage(276,36,52,84);
	}

	private void loadJumpImages() {
		idleImages[0] = playerImg.getSubimage(9,36,52,84);
		idleImages[1] = playerImg.getSubimage(63,36,52,84);
		idleImages[2] = playerImg.getSubimage(116,36,52,84);
		idleImages[3] = playerImg.getSubimage(168,36,52,84);
		idleImages[4] = playerImg.getSubimage(222,36,52,84);
		idleImages[5] = playerImg.getSubimage(276,36,52,84);
	}
	
	public BufferedImage printIdle() {
		if(imageIndex >= 6) {
			imageIndex = 0;
		}
		BufferedImage img = idleImages[imageIndex];
		imageIndex++;
		return img;
	}

	public BufferedImage printWalk() {
		if(imageIndex >= 6) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = walkImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	public BufferedImage printJump() {
		if(imageIndex >= 6) {
			imageIndex = 0;
			currentMove = IDLE;
		}
		BufferedImage img = jumpImages[imageIndex];
		imageIndex++;
		return img;
	}
	
	// public void jump(){
	// 	force = -15;
	// 	y = y + force;
	// }
	// public void fall(){
	// 	if(y>=GROUND)
	// 	{
	// 		return;
	// 	}
	// 	force = force + GRAVITY;
	// 	y = y + force;
	// }

	@Override
	public BufferedImage defaultImage() {
		if(currentMove == WALK) {
			return printWalk();
		}
		else if(currentMove == KICK) {
			return printJump();
		}
		else {
			return printIdle();
		}
	}
}
	