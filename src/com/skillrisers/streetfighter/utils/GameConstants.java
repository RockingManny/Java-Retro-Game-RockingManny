package com.skillrisers.streetfighter.utils;

public interface GameConstants {
	String TITLE = ConfigReader.getValue("game.title");
	int SCREENWIDTH = Integer.parseInt(ConfigReader.getValue("game.width"));
	int SCREENHEIGHT = Integer.parseInt(ConfigReader.getValue("game.height"));
	int GROUND = Integer.parseInt(ConfigReader.getValue("game.height")) - 450;
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
