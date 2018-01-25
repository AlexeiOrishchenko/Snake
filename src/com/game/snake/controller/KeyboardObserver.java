package com.game.snake.controller;

import com.game.snake.setting.Setting;
import com.game.snake.objects.room.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is listener
 */
public class KeyboardObserver extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    public static JFrame frame;

    static {
        KeyboardObserver.frame = new JFrame();
        KeyboardObserver.frame.setTitle("Snake");
        KeyboardObserver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyboardObserver.frame.setUndecorated(false); // Frame
        KeyboardObserver.frame.setSize(((Room.room.getWidth() + 3) * Setting.getSizeOfGame()) + 17, ((Room.room.getHeight() + 3) * Setting.getSizeOfGame()) + 40);
        KeyboardObserver.frame.setLayout(new GridBagLayout());
    }

    @Override
    public void run() {
        frame.addKeyListener(new KeyListener() {

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

