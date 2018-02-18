package com.game.snake.gui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.12
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
            logImageLoad();
        }
    }

    private void logImageLoad() {
        System.out.println(
                "File path: " + getClass().getResource(resourceName) +
                "\tWidth = " + labelWithIcon.getIcon().getIconWidth() +
                "\tHeight = " + labelWithIcon.getIcon().getIconHeight()
        );
    }

    private void initJFrame() {
        jFrame.setTitle(infoGUITitle);
        jFrame.setPreferredSize(new Dimension(
                labelWithIcon.getIcon().getIconWidth(),
                labelWithIcon.getIcon().getIconHeight()
        ));
        jFrame.pack();
        jFrame.setVisible(true);
        initialized = true;
    }
}
