package com.game.snake.gui;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;

public class SettingGUI extends JFrame implements Runnable {

    public SettingGUI() {
        super(Setting.getSettingJFrameTitle());
    }

    @Override
    public void run() {
        Container pane = this.getContentPane();
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        // FIXME: 28.01.2018

        setPreferredSize(new Dimension(Setting.getSettingWidth(), Setting.getSettingHeight()));
        setLocationRelativeTo(null); // the center of the screen
        pack();
        setVisible(true);
    }
}
