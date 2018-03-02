package com.game.snake.view.graphics;

import com.game.snake.setting.Setting;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class ChangeColor implements Runnable {

    @Getter @Setter private static boolean mainMenuWaitThread = false;

    @Getter @Setter private static long sleepWaitMS = 1000;
    @Getter @Setter private static long sleepChangeMS = 1;

    private final Setting setting = Setting.getInstance();

    private final JLabel jLabel;

    private int red = (int) (Math.random() * 256);
    private int green = (int) (Math.random() * 256);
    private int blue = (int) (Math.random() * 256);

    public ChangeColor(@NonNull final JLabel jLabel) {
        this.jLabel = jLabel;
    }

    @Override
    public void run() {
        changeColor();
    }

    private void changeColor() {
        while (true) { // TODO: shutdown
            if (isWaiting()) {
                sleep(ChangeColor.sleepWaitMS);
            }

            changeRedColor();
            changeGreenColor();
            changeBlueColor();
        }
    }

    private boolean isWaiting() {
        return ((!setting.isChangeColor()) || (ChangeColor.mainMenuWaitThread));
    }

    private void changeRedColor() {
        if (red < 255) {
            red++;
            jLabel.setForeground(new Color(red, green, blue));
            sleep(ChangeColor.sleepChangeMS);
        } else {
            for (; red > 0; red--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep(ChangeColor.sleepChangeMS);
            }
        }
    }

    private void changeGreenColor() {
        if (green < 254) {
            green += 2;
            jLabel.setForeground(new Color(red, green, blue));
            sleep(ChangeColor.sleepChangeMS);
        } else {
            for (; green > 0; green--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep(ChangeColor.sleepChangeMS);
            }
        }
    }

    private void changeBlueColor() {
        if (blue < 253) {
            blue += 3;
            jLabel.setForeground(new Color(red, green, blue));
            sleep(ChangeColor.sleepChangeMS);
        } else {
            for (; blue > 0; blue--) {
                jLabel.setForeground(new Color(red, green, blue));
                sleep(ChangeColor.sleepChangeMS);
            }
        }
    }

    private void sleep(final long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
