package com.mingjalee.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 图片加载工具类
 * @author jerry
 * @create 16/9/5 12:42
 */
public class GameUtil {
    private GameUtil(){}    //工具类构造最好私有

    public static Image getImage(String imgpath) {
        BufferedImage img = null;
        URL url = GameUtil.class.getClassLoader().getResource(imgpath);
        System.out.println(url);
        try {
            img = javax.imageio.ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }
}
