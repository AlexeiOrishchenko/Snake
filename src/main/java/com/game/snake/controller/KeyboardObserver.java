package com.game.snake.controller;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.10
 *
 * This class is listener
 */
public class KeyboardObserver extends JFrame implements Runnable {

    /* Our queue of key pressed button */
    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(1000);

    /**
     * This is constructor that set play title and size of the game window
     */
    public KeyboardObserver() {
        /* Our Setting singleton object */
        Setting setting = Setting.getInstance();

        /* Set title of game gui */
        setTitle(setting.getPlayJFrameTitle());

        /* Frame window */
        setUndecorated(false);

        /* The center of the screen */
        if (!((setting.getRoomHeight() > 20) || (setting.getRoomWidth() > 20))) {
            setLocationRelativeTo(null);
        }

        /* Set size of the window by width and height of the room */
        setSize(
                ((setting.getRoomWidth() + 3) * setting.getSizeOfGame()) + 17,
                ((setting.getRoomHeight() + 3) * setting.getSizeOfGame()) + 40
        );
    }

    /**
     * This is listener of the keyboard. Every key event add to the ArrayBlockingQueue
     */
    @Override
    public void run() {
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
                /* Add event to the queue */
                keyEvents.add(e);
            }
        });
    }

    /**
     * @return if has any key event - true
     */
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