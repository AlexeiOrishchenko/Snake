package com.game.snake.controller;

import com.game.snake.model.setting.Setting;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class KeyboardObserver implements Runnable { // TODO: MOVE TO VIEW

    @Getter private final JFrame jFrame = new JFrame();

    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(1000); // FIXME: MOVE TO MODEL

    private final Setting setting = Setting.getInstance();

    @Getter @Setter private String titleName = String.valueOf("Snake - PLAY");

    public KeyboardObserver() {
        initJFrame();
    }

    public boolean hasKeyEvents() { // FIXME: MOVE TO MODEL
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() { // FIXME: MOVE TO MODEL
        return keyEvents.poll();
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    public void offVisible() {
        jFrame.dispose();
    }

    @Override
    public void run() {
        setJFrameKeyEvent();
    }
    private void initJFrame() {
        jFrame.setTitle(titleName);
        setJFrameSize();
        jFrame.pack();
        setCenterScreen();
    }

    private void setJFrameSize() {
        jFrame.setMinimumSize(new Dimension(
                ((setting.getRoomWidth() + 3) * setting.getSizeOfGame()) + 17,
                ((setting.getRoomHeight() + 3) * setting.getSizeOfGame()) + 40
        ));
    }

    private void setCenterScreen() {
        if (!((setting.getRoomHeight() > 20) || (setting.getRoomWidth() > 20))) {
            jFrame.setLocationRelativeTo(null);
        }
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                /* Do nothing */
            }
        });
    }
}
