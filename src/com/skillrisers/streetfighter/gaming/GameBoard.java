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
import com.skillrisers.streetfighter.sprites.CommonPlayer.PowerEffect;
import com.skillrisers.streetfighter.sprites.OpponentPlayer;
import com.skillrisers.streetfighter.sprites.Player;
import com.skillrisers.streetfighter.utils.GameConstants;
import com.skillrisers.streetfighter.utils.SpriteImageUtils;

public class GameBoard extends JPanel implements GameConstants {
	private Background background;
	private Background foreground;
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
				powerCollision();
			}

		});
		timer.start();
	}

	private void printPower(Graphics pen) {
		for(PowerEffect power : player.getPowers()) {
			power.printPower(pen);
		}
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

	private void powerCollision() {
		player.dispose_power(oppPlayer.getSpan());
		oppPlayer.dispose_power(player.getSpan());
		if(player.isPowerSuccess()){
			oppPlayer.setCurrentMove(HIT);
			oppPlayerHealth.setHealth();
			player.setPowerSuccess(false);
		}
		else if(oppPlayer.isPowerSuccess()){
			player.setCurrentMove(HIT);
			playerHealth.setHealth();
			oppPlayer.setPowerSuccess(false);
		}
	}
	private void collision(){
		if(isCollide()){
			if(player.isAttacking()){
				oppPlayer.setAttacking(false);
				oppPlayer.setCurrentMove(HIT);
				oppPlayerHealth.setHealth();
			}
			else if(oppPlayer.isAttacking()){
				player.setAttacking(false);
				player.setCurrentMove(HIT);
				playerHealth.setHealth();
			}
			else if(!player.isAttacking()&&!player.isPowerSuccess()){
				oppPlayer.setCurrentMove(IDLE);
			}
			else if(!oppPlayer.isAttacking()&&!oppPlayer.isPowerSuccess()){
				player.setCurrentMove(IDLE);
			}
			player.setCollide(true);
			player.setCollide(true);
		}
		else{
			player.setSpeed(SPEED);
			player.setCollide(false);
			oppPlayer.setSpeed(SPEED);
			oppPlayer.setCollide(false);
		}
	}

	@Override
	public void paintComponent(Graphics pen) {
		//System.out.println("Paint Component...");
		background.paintBackground(pen);
		foreground.paintBackground(pen);
		oppPlayer.paintPlayer(pen);
		player.paintPlayer(pen);
		printHealth(pen);
		printPower(pen);
		if(player.getX()>oppPlayer.getX())
			flipAll(true);
		else
			flipAll(false);

	}
	
	void bindEvents() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// System.out.println("Key Typed : " + e.getKeyCode());
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// System.out.println("Key Released : " + e.getKeyCode());
				player.setSpeed(0);
				oppPlayer.setSpeed(0);
				player.setCurrentMove(IDLE);
				oppPlayer.setCurrentMove(IDLE);
				player.setPowerAttacking(false);
				oppPlayer.setPowerAttacking(false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// System.out.println("Key Pressed : " + e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.setCurrentMove(WALK);
					if((oppPlayer.getSpan() == player.getX()+200)&&!(oppPlayer.isFlying())&&!(player.isFlying()))
					{
						player.setCollide(true);
						player.setSpeed(0);
						return;
					}
					player.setCollide(false);
					player.setSpeed(-SPEED/4);
					player.move();

					
					oppPlayer.setCollide(false);
					oppPlayer.setSpeed(SPEED/4);
					oppPlayer.move();

					background.bg_move(SPEED/4);
					foreground.bg_move(SPEED/4);

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
					player.setSpeed(SPEED/4);
					player.move();

					oppPlayer.setCollide(false);
					oppPlayer.setSpeed(-SPEED/4);
					oppPlayer.move();

					background.bg_move(-SPEED/4);
					foreground.bg_move(-SPEED/4);
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

					player.setCollide(false);
					player.setSpeed(SPEED/4);
					player.move();
					
					background.bg_move(SPEED/4);
					foreground.bg_move(SPEED/4);

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
					
					player.setCollide(false);
					player.setSpeed(-SPEED/4);
					player.move();

					background.bg_move(-SPEED/4);
					foreground.bg_move(-SPEED/4);
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

				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					player.setCurrentMove(POWER);
					player.power();
					
				}
				
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					oppPlayer.setCurrentMove(LATTACK);
					oppPlayer.setAttacking(true);
				}
			}
		});
	}
	
	private void loadBackground() {
		try {
			BufferedImage bgImage = SpriteImageUtils.removeBackground(ImageIO.read(GameBoard.class.getResource(BACKGROUND)).getSubimage(42, 9, 416, 200));
			BufferedImage fgImage = SpriteImageUtils.removeBackground(ImageIO.read(GameBoard.class.getResource(BACKGROUND)).getSubimage(0, 203, 512, 60));
			background = new Background(bgImage, -500,0,SCREENWIDTH+1000, SCREENHEIGHT);
			foreground = new Background(fgImage, -800,GROUND-170,SCREENWIDTH+1600, 300);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Something went wrong...");
			System.out.println("Failed to load background image...");
			System.exit(0);
		}
	}
}
