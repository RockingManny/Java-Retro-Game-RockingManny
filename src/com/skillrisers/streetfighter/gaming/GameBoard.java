package com.skillrisers.streetfighter.gaming;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.skillrisers.streetfighter.sprites.CommonPlayer.Health;
import com.skillrisers.streetfighter.sprites.OpponentPlayer;
import com.skillrisers.streetfighter.sprites.Player;
import com.skillrisers.streetfighter.utils.GameConstants;

public class GameBoard extends JPanel implements GameConstants {
	BufferedImage bgImage;
	BufferedImage fgImage;
	private Player player;
	private OpponentPlayer oppPlayer;
	private Timer timer;
	private Health playerHealth;
	private Health oppPlayerHealth;
	public GameBoard() throws Exception {
		player = new Player();
		oppPlayer = new OpponentPlayer();
		setFocusable(true);
		loadBackground();
		bindEvents();
		loadHealth();
		gameLoop();
	}

	private void gameLoop(){
		timer = new Timer(130, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				repaint();
				player.fall();
				oppPlayer.fall();
				collision();
			}

		});
		timer.start();
	}

	public void loadHealth(){
		playerHealth = player.new Health(30,Color.GREEN);
		oppPlayerHealth = oppPlayer.new Health(SCREENWIDTH-550, Color.GREEN);
	}

	public void printHealth(Graphics pen){
		oppPlayerHealth.printHealth(pen);
		playerHealth.printHealth(pen);
	}

	public void flipAll(boolean flip){
		if(flip==true)
		{
			player.setFlip(true);
			oppPlayer.setFlip(false);
		}
		else
		{
			player.setFlip(false);
			oppPlayer.setFlip(true);
		}
	}


	private boolean isCollide(){
		int xDistance = Math.abs(player.getX() - oppPlayer.getX());
		int yDistance = Math.abs(player.getY() - oppPlayer.getY());
		int maxH = Math.max(player.getH(), oppPlayer.getH());
		int maxW = Math.max(player.getW(), oppPlayer.getW());
		return xDistance <= maxW && yDistance <= maxH;

	}

	private void collision(){
		if(isCollide()){
			if(player.isAttacking()&&oppPlayer.isAttacking()){
			
			}
			if(player.isAttacking()){
				oppPlayer.setAttacking(false);
				oppPlayer.setCurrentMove(HIT);
			}
			else if(oppPlayer.isAttacking()){
				player.setAttacking(false);
				player.setCurrentMove(HIT);
			}
			System.out.println("Collision!!");
			player.setCollide(true);
		}
		else{
			player.setSpeed(SPEED);
			player.setCollide(false);
		}
	}


	@Override
	public void paintComponent(Graphics pen) {
		//System.out.println("Paint Component...");
		paintBackground(pen);
		oppPlayer.paintPlayer(pen);
		player.paintPlayer(pen);
		printHealth(pen);
		if(player.getX()>oppPlayer.getX())
			flipAll(true);
		else
			flipAll(false);

	}
	private void paintBackground(Graphics pen) {
		
		pen.drawImage(bgImage, 0,0,SCREENWIDTH, SCREENHEIGHT, null);
		pen.drawImage(fgImage, -300,GROUND-170,SCREENWIDTH+600, 300, null);
	}
	
	void bindEvents() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// System.out.println("Key Typed : " + e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("Key Released : " + e.getKeyCode());
				player.setSpeed(0);
				oppPlayer.setSpeed(0);
				player.setCurrentMove(IDLE);
				oppPlayer.setCurrentMove(IDLE);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key Pressed : " + e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setCurrentMove(WALK);
					if((oppPlayer.getSpan() == player.getX()+200)&&!(oppPlayer.isFlying())&&!(player.isFlying()))
					{
						player.setCollide(true);
						player.setSpeed(0);
						return;
					}
					player.setCollide(false);
					player.setSpeed(-SPEED);
					player.move();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.setCurrentMove(WALK);
					if((player.getSpan() == oppPlayer.getX()+200)&&!(oppPlayer.isFlying())&&!(player.isFlying()))
					{
						player.setCollide(true);
						player.setSpeed(0);
						return;
					}
					player.setCollide(false);
					player.setSpeed(SPEED);
					player.move();
					// repaint();
				}
				
				if(e.getKeyCode() == KeyEvent.VK_A) {
					oppPlayer.setCurrentMove(WALK);
					if((player.getSpan() == oppPlayer.getX()+200)&&!(oppPlayer.isFlying())&&!(player.isFlying()))
					{
						oppPlayer.setCollide(true);
						oppPlayer.setSpeed(0);
						return;
					}
					oppPlayer.setCollide(false);
					oppPlayer.setSpeed(-SPEED);
					oppPlayer.move();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_D) {
					oppPlayer.setCurrentMove(WALK);
					if((oppPlayer.getSpan() == player.getX()+200)&&!(oppPlayer.isFlying())&&!(player.isFlying()))
					{
						oppPlayer.setCollide(true);
						oppPlayer.setSpeed(0);
						return;
					}
					oppPlayer.setCollide(false);
					oppPlayer.setSpeed(SPEED);
					oppPlayer.move();
					// repaint();
				}
				
				if(e.getKeyCode() == KeyEvent.VK_UP) {
					player.setCurrentMove(JUMP);
					player.setFlying(true);
					player.jump();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					player.setCurrentMove(CROUCH);
					// repaint();
				}

				if(e.getKeyCode() == KeyEvent.VK_W) {
					oppPlayer.setCurrentMove(JUMP);
					oppPlayer.setFlying(true);
					oppPlayer.jump();
					// repaint();
				}
				else if(e.getKeyCode() == KeyEvent.VK_S) {
					oppPlayer.setCurrentMove(CROUCH);
					// repaint();
				}

				if(e.getKeyCode() == KeyEvent.VK_P) {
					player.setCurrentMove(LATTACK);
					player.setAttacking(true);
				}
			}
		});
	}
	
	private void loadBackground() {
		try {
			bgImage = ImageIO.read(GameBoard.class.getResource(BACKGROUND)).getSubimage(42, 9, 416, 200);
			fgImage = ImageIO.read(GameBoard.class.getResource(BACKGROUND)).getSubimage(0, 203, 512, 60);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Something went wrong...");
			System.out.println("Failed to load background image...");
			System.exit(0);
		}
	}
}
