package com.game.snake.view.gui.setting.component;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class RadioButtonRoomHeight extends AbstractComponent {

    private final List<JRadioButton> jRadioButtonRoomHeightList = createSizeList();

    @Getter @Setter private String text = String.valueOf("Room height: ");

    public RadioButtonRoomHeight(@NonNull final Container container,
                                 @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val roomHeightLabel = new JLabel(text);
        val roomHeightGroup = new ButtonGroup();

        setJComponentPlace(roomHeightLabel);
        setJRadioButtonPlace(roomHeightGroup, jRadioButtonRoomHeightList);
        setVisibleJRadioButton(jRadioButtonRoomHeightList, setting.getRoomHeight() + "");
    }

    @Override
    public void update() {
        setting.setRoomHeight(jRadioButtonRoomHeightList.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(20));
    }
}
