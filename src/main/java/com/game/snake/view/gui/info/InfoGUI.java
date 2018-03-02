package com.game.snake.view.gui.info;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public final class InfoGUI implements Runnable {

    private static volatile InfoGUI infoGUI;

    @Getter private boolean initialized = false;

    private final JFrame jFrame;

    private JLabel labelWithIcon;

    @Getter @Setter private String resourceName = String.valueOf("/InfoPicture.png");
    @Getter @Setter private String infoGUITitle = String.valueOf("Snake - INFO");

    private InfoGUI() {
        jFrame = new JFrame();
    }

    public static InfoGUI getInstance() {
        if (infoGUI == null) {
            synchronized (InfoGUI.class) {
                if (infoGUI == null) {
                    infoGUI = new InfoGUI();
                }
            }
        }
        return infoGUI;
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    @Override
    public void run() {
        initJLabel();
        initJFrame();
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
        jFrame.setTitle(infoGUITitle);
        setJFrameSize();
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); /* The center of the screen */
        jFrame.setVisible(true);
        setJFrameKeyEvent();
        initialized = true;
    }

    private void setJFrameSize() {
        val iconWidth = labelWithIcon.getIcon().getIconWidth();
        val iconHeight = labelWithIcon.getIcon().getIconHeight();

        jFrame.setPreferredSize(new Dimension(
                iconWidth,
                iconHeight
        ));
        jFrame.setMinimumSize(new Dimension(
                iconWidth,
                iconHeight
        ));
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.setVisible(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                /* Do nothing */
            }
        });
    }
}
