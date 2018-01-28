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
 * @version 1.5
 *
 * Short date about author.
 * This class implements Runnable and extends JFrame.
 */
public class InfoGUI extends JFrame implements Runnable {

    /* Create static cached thread pool */
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /* List of the JLabel */
    private List<JLabel> labelList = new ArrayList<JLabel>(Arrays.asList(
            new JLabel(Setting.getAUTHOR()), new JLabel(Setting.getInfoDataCreate())
            , new JLabel(Setting.getInfoMail()), new JLabel(Setting.getInfoFacebook())
            , new JLabel(Setting.getInfoInstagram()), new JLabel(Setting.getInfoGitHub())
            , new JLabel(Setting.getInfoSkype()), new JLabel(Setting.getInfoThanks())));

    public InfoGUI() throws HeadlessException {
        super(Setting.getInfoJFrameTitle());
    }

    @Override
    public void run() {
        /* Get the panel and use GridBagLayout to create main menu */
        Container pane = getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.fill = GridBagConstraints.BOTH;

        /* Label */
        int i = 0;
        for (JLabel jLabel : labelList) {
            InfoGUI.executorService.execute(() -> {
                try {
                    ColorChange.changeColorOfLabel(jLabel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            gridBagConstraints.gridy = i++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
        }

        /* Set size and locations of the window, and start it */
        setPreferredSize(new Dimension(Setting.getInfoWidth(), Setting.getInfoHeight()));
        setLocationRelativeTo(null); // The center of the screen
        pack();
        setVisible(true);
    }
}
