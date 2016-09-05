package com.mingjalee.solarsystem;

import com.mingjalee.util.Constant;
import com.mingjalee.util.GameUtil;
import com.mingjalee.util.MyFrame;

import java.awt.*;


/**
 * 太阳系主窗口
 * @author jerry
 * @create 16/9/5 12:39
 */
public class SolarFrame extends MyFrame {
    //Image load image with util.class
    Image bg = GameUtil.getImage("images/bg.jpg");
    //Star sun , Planet
    Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2); //后期精确图片宽高
    Planet earth = new Planet(sun, "images/Earth.jpg", 150, 100, 0.1);
    Planet mars = new Planet(sun, "images/Mars.jpg", 240, 150, 0.05);

    Planet moon = new Planet(earth, "images/moon.jpg", 50, 20, 0.1, true);

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg, 0, 0, null);

        sun.draw(g);
        earth.draw(g);
        mars.draw(g);
        moon.draw(g);
    }

    public static void main(String[] args) {
        new SolarFrame().launchFrame();
    }
}
