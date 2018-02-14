package com.game.snake.gui;

import com.game.snake.setting.Setting;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public final class InfoGUI extends JFrame implements Runnable {

    private final Setting setting = Setting.getInstance();

    private final Container pane = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public InfoGUI() throws HeadlessException {
        setTitle(setting.getInfoGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        setJLabel();
        setJFrame();
    }

    private void setJLabel() {
        List<JLabel> infoGUIJLabelList = new ArrayList<>(setting.getInfoGUIJTextFieldList()); // FIXME: 13.02.2018

        infoGUIJLabelList.forEach(jLabel -> {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            pane.add(jLabel, gridBagConstraints);
        });
    }

    private void setJFrame() {
        setPreferredSize(new Dimension(setting.getInfoGUIWidth(), setting.getInfoGUIHeight()));
        setLocationRelativeTo(null); /* The center of the screen */
        pack();
        setVisible(true);
    }
}
