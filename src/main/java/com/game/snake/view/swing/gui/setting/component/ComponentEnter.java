package com.game.snake.view.swing.gui.setting.component;

import lombok.NonNull;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public class ComponentEnter extends AbstractComponent {

    private final JFrame jFrame;

    private final List<ComponentSetting> componentSettingList;

    private final String text = String.valueOf("Enter");

    public ComponentEnter(@NonNull final JFrame jFrame,
                          @NonNull final Container container,
                          @NonNull final GridBagConstraints gridBagConstraints,
                          @NonNull final List<ComponentSetting> componentSettingList) {
        super(container, gridBagConstraints);
        this.jFrame = jFrame;
        this.componentSettingList = componentSettingList;
    }

    @Override
    public void init() {
        val jButtonEnter = new JButton(text);

        setJComponentPlace(jButtonEnter);

        jButtonEnter.setFocusable(false);

        jButtonEnter.addActionListener(e -> {
            componentSettingList.forEach(ComponentSetting::update);
            jFrame.dispose();
        });
    }

    @Override
    public void update() {
        /* Do nothing */
    }
}
