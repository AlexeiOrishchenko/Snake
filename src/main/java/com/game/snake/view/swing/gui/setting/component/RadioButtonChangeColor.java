package com.game.snake.view.swing.gui.setting.component;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class RadioButtonChangeColor extends AbstractComponent {

    private final List<JRadioButton> jRadioButtonChangeColorList = createTrueFalseList();

    @Getter @Setter private String text = String.valueOf("Change color: ");

    public RadioButtonChangeColor(@NonNull final Container container,
                                  @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val changeColorLabel = new JLabel(text);
        val changeColorGroup = new ButtonGroup();

        setJComponentPlace(changeColorLabel);
        setJRadioButtonPlace(changeColorGroup, jRadioButtonChangeColorList);
        setVisibleJRadioButton(jRadioButtonChangeColorList, setting.isChangeColor() + "");
    }

    @Override
    public void update() {
        setting.setChangeColor(jRadioButtonChangeColorList.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Boolean::parseBoolean)
                .orElse(true));
    }
}
