package com.game.snake.controller;

import com.game.snake.model.setting.Setting;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public class KeyboardObserver extends JFrame implements Runnable {

    private final Setting setting = Setting.getInstance();

    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(1000);

    public KeyboardObserver() {
        setTitle(setting.getPlayJFrameTitle());
        setUndecorated(false);
        setCenterScreen();
        setSize(
                ((setting.getRoomWidth() + 3) * setting.getSizeOfGame()) + 17,
                ((setting.getRoomHeight() + 3) * setting.getSizeOfGame()) + 40
        );
    }

    @Override
    public void run() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
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

    private void setCenterScreen() {
        if (!((setting.getRoomHeight() > 20) || (setting.getRoomWidth() > 20))) {
            setLocationRelativeTo(null);
        }
    }
}
