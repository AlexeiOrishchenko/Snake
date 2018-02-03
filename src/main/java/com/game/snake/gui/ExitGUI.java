package com.game.snake.gui;

import com.game.snake.graphics.ColorChange;
import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.6
 *
 * This class is the last window that user will see.
 */
public class ExitGUI extends JFrame implements Runnable {

    private final JLabel jLabelThanks = new JLabel(Setting.getInfoThanks());

    /* Our container and Bag for set label at the GUI */
    private Container pane = getContentPane();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /**
     * Constructor that set GUI title and create
     * new BagLayout.
     */
    public ExitGUI() {
        super(Setting.getExitJFrameTitle());

        pane.setLayout(new GridBagLayout());

        /* Centralize all the labels */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    /**
     * Create fast change label, and in 10 sec exit the game
     */
    @Override
    public void run() {
        setJLabel();
        setJFame();
        sleep();

        /* Exit of the program */
        System.exit(0);
    }

    /**
     * This method add JLabel to the pane and start ColorChange in new
     * thread
     */
    private void setJLabel() {
        pane.add(jLabelThanks, gridBagConstraints);

        /* Set fast change color and start change color */
        Setting.setSleepColorChangeTimeMS(1);
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ColorChange.changeColorOfLabel(jLabelThanks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Set size and locations of the window, and start it
     */
    private void setJFame() {
        setPreferredSize(new Dimension(Setting.getExitWidth(), Setting.getExitHeight()));
        setLocationRelativeTo(null); // the center of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Sleep 10 seconds to see the last gui
     */
    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}