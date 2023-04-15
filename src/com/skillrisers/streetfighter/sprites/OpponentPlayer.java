package com.skillrisers.streetfighter.sprites;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class OpponentPlayer extends CommonPlayer {
	
	private BufferedImage idleImages[] = new BufferedImage[6];
	private BufferedImage walkImages[] = new BufferedImage[6];
	private BufferedImage jumpImages[] = new BufferedImage[6];
	private BufferedImage crouchImages[] = new BufferedImage[6];

	public OpponentPlayer() throws Exception {
		x = SCREENWIDTH - 500;
		y = GROUND;
		w = 300;
		h = 400;
		force=0;
		speed = 0;
		flip=true;
		playerImg = ImageIO.read(Player.class.getResource(OPPONENT_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
	}
	
	private void loadIdleImages() {
		idleImages[0] = playerImg.getSubimage(6, 0, 69, 80);
		idleImages[1] = playerImg.getSubimage(77, 0, 69, 80);
		idleImages[2] = playerImg.getSubimage(146, 0, 69, 80);
		idleImages[3] = playerImg.getSubimage(220, 0, 69, 80);
		idleImages[4] = playerImg.getSubimage(295, 0, 69, 80);
		idleImages[5] = playerImg.getSubimage(362, 0, 69, 80);
	}

	private void loadWalkImages() {
		walkImages[0] = playerImg.getSubimage(6, 0, 69, 80);
		walkImages[1] = playerImg.getSubimage(77, 0, 69, 80);
		walkImages[2] = playerImg.getSubimage(146, 0, 69, 80);
		walkImages[3] = playerImg.getSubimage(220, 0, 69, 80);
		walkImages[4] = playerImg.getSubimage(295, 0, 69, 80);
		walkImages[5] = playerImg.getSubimage(362, 0, 69, 80);
	}

	private void loadJumpImages() {
		idleImages[0] = playerImg.getSubimage(6, 0, 69, 80);
		idleImages[1] = playerImg.getSubimage(77, 0, 69, 80);
		idleImages[2] = playerImg.getSubimage(146, 0, 69, 80);
		idleImages[3] = playerImg.getSubimage(220, 0, 69, 80);
		idleImages[4] = playerImg.getSubimage(295, 0, 69, 80);
		idleImages[5] = playerImg.getSubimage(362, 0, 69, 80);
	}

	private void loadCrouchImages() {
		idleImages[0] = playerImg.getSubimage(6, 0, 69, 80);
		idleImages[1] = playerImg.getSubimage(77, 0, 69, 80);
		idleImages[2] = playerImg.getSubimage(146, 0, 69, 80);
		idleImages[3] = playerImg.getSubimage(220, 0, 69, 80);
		idleImages[4] = playerImg.getSubimage(295, 0, 69, 80);
		idleImages[5] = playerImg.getSubimage(362, 0, 69, 80);
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

	public BufferedImage printCrouch() {
		if(imageIndex >= 2) {
			imageIndex = 0;
			currentMove = CROUCH;
		}
		BufferedImage img = crouchImages[imageIndex];
		imageIndex++;
		return img;
	}

	@Override
	public BufferedImage printLAttack() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'printLAttack'");
	}

	@Override
	public BufferedImage printHit() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'printHit'");
	}
	
}
