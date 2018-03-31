package com.game.snake.view.swing.gui.setting.component;

import com.game.snake.model.Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class ComponentRoomHeight extends ComponentAbstract {

    private final List<JRadioButton> jRadioButtonRoomHeightList = createSizeList();

    @Getter @Setter private String text = String.valueOf("Room height: ");

    public ComponentRoomHeight(@NonNull final Container container,
                               @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val roomHeightLabel = new JLabel(text);
        val roomHeightGroup = new ButtonGroup();

        setJComponentPlace(roomHeightLabel);
        setJRadioButtonPlace(roomHeightGroup, jRadioButtonRoomHeightList);
        setVisibleJRadioButton(jRadioButtonRoomHeightList, Model.getInstance().getRoomHeight() + "");
    }

    @Override
    public void update() {
        Model.getInstance().setRoomHeight(jRadioButtonRoomHeightList.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(20));
    }
}
