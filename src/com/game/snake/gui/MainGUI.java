package com.game.snake.gui;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class is the main GUI that has button "Play", "Setting" and "Exit", and also info
 * about author of this game.
 * This class implements Runnable and extends JFrame.
 */
public class MainGUI implements Runnable {

    private final JFrame jFrame = new JFrame("Snake");
    private final JLabel jLabelSnake = new JLabel("Welcome to the game \"SNAKE\"");
    private final JButton jButtonPlay = new JButton("PLAY");
    private final JButton jButtonSetting = new JButton("SETTING");
    private final JButton jButtonExit = new JButton("EXIT");
    private final JLabel jLabelAuthor = new JLabel("Author: Koliadin Nikita");

    public MainGUI() {
    }

    @Override
    public void run() {

        /* Get the panel and use GridBagLayout to create main menu */
        Container pane = jFrame.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        /* Label */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(-100,0,25,0);
        pane.add(jLabelSnake, gridBagConstraints);
        /* Start thread that every 10ms change the color of the label */
        Executors.newSingleThreadExecutor().execute(() -> changeColorOfLabel(jLabelSnake));


        /* Button "PLAY" */
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10,0,0,0);
        jButtonPlay.addActionListener(e -> {
            /* Close mainMenu visible */
            MainGUI.this.jFrame.setVisible(false);

            new PlayGUI(jFrame).run();
        });
        pane.add(jButtonPlay, gridBagConstraints);


        /* Button "SETTING" */
        gridBagConstraints.gridy = 2;
        jButtonSetting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // FIXME: 27.01.2018
            }
        });
        pane.add(jButtonSetting, gridBagConstraints);


        /* Button "EXIT" */
        gridBagConstraints.gridy = 3;
        jButtonExit.addActionListener(e -> {

            /* Close mainMenu visible */
            MainGUI.this.jFrame.setVisible(false);

            /* Start ExitGUI in new thread */
            ExitGUI exitGUI = new ExitGUI();
            Thread thread = new Thread(exitGUI);
            thread.start();
        });
        pane.add(jButtonExit, gridBagConstraints);


        /* Label */
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(0,60,-100,0);
        pane.add(jLabelAuthor, gridBagConstraints);
        /* Start thread that every 10ms change the color of the label */
        Executors.newSingleThreadExecutor().execute(() -> changeColorOfLabel(jLabelAuthor));


        /* Set size and locations of the window, and start it */
        jFrame.setPreferredSize(new Dimension(Setting.getMainMenuWidth(), Setting.getMainMenuHeight()));
        jFrame.setLocationRelativeTo(null); // the center of the screen
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    /**
     * <b> This method set the color of the label, and change it every 10 ms</b>
     * @param jLabel <b>the label that we are set the color</b>
     */
    private void changeColorOfLabel(final JLabel jLabel) {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        while (true) {
            if (r < 255) {
                r++;
                jLabel.setForeground(new Color(r, g, b));
                sleep();
            } else {
                for (; r > 0 ; r--) {
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                }
            }
            if (g < 254) {
                g += 2;
                jLabel.setForeground(new Color(r, g, b));
                sleep();
            } else {
                for (; g > 0; g--) {
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                }
            }
            if (b < 253) {
                b += 3;
                jLabel.setForeground(new Color(r, g, b));
                sleep();
            } else {
                for (; b > 0; b--) {
                    jLabel.setForeground(new Color(r, g, b));
                    sleep();
                }
            }
        }
    }

    /**
     * <b>Sleep 10 ms</b>
     */
    private void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
