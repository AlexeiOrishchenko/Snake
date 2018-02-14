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

    private int red = (int) (Math.random() * 256);
    private int green = (int) (Math.random() * 256);
    private int blue = (int) (Math.random() * 256);

    public ColorChange(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        changeColorOfLabel();
    }

    private void changeColorOfLabel() {
        while (true) {
            if (checkWaiting()) {
                sleep(1000);
            }

            changeRedColor();
            changeGreenColor();
            changeBlueColor();
        }
    }

    private boolean checkWaiting() {
        return ((!setting.isChangeColor()) || (setting.isMainMenuWaitThread()));
    }

    private void changeRedColor() {
        if (red < 255) {
            red++;
            jLabel.setForeground(new Color(red, green, blue));
            sleep();
        } else {
            for (; red > 0; red--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep();
            }
        }
    }

    private void changeGreenColor() {
        if (green < 254) {
            green += 2;
            jLabel.setForeground(new Color(red, green, blue));
            sleep();
        } else {
            for (; green > 0; green--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep();
            }
        }
    }

    private void changeBlueColor() {
        if (blue < 253) {
            blue += 3;
            jLabel.setForeground(new Color(red, green, blue));
            sleep();
        } else {
            for (; blue > 0; blue--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep();
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
