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
 * @version 1.9
 *
 * This class is listener
 */
public class KeyboardObserver extends JFrame implements Runnable {

    /* Our queue of key pressed button */
    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(1000);

    /* Our Setting singleton object */
    private Setting setting = Setting.getInstance();

    /**
     * This is constructor that set play title and size of the game window
     */
    public KeyboardObserver() {
        setTitle(setting.getPlayJFrameTitle());
        setUndecorated(false); // Frame window
//        setPreferredSize(new Dimension(setting.getMainMenuWidth(), setting.getMainMenuHeight())); // FIXME: 08.02.2018
        setLocationRelativeTo(null); // the center of the screen
    }

    /**
     * This is listener of the keyboard. Every key event add to the ArrayBlockingQueue
     */
    @Override
    public void run() {
        setSize(
                ((setting.getRoomWidth() + 3) * setting.getSizeOfGame()) + 17,
                ((setting.getRoomHeight() + 3) * setting.getSizeOfGame()) + 40
        );

        addKeyListener(new KeyListener() {

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

    /**
     * @return the first added key event
     */
    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }
}