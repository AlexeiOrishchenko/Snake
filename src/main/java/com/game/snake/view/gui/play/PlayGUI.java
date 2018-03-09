package com.game.snake.view.gui.play;

import com.game.snake.model.objects.room.Room;
import com.game.snake.model.setting.Setting;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class PlayGUI implements Runnable {

    @Getter private final JFrame jFrame = new JFrame();

    private final Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<>(1000); // FIXME: MOVE TO MODEL

    @Getter @Setter private String titleName = String.valueOf("Snake - PLAY");

    public PlayGUI() {
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
        val setting = Setting.getInstance();

        val roomWidth = Room.getInstance().getWidth(); // TODO: DELEGATE TO CONTROLLER
        val roomHeight = Room.getInstance().getHeight(); // TODO: DELEGATE TO CONTROLLER
        jFrame.setMinimumSize(new Dimension(
                ((roomWidth + 3) * setting.getSizeOfGame()) + 17,
                ((roomHeight + 3) * setting.getSizeOfGame()) + 40
        ));
    }

    private void setCenterScreen() {
        val roomWidth = Room.getInstance().getWidth(); // TODO: DELEGATE TO CONTROLLER
        val roomHeight = Room.getInstance().getHeight(); // TODO: DELEGATE TO CONTROLLER
        if (!((roomWidth > 20) || (roomHeight > 20))) {
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
