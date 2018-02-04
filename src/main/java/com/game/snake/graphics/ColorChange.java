package com.game.snake.graphics;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.8
 *
 * This class have method that change color of the label every times of ms.
 */
public class ColorChange {

    /**
     * This method set the color of the label, and change it every sleepTime ms
     * @param jLabel the label that we are set the color
     */
    public static void changeColorOfLabel(final JLabel jLabel) {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        while (true) {
            if (!Setting.isChangeColor()) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Setting.isMainMenuWaitThread()) {
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
    private static void sleep()  {
        try {
            Thread.sleep(Setting.getColorChangeSleepTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
