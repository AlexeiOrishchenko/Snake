package com.game.snake.gui;

import com.game.snake.graphics.ColorChange;
import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.8
 *
 * This class is the last window that user will see.
 */
public final class ExitGUI extends JFrame implements Runnable {

    /* Get list of the JLabels to ExitGUI from Setting class */
    private final List<JLabel> exitGUIJLabelList = Setting.getExitGUIJLabelList();

    /* Our container and Bag for set label at the GUI */
    private final Container pane = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /**
     * Constructor that set GUI title and create
     * new BagLayout.
     */
    public ExitGUI() {
        /* Get ExitGUI title from the Setting class */
        super(Setting.getExitGUIJFrameTitle());

        pane.setLayout(new GridBagLayout());

        /* Centralize all the labels */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    /**
     * Main method of this class, create JLabel and set
     * GUI window JFrame
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
     * thread if  Setting.changeColor is true
     */
    private void setJLabel() {
        for (JLabel jLabel : exitGUIJLabelList) {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
            if (Setting.isChangeColor()) {
                Executors.newCachedThreadPool().execute(() -> ColorChange.changeColorOfLabel(jLabel));
            }
        }
    }

    /**
     * Set size and locations of the window, and start it
     */
    private void setJFame() {
        setPreferredSize(new Dimension(Setting.getExitGUIWidth(), Setting.getExitGUIHeight()));
        setLocationRelativeTo(null); // the center of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    /**
     * Sleep to see the last gui
     */
    private void sleep() {
        try {
            Thread.sleep(Setting.getExitGUISleepTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}