package com.qthegamep.snake.view.swing.gui.setting.component;

import com.qthegamep.snake.model.Model;

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
public class ComponentRoomWidth extends ComponentAbstract {

    private final List<JRadioButton> jRadioButtonRoomWidthList = createSizeList();

    @Getter @Setter private String text = String.valueOf("Room width: ");

    public ComponentRoomWidth(@NonNull final Container container,
                              @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val roomWidthLabel = new JLabel(text);
        val roomWidthGroup = new ButtonGroup();

        setJComponentPlace(roomWidthLabel);
        setJRadioButtonPlace(roomWidthGroup, jRadioButtonRoomWidthList);
        setVisibleJRadioButton(jRadioButtonRoomWidthList, Model.getInstance().getRoomWidth() + "");
    }

    @Override
    public void update() {
        Model.getInstance().setRoomWidth(jRadioButtonRoomWidthList.stream()
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(20));
    }
}
