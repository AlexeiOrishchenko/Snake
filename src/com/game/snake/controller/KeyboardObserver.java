package com.game.snake.controller;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class is listener
 */
public class KeyboardObserver implements Runnable {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(1000);

    public static JFrame jFrame;

    static {
        KeyboardObserver.jFrame = new JFrame("Snake");
        KeyboardObserver.jFrame.setUndecorated(false); // Frame window
        jFrame.setPreferredSize(new Dimension(Setting.getMainMenuWidth(), Setting.getMainMenuHeight()));
        jFrame.setLocationRelativeTo(null); // the center of the screen
        KeyboardObserver.jFrame.setSize(
                ((Setting.getRoomWidth() + 3) * Setting.getSizeOfGame()) + 17,
                ((Setting.getRoomHeight() + 3) * Setting.getSizeOfGame()) + 40);
    }

    @Override
    public void run() {
        jFrame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyReleased(KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });
    }

    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }
}