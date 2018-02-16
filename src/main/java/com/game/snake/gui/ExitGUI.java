package com.game.snake.gui;

import com.game.snake.graphics.ChangeColor;
import com.game.snake.setting.Setting;

import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public final class ExitGUI extends JFrame implements Runnable {

    private final Setting setting = Setting.getInstance();

    private final Container pane = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    ExitGUI() {
        setTitle(setting.getExitGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        initJLabel();
        initJFrame();
        sleep();
        exit();
    }

    private void initJLabel() {
        final List<JLabel> exitGUILabelList = setting.getExitGUIJLabelList();

        exitGUILabelList.forEach(exitGUILabel -> {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            pane.add(exitGUILabel, gridBagConstraints);
            if (setting.isChangeColor()) {
                Executors.newCachedThreadPool().execute(new ChangeColor(exitGUILabel)); // FIXME: shutdown
            }
        });
    }

    private void initJFrame() {
        setPreferredSize(new Dimension(setting.getExitGUIWidth(), setting.getExitGUIHeight()));
        setLocationRelativeTo(null); /* The center of the screen */
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void sleep() {
        try {
            Thread.sleep(setting.getExitGUISleepTimeMS());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Contract(" -> fail")
    private void exit() {
        System.exit(0);
    }
}
