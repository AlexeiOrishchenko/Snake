package com.game.snake.graphics;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.6
 *
 * This class have method that change color of the label every times of ms.
 */
public class ColorChange {

    /**
     * This method set the color of the label, and change it every sleepTime ms
     * @param jLabel the label that we are set the color
     */
    public static void changeColorOfLabel(final JLabel jLabel) throws InterruptedException {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        while (true) {
            if (!Setting.isChangeColor()) {
                Thread.sleep(1000);
            } else if (Setting.isWaitThreadMainMenu()) {
                Thread.sleep(1000);
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
     * Sleep ms
     */
    private static void sleep() throws InterruptedException {
        Thread.sleep(Setting.getSleepColorChangeTimeMS());
    }
}
