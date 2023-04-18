package com.skillrisers.streetfighter.gaming;

import javax.swing.JFrame;

import com.skillrisers.streetfighter.utils.GameConstants;

public class GameScreen extends JFrame implements GameConstants {
	
	public GameScreen() throws Exception {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		GameBoard board = new GameBoard();
		add(board);
		setVisible(true);
	}
	

}
