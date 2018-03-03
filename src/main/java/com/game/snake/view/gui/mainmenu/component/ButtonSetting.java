package com.game.snake.view.gui.mainmenu.component;

import com.game.snake.view.gui.setting.SettingGUI;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class ButtonSetting implements MainMenuComponent {

    private final JButton buttonSetting = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("SETTING");

    public ButtonSetting(@NonNull final Container container,
                         @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        buttonSetting.setText(text);
        gridBagConstraints.gridy++;
        container.add(buttonSetting, gridBagConstraints);
    }

    @Override
    public void setAction() {
        buttonSetting.addActionListener(e -> {
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
}
