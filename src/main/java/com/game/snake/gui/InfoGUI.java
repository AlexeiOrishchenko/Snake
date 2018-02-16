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

    private final Container container = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    InfoGUI() throws HeadlessException {
        setTitle(setting.getInfoGUIJFrameTitle());
        container.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        initJLabel();
        initJFrame();
    }

    private void initJLabel() {
        final List<JLabel> infoGUIJLabelList = new ArrayList<>(setting.getInfoGUIJLabelList()); // FIXME: select label

        infoGUIJLabelList.forEach(jLabel -> {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            container.add(jLabel, gridBagConstraints);
        });
    }

    private void initJFrame() {
        setPreferredSize(new Dimension(setting.getInfoGUIWidth(), setting.getInfoGUIHeight()));
        setLocationRelativeTo(null); /* The center of the screen */
        pack();
        setVisible(true);
    }
}
