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
 * @version 1.9
 *
 * Short date about author.
 */
public final class InfoGUI extends JFrame implements Runnable {

    /* Create static cached thread pool */
    private static ExecutorService executorService = Executors.newCachedThreadPool(); // FIXME: 08.02.2018

    /* Our Setting singleton object */
    private final Setting setting = Setting.getInstance();

    /* Our container and Bag for set label at the GUI */
    private Container pane = getContentPane();
    private GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /* Get list of the JLabels to InfoGUI from Setting class */
    private List<JLabel> infoGUIJLabelList = new ArrayList<JLabel>(Arrays.asList( // FIXME: 08.02.2018
            new JLabel(Setting.getAUTHOR()),
            new JLabel(setting.getInfoDataCreate()),
            new JLabel(setting.getInfoMail()),
            new JLabel(setting.getInfoFacebook()),
            new JLabel(setting.getInfoInstagram()),
            new JLabel(setting.getInfoGitHub()),
            new JLabel(setting.getInfoSkype()),
            new JLabel(setting.getInfoThanks())
    ));

    /**
     * Constructor that set GUI title and create new BagLayout.
     */
    public InfoGUI() throws HeadlessException {
        /* Get InfoGUI title from the setting */
        setTitle(setting.getInfoGUIJFrameTitle());

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
        for (JLabel jLabel : infoGUIJLabelList) {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
            executorService.execute(new ColorChange(jLabel, setting));
        }
    }

    /**
     * Set size and locations of the window, and start it
     */
    private void setJFrame() {
        setPreferredSize(new Dimension(setting.getInfoGUIWidth(), setting.getInfoGUIHeight()));
        setLocationRelativeTo(null); // The center of the screen
        pack();
        setVisible(true);
    }
}
