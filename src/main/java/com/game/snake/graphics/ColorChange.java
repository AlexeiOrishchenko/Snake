package com.game.snake.graphics;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public class ColorChange implements Runnable {

    private final Setting setting = Setting.getInstance();
    private final JLabel jLabel;

    public ColorChange(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        changeColorOfLabel();
    }

    private void changeColorOfLabel() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        while (true) {
            if (!setting.isChangeColor()) {
                sleep(1000);
            } else if (setting.isMainMenuWaitThread()) {
                sleep(1000);
            } else {
                if (r < 255) {
                    r++;
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                } else {
                    for (; r > 0; r--) {
                        jLabel.setForeground(new Color(r, g, b));
                        sleep();
                    }
                }
                if (g < 254) {
                    g += 2;
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                } else {
                    for (; g > 0; g--) {
                        jLabel.setForeground(new Color(r, g, b));
                        sleep();
                    }
                }
                if (b < 253) {
                    b += 3;
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                } else {
                    for (; b > 0; b--) {
                        jLabel.setForeground(new Color(r, g, b));
                        sleep();
                    }
                }
            }
        }
    }

    private void sleep()  {
        try {
            Thread.sleep(setting.getColorChangeSleepTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
