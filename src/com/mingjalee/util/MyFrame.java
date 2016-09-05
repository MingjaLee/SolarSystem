package com.mingjalee.util;

import com.mingjalee.util.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author jerry
 * @create 16/9/5 12:05
 */
public class MyFrame extends Frame {
    /**
     * 加载窗口
     */
    public void launchFrame() {
        setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        setLocation(100, 100);
        setVisible(true);

        new PaintThread().start(); //启动线程重画

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 定义一个重画窗口的线程类,是个内部类
     * @author Jerry
     */
    class PaintThread extends Thread {
        public void run() {
            while(true) {
                //do something
                repaint();
                try {
                    Thread.sleep(40); //1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
