package com.qthegamep.snake.view.swing.gui.exit;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public final class ExitGUI implements Runnable {

    private static volatile ExitGUI instance;

    private final JFrame jFrame;

    private JLabel jLabelWithIcon;

    @Getter @Setter private String resourceName = String.valueOf("/Exit.jpg");
    @Getter @Setter private String titleName = String.valueOf("Snake - EXIT");

    @Getter @Setter private long sleepTimeToExitMS = 10000L;

    @Getter private boolean initialized = false;

    private ExitGUI() {
        jFrame = new JFrame();
    }

    public static ExitGUI getInstance() {
        if (ExitGUI.instance == null) {
            synchronized (ExitGUI.class) {
                if (ExitGUI.instance == null) {
                    ExitGUI.instance = new ExitGUI();
                }
            }
        }
        return ExitGUI.instance;
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
        jFrame.getContentPane().add(jLabelWithIcon);
    }

    private void loadResource() {
        if (jLabelWithIcon == null) {
            jLabelWithIcon = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void initJFrame() {
        jFrame.setTitle(titleName);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); /* The center of the screen */
        setJFrameKeyEvent();
        jFrame.setVisible(true);
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.dispose();
                    exit();
                }
            }
        });
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTimeToExitMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Contract(" -> fail")
    private void exit() {
        System.exit(0);
    }
}
