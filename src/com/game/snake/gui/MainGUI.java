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
 * This class is the main GUI that has button "Play", "Setting" and "Exit", and also info
 * about author of this game.
 * This class implements Runnable.
 */
public class MainGUI implements Runnable {

    /* Initialize JFrame button and labels for main menu */
    private final JFrame jFrame = new JFrame(Setting.getMainMenuJFrameTitle());
    private final JLabel jLabelWelcome = new JLabel(Setting.getMainMenuJLabelWelcome());
    private final JButton jButtonPlay = new JButton(Setting.getMainMenuJButtonPlay());
    private final JButton jButtonSetting = new JButton(Setting.getMainMenuJButtonSetting());
    private final JButton jButtonInfo = new JButton(Setting.getMainMenuJButtonInfo());
    private final JButton jButtonExit = new JButton(Setting.getMainMenuJButtonExit());
    private final JLabel jLabelAuthor = new JLabel(Setting.getAUTHOR());

    public MainGUI() {
    }

    /**
     * This is the main method of the main menu. Default has 3 thread - one main menu listener
     * and 2 for change color labels.
     */
    @Override
    public void run() {
        /* Get the panel and use GridBagLayout to create main menu */
        Container pane = jFrame.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();


        /* Label */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(-100, 0, 25, 0);
        pane.add(jLabelWelcome, gridBagConstraints);
        /* Start thread that every 10ms change the color of the label */
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ColorChange.changeColorOfLabel(jLabelWelcome);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        /* Button "PLAY" */
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        jButtonPlay.addActionListener(e -> {
            /* Close mainMenu visible and start PlayGUI in new thread */
            MainGUI.this.jFrame.setVisible(false);
            Setting.setWaitThreadMainMenu(true);
            Executors.newSingleThreadExecutor().execute(new PlayGUI(jFrame));
        });
        pane.add(jButtonPlay, gridBagConstraints);


        /* Button "SETTING" */
        gridBagConstraints.gridy = 2;
        jButtonSetting.addActionListener(e -> {
            /* Start SettingGUI in new thread */
            Executors.newSingleThreadExecutor().execute(new SettingGUI());
        });
        pane.add(jButtonSetting, gridBagConstraints);


        /* Button "INFO" */
        gridBagConstraints.gridy = 3;
        jButtonInfo.addActionListener(e -> {
            /* Start InfoGUI in new thread */
            Executors.newSingleThreadExecutor().execute(new InfoGUI());
        });
        pane.add(jButtonInfo, gridBagConstraints);


        /* Button "EXIT" */
        gridBagConstraints.gridy = 4;
        jButtonExit.addActionListener(e -> {
            /* Close mainMenu visible */
            MainGUI.this.jFrame.setVisible(false);
            /* Start ExitGUI in new thread */
            Executors.newSingleThreadExecutor().execute((new ExitGUI()));
        });
        pane.add(jButtonExit, gridBagConstraints);


        /* Label */
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new Insets(0, 60, -100, 0);
        pane.add(jLabelAuthor, gridBagConstraints);
        /* Start thread that every 10ms change the color of the label */
        Executors.newSingleThreadExecutor().execute(() -> {
            try {
                ColorChange.changeColorOfLabel(jLabelAuthor);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        /* Set size and locations of the window, and start it */
        if (Setting.isFullScreenMainMenu()) {
            jFrame.setExtendedState(Frame.MAXIMIZED_BOTH); // Max size of the window
        } else {
            jFrame.setPreferredSize(new Dimension(Setting.getMainMenuWidth(), Setting.getMainMenuHeight()));
            jFrame.setLocationRelativeTo(null); // The center of the screen
        }
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
