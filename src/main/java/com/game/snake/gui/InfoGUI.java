package com.game.snake.gui;

import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.11
 */
public final class InfoGUI extends JFrame implements Runnable {

    private static volatile InfoGUI infoGUI;

    private static boolean initialized = false;

    private JLabel LabelWithIcon;

    private String ResourceName = String.valueOf("/InfoPicture.png");

    private InfoGUI() throws HeadlessException {
        setTitle("Snake - INFO");
    }

    @Contract(pure = true)
    public static boolean isInitialized() {
        return initialized;
    }

    @Contract(pure = true)
    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
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

    @Override
    public void run() {
        initJLabel();
        initJFrame();
    }

    private void initJLabel() {
        loadResource();
        getContentPane().add(LabelWithIcon);
        initialized = true;
    }

    private void loadResource() {
        if (LabelWithIcon == null) {
            LabelWithIcon = new JLabel(new ImageIcon(getClass().getResource(ResourceName)));
            logImageLoad();
        }
    }

    private void logImageLoad() {
        System.out.println(
                "File path: " + getClass().getResource(ResourceName) +
                "\tWidth = " + LabelWithIcon.getIcon().getIconWidth() +
                "\tHeight = " + LabelWithIcon.getIcon().getIconHeight()
        );
    }

    private void initJFrame() {
        setPreferredSize(new Dimension(
                LabelWithIcon.getIcon().getIconWidth(),
                LabelWithIcon.getIcon().getIconHeight()
        ));
        pack();
        setVisible(true);
    }
}
