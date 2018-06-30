package com.qthegamep.snake.view.swing.gui.info;

import lombok.Getter;
import lombok.Setter;
import lombok.val;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public final class InfoGUI implements Runnable {

    private static volatile InfoGUI instance;

    private final JFrame jFrame = new JFrame();

    @Getter @Setter private Image image;

    @Getter @Setter private String resourceName = String.valueOf("/Info.png");
    @Getter @Setter private String titleName = String.valueOf("Snake - INFO");

    @Getter @Setter private int imagePreferenceWidth = 1000;
    @Getter @Setter private int imagePreferenceHeight = 625;
    @Getter @Setter private int imageMinWidth = 400;
    @Getter @Setter private int imageMinHeight = 250;

    @Getter private boolean initialized = false;

    private InfoGUI() {
    }

    public static InfoGUI getInstance() {
        if (InfoGUI.instance == null) {
            synchronized (InfoGUI.class) {
                if (InfoGUI.instance == null) {
                    InfoGUI.instance = new InfoGUI();
                }
            }
        }
        return InfoGUI.instance;
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    @Override
    public void run() {
        initImage();
        initJFrame();
    }

    private void initImage() {
        loadResource();
        setResources();
    }

    private void loadResource() {
        if (image == null) {
            try {
                image = ImageIO.read(getClass().getResource(resourceName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void setResources() {
        val imagePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null){
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        imagePanel.setLayout(new BorderLayout());
        jFrame.add(new JScrollPane(imagePanel));
    }

    private void initJFrame() {
        jFrame.setTitle(titleName);
        setJFrameSize();
        jFrame.pack();
        setCenterOfScreen();
        setJFrameKeyEvent();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        initialized = true;
    }

    private void setJFrameSize() {
        jFrame.setPreferredSize(new Dimension(
                imagePreferenceWidth,
                imagePreferenceHeight
        ));
        jFrame.setMinimumSize(new Dimension(
                imageMinWidth,
                imageMinHeight
        ));
    }

    private void setCenterOfScreen() {
        jFrame.setLocationRelativeTo(null);
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.dispose();
                }
            }
        });
    }
}
