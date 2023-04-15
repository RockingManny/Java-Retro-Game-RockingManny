package com.skillrisers.streetfighter.sprites;

import javax.imageio.ImageIO;
import com.skillrisers.streetfighter.utils.SpriteImageUtils;
public class OpponentPlayer extends CommonPlayer {

	public OpponentPlayer() throws Exception {
		w = 320;
		h = 400;
		x = SCREENWIDTH - w - 200;
		y = GROUND - h;
		force=0;
		speed = 0;
		flip=false;
		playerImg = ImageIO.read(Player.class.getResource(OPPONENT_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
		loadLAttackImages();
		loadHitImages();
		loadPowerImages();
	}

	private void loadHitImages(){
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(537,1051,78,98)));
		}

	private void loadIdleImages() {
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(4,570,85,98)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(93,570,85,98)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(179,571,85,98)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(267,573,85,98)));
	}

	private void loadWalkImages() {
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(1,112,74,96)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(87,111,74,96)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(169,114,74,96)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(245,113,74,96)));
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
	private void loadPowerImages() {
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}
}
	