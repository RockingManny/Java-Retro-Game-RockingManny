package com.skillrisers.streetfighter.utils;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public interface GameConstants {
	String TITLE = ConfigReader.getValue("game.title");
	GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	int SCREENWIDTH = graphicsDevice.getDisplayMode().getWidth();
	int SCREENHEIGHT = graphicsDevice.getDisplayMode().getHeight();
	int GROUND = SCREENHEIGHT - 450;
	String BACKGROUND = ConfigReader.getValue("game.background.img");
	String OPPONENT_IMAGE = ConfigReader.getValue("oppPlayer.img");
	String PLAYER_IMAGE = ConfigReader.getValue("player.img");
	int SPEED = 10;
	int IDLE = 1;
	int WALK = 2;
	int KICK = 3;
	int PUNCH = 4;
	int GRAVITY = 9;

}
