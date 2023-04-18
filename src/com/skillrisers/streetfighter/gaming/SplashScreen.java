package com.skillrisers.streetfighter.gaming;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.skillrisers.streetfighter.utils.GameConstants;

public class SplashScreen extends JFrame{
    private JLabel label = new JLabel();
    public SplashScreen(){
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(SCREENWIDTH, SCREENHEIGHT);
		setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
		// setTitle(TITLE);
        Icon icon = new ImageIcon(SplashScreen.class.getResource("splash.png"));
        label.setIcon(icon);
        this.add(label);
        setVisible(true);
        try {
            Thread.sleep(10000);
            setVisible(false);
            dispose();
			new GameScreen();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        SplashScreen screen = new SplashScreen();
    }
}
