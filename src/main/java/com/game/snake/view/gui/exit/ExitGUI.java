package com.game.snake.view.gui.exit;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public final class ExitGUI implements Runnable {

    private static volatile ExitGUI exitGUI;

    @Getter private boolean initialized = false;

    private final JFrame jFrame;

    private JLabel labelWithIcon;

    @Getter @Setter private String resourceName = String.valueOf("/ExitPicture.jpg");
    @Getter @Setter private String exitGUITitle = String.valueOf("Snake - EXIT");
    @Getter @Setter private long sleepTimeMS = 10000L;

    private ExitGUI() {
        jFrame = new JFrame();
    }

    public static ExitGUI getInstance() {
        if (exitGUI == null) {
            synchronized (ExitGUI.class) {
                if (exitGUI == null) {
                    exitGUI = new ExitGUI();
                }
            }
        }
        return exitGUI;
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    @Override
    public void run() {
        initJLabel();
        initJFrame();
        sleep();
        exit();
    }

    private void initJLabel() {
        loadResource();
        jFrame.getContentPane().add(labelWithIcon);
    }

    private void loadResource() {
        if (labelWithIcon == null) {
            labelWithIcon = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void initJFrame() {
        jFrame.setTitle(exitGUITitle);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); /* The center of the screen */
        setJFrameKeyEvent();
        jFrame.setVisible(true);
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.setVisible(false);
                    exit();
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                /* Do nothing */
            }
        });
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTimeMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Contract(" -> fail")
    private void exit() {
        System.exit(0);
    }
}
