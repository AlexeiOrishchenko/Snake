package com.game.snake.graphics;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.9
 *
 * This class have method that change color of the label every times of ms.
 */
public class ColorChange implements Runnable {

    /* Our jLabel to change color */
    private final JLabel jLabel;
    /* Our Setting singleton object */
    private final Setting setting;

    /**
     * @param jLabel is the label that we are set the color
     * @param setting is the Setting class object to get setting
     */
    public ColorChange(JLabel jLabel, Setting setting) {
        this.jLabel = jLabel;
        this.setting = setting;
    }

    /**
     * Start changing of the color
     */
    @Override
    public void run() {
        changeColorOfLabel();
    }

    /**
     * This method set the color of the label, and change it every sleepTime ms
     */
    public void changeColorOfLabel() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        while (true) {
            if (!setting.isChangeColor()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (setting.isMainMenuWaitThread()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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

    /**
     * Get ms sleep from Setting class
     */
    private void sleep()  {
        try {
            Thread.sleep(setting.getColorChangeSleepTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
