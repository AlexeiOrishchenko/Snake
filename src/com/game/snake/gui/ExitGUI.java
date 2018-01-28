package com.game.snake.gui;

import com.game.snake.graphics.ColorChange;
import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.5
 *
 * This class is the last window that user will see.
 * Short date about author.
 * This class implements Runnable and extends JFrame.
 */
public class ExitGUI extends JFrame implements Runnable {

    private final JLabel jLabelThanks = new JLabel(Setting.getInfoThanks());

    /**
     * Set title of the window
     */
    public ExitGUI() {
        super(Setting.getExitJFrameTitle());
    }


    /**
     * Create fast change label, and in 10 sec exit the game
     */
    @Override
    public void run() {
        /* Get the panel and use GridBagLayout to create main menu */
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();


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

        /* Set size and locations of the window, and start it */
        setPreferredSize(new Dimension(Setting.getExitWidth(), Setting.getExitHeight()));
        setLocationRelativeTo(null); // the center of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        /* Sleep 10 seconds to see the last gui */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Exit of the program */
        System.exit(0);
    }
}