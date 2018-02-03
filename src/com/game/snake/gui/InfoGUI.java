package com.game.snake.gui;

import com.game.snake.graphics.ColorChange;
import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.6
 *
 * Short date about author.
 */
public class InfoGUI extends JFrame implements Runnable {

    /* Create static cached thread pool */
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /* List of the JLabel */
    private List<JLabel> labelList = new ArrayList<JLabel>(Arrays.asList(
            new JLabel(Setting.getAUTHOR()),
            new JLabel(Setting.getInfoDataCreate()),
            new JLabel(Setting.getInfoMail()),
            new JLabel(Setting.getInfoFacebook()),
            new JLabel(Setting.getInfoInstagram()),
            new JLabel(Setting.getInfoGitHub()),
            new JLabel(Setting.getInfoSkype()),
            new JLabel(Setting.getInfoThanks())));

    /* Our container and Bag for set label at the GUI */
    private Container pane = getContentPane();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /**
     * Constructor that set GUI title and create
     * new BagLayout.
     */
    public InfoGUI() throws HeadlessException {
        super(Setting.getInfoJFrameTitle());

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
        setJFrame();
    }

    /**
     * This method add JLabel to the pane and start ColorChange in new
     * thread
     */
    private void setJLabel() {
        int i = 0;
        for (JLabel jLabel : labelList) {
            gridBagConstraints.gridy = i++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
            InfoGUI.executorService.execute(() -> {
                try {
                    ColorChange.changeColorOfLabel(jLabel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * Set size and locations of the window, and start it
     */
    private void setJFrame() {
        setPreferredSize(new Dimension(Setting.getInfoWidth(), Setting.getInfoHeight()));
        setLocationRelativeTo(null); // The center of the screen
        pack();
        setVisible(true);
    }
}
