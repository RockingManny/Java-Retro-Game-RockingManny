package com.skillrisers.streetfighter.sprites;

import javax.imageio.ImageIO;
import com.skillrisers.streetfighter.utils.SpriteImageUtils;
public class Player extends CommonPlayer {
	
	public Player() throws Exception {
		x = 200;
		y = GROUND;
		w = 320;
		h = 400;
		force=0;
		speed = 0;
		flip=false;
		playerImg = ImageIO.read(Player.class.getResource(PLAYER_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
		loadLAttackImages();
		loadHitImages();
	}
	
	private void loadHitImages(){
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(17,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(120,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(224,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(327,53,95,98)));
	}

	private void loadIdleImages() {
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}

	private void loadWalkImages() {
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(17,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(104,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(187,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(271,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(354,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(437,207,79,103)));
	}

	private void loadJumpImages() {
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}

	private void loadCrouchImages() {
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}
	private void loadLAttackImages() {
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}

}
	