package com.mingjalee.solarsystem;

import com.mingjalee.util.GameUtil;

import java.awt.*;

/**
 * 星球类
 * @author jerry
 * @create 16/9/5 12:52
 */
public class Star {
    //图片,位置x,y
    Image img;
    double x, y;
    int width, height;

    public Star(Image img) {
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public Star(Image img, double x, double y) {
        this(img);
        this.x = x;
        this.y = y;
    }

    public Star(String imgPath, double x, double y) {
        this(GameUtil.getImage(imgPath), x, y);
    }

    /**
     * 画出星球到屏幕上
     */
    public void draw(Graphics g) {
        g.drawImage(img, (int)x, (int)y, null);
    }
}
