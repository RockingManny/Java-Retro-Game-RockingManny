package com.skillrisers.streetfighter.gaming;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.skillrisers.streetfighter.utils.GameConstants;

public class Background implements GameConstants{
    protected int w;
    protected int h;
    protected int x;
    protected int y;
    protected BufferedImage bg_img;
    public int getW() {return w;}
    public void setW(int w) {this.w = w;}
    public int getH() {return h;}
    public void setH(int h) {this.h = h;}
    public int getX() {return x;}
    public void setX(int x) {this.x = x;}
    public int getY() {return y;}
    public void setY(int y) {this.y = y;}
    public int getSpan() {return (x+w);}
    public Background(BufferedImage bg_img, int x, int y, int w, int h) throws Exception 
    {
        this.w = w;
		this.h = h;
		this.x = x;
		this.y = y;
        this.bg_img=bg_img;
    }
    public void paintBackground(Graphics pen) {
        pen.drawImage(bg_img, x, y, w, h, null);
    }
    public void bg_move(int speed) {if(getX()+speed<=0&&getSpan()+speed>=SCREENWIDTH){x = x + speed;}}
}
