package com.game.snake.gui;

import com.game.snake.graphics.ChangeColor;
import com.game.snake.setting.Setting;

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

    public ExitGUI() {
        setTitle(setting.getExitGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        setJLabel();
        setJFame();
        sleep();

        System.exit(0);
    }

    private void setJLabel() {
        final List<JLabel> exitGUIJLabelList = setting.getExitGUIJLabelList();

        for (JLabel jLabel : exitGUIJLabelList) {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10,0,0,0);
            pane.add(jLabel, gridBagConstraints);
            if (setting.isChangeColor()) {
                Executors.newCachedThreadPool().execute(new ChangeColor(jLabel));
            }
        }
    }

    private void setJFame() {
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
}
