package com.mingjalee.solarsystem;

import com.mingjalee.util.GameUtil;

import java.awt.*;

/**
 * @author jerry
 * @create 16/9/5 14:37
 */
public class Planet extends Star {
    // 图片、坐标xy、行星的轨迹椭圆:长轴,短轴,角度,速度(即角度增量)、围绕某个Star转
    double longAxis;
    double shortAxis;
    double degree; //默认从0开始
    double speed;
    Star center;

    boolean satellite;

    public Planet(Star center, String imgPath, double longAxis, double shortAxis, double speed) {
        this(center, GameUtil.getImage(imgPath), longAxis, shortAxis, speed);
    }

    public Planet(Star center, Image img, double longAxis, double shortAxis, double speed) {
        super(img);

        this.center = center;
        this.x = (center.x + center.width/2) + longAxis - this.width/2;
        this.y = (center.y + center.height/2) - this.height/2;

        this.longAxis = longAxis;
        this.shortAxis = shortAxis;
        this.speed = speed;
    }

    public Planet(Star center, String imgPath, double longAxis, double shortAxis,
                  double speed, boolean satellite) {
        this(center, imgPath, longAxis, shortAxis, speed);

        this.satellite = satellite;
    }

    public Planet(Star center, Image img, double longAxis, double shortAxis,
                  double speed, boolean satellite) {
        this(center, img, longAxis, shortAxis, speed);

        this.satellite = satellite;
    }



    @Override
    public void draw(Graphics g) {
        super.draw(g);

        if(!satellite) {
            drawTrace(g);
        }
        move();
    }

    /**
     *  画出轨迹线,更直观
     */
    public void drawTrace(Graphics g) {
        double ovalX, ovalY, ovalWidth, ovalHeight;

        ovalWidth = 2 * longAxis;
        ovalHeight = 2 * shortAxis;

        ovalX = (center.x + center.width/2) - longAxis;
        ovalY = (center.y + center.height/2) - shortAxis;

        Color c = g.getColor();
        g.setColor(Color.blue);
        g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
        g.setColor(c);
    }

    /**
     * 行星绕轨迹运动
     */
    public void move() {
        //轨迹不精确,没计算center的宽高,待改进。。。
        //已改进
        this.x = (center.x + center.width/2) + longAxis * Math.cos(degree) - this.width/2;
        this.y = (center.y + center.height/2) + shortAxis * Math.sin(degree) - this.height/2;
        degree += speed;
    }
}
