package com.qthegamep.snake.view.swing.gui.play;

import com.qthegamep.snake.model.Model;
import com.qthegamep.snake.view.swing.setting.Setting;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class PlayGUI implements Runnable { // TODO: refract in future

    @Getter private final JFrame jFrame = new JFrame();

    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(1000);

    @Getter @Setter private String titleName = String.valueOf("Snake - PLAY");

    public PlayGUI() {
        initJFrame();
    }

    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
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
        val setting = Setting.getInstance();

        val roomWidth = Model.getInstance().getRoomWidth();
        val roomHeight = Model.getInstance().getRoomHeight();
        jFrame.setMinimumSize(new Dimension(
                ((roomWidth + 2) * setting.getSizeOfGame()) + 17,
                ((roomHeight + 2) * setting.getSizeOfGame()) + 40
        ));
    }

    private void setCenterScreen() {
        jFrame.setLocationRelativeTo(null);
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (keyEvents.isEmpty()) {
                    keyEvents.add(e);
                } else {
                    if (!(Objects.requireNonNull(keyEvents.peek()).getKeyCode() == e.getKeyCode())) {
                        keyEvents.add(e);
                    }
                }
            }
        });
    }
}
