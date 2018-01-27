package com.game.snake.gui;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class is the last window that user will see.
 * Short date about author.
 * This class implements Runnable and extends JFrame.
 */
public final class ExitGUI extends JFrame implements Runnable {

    /* List of the JLabel */
    private List<JLabel> labelList = new ArrayList<JLabel>(Arrays.asList(
            new JLabel(Setting.getAuthor()), new JLabel(Setting.getMail())
            , new JLabel(Setting.getFacebook()), new JLabel(Setting.getInstagram())
            , new JLabel(Setting.getGitHub()), new JLabel(Setting.getSkype())));

    public ExitGUI() {
        super("SNAKE");
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
            jLabel.setForeground(Color.red);
            gridBagConstraints.gridy = i++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
        }

        /* Set size and locations of the window, and start it */
        setPreferredSize(new Dimension(Setting.getExitWidth(), Setting.getExitHeight()));
        setLocationRelativeTo(null); // the center of the screen
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        /* Sleep 5 seconds to see the info */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /* Exit of the program */
        System.exit(0);
    }
}