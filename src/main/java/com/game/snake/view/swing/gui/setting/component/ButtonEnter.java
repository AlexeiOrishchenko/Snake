package com.game.snake.view.swing.gui.setting.component;

import lombok.NonNull;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class ButtonEnter extends AbstractComponent {

    private final JFrame jFrame;

    private final List<SettingComponent> settingComponentList;

    private final String text = String.valueOf("Enter");

    public ButtonEnter(@NonNull final JFrame jFrame,
                       @NonNull final Container container,
                       @NonNull final GridBagConstraints gridBagConstraints,
                       @NonNull final List<SettingComponent> settingComponentList) {
        super(container, gridBagConstraints);
        this.jFrame = jFrame;
        this.settingComponentList = settingComponentList;
    }

    @Override
    public void init() {
        val jButtonEnter = new JButton(text);

        setJComponentPlace(jButtonEnter);

        jButtonEnter.setFocusable(false);

        jButtonEnter.addActionListener(e -> {
            settingComponentList.forEach(SettingComponent::update);
            jFrame.dispose();
        });
    }

    @Override
    public void update() {
        /* Do nothing */
    }
}
