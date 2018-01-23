package com.game.snake.controller;

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

    @Override
    public void run() {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Snake");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false); // Frame
        frame.setSize((Room.room.getWidth() * 10) + 17, (Room.room.getHeight() * 10) + 40);
        frame.setLayout(new GridBagLayout());

        /* do not need from version 1.1*/
//        frame.addFocusListener(new FocusListener() {
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                //do nothing
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                System.exit(0);
//            }
//        });

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

