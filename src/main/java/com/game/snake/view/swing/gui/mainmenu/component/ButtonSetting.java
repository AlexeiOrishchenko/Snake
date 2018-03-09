package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.setting.SettingGUI;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class ButtonSetting implements MainMenuComponent {

    private final JButton jButtonSetting = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("SETTING");

    @Getter @Setter private int buttonWidth = 150;
    @Getter @Setter private int buttonHeight = 25;

    public ButtonSetting(@NonNull final Container container,
                         @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jButtonSetting.setText(text);
        setJButtonSize();
        gridBagConstraints.gridy++;
        container.add(jButtonSetting, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jButtonSetting.addActionListener(e -> {
            val settingGUI = SettingGUI.getInstance();
            if (!settingGUI.isInitialized()) {
                val executor = Executors.newSingleThreadExecutor();
                executor.execute(settingGUI);
                executor.shutdown();
            } else {
                settingGUI.onVisible();
            }
        });
    }

    private void setJButtonSize() {
        jButtonSetting.setPreferredSize(new Dimension(
                buttonWidth,
                buttonHeight
        ));
        jButtonSetting.setMinimumSize(new Dimension(
                buttonWidth,
                buttonHeight
        ));
    }
}
