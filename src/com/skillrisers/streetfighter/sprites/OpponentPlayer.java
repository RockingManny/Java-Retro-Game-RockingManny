package com.skillrisers.streetfighter.sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class OpponentPlayer extends CommonPlayer {
	
	private BufferedImage idleImages[] = new BufferedImage[6];
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[6];

	public OpponentPlayer() throws Exception {
		x = SCREENWIDTH - 500;
		y = GROUND;
		w = 200;
		h = 300;
		speed = 0;
		playerImg = ImageIO.read(Player.class.getResource(OPPONENT_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
	}
	
	
	private void loadIdleImages() {
		idleImages[0] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[1] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[2] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[3] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[4] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[5] = playerImg.getSubimage(2748, 37, 105, 232);
	}

	private void loadWalkImages() {
		walkImages[0] = playerImg.getSubimage(2748, 37, 105, 232);
		walkImages[1] = playerImg.getSubimage(2748, 37, 105, 232);
		walkImages[2] = playerImg.getSubimage(2748, 37, 105, 232);
		walkImages[3] = playerImg.getSubimage(2748, 37, 105, 232);
		walkImages[4] = playerImg.getSubimage(2748, 37, 105, 232);
		walkImages[5] = playerImg.getSubimage(2748, 37, 105, 232);
	}

	private void loadJumpImages() {
		idleImages[0] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[1] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[2] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[3] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[4] = playerImg.getSubimage(2748, 37, 105, 232);
		idleImages[5] = playerImg.getSubimage(2748, 37, 105, 232);
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
	
}
