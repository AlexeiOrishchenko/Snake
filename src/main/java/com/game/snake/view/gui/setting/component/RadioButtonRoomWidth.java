package com.game.snake.view.gui.setting.component;

import com.game.snake.model.objects.room.Room;

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
public class RadioButtonRoomWidth extends AbstractComponent {

    private final List<JRadioButton> jRadioButtonRoomWidthList = createSizeList();

    @Getter @Setter private String text = String.valueOf("Room width: ");

    public RadioButtonRoomWidth(@NonNull final Container container,
                                @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val roomWidthLabel = new JLabel(text);
        val roomWidthGroup = new ButtonGroup();

        setJComponentPlace(roomWidthLabel);
        setJRadioButtonPlace(roomWidthGroup, jRadioButtonRoomWidthList);
        setVisibleJRadioButton(jRadioButtonRoomWidthList, Room.getInstance().getWidth() + ""); // TODO: DELEGATE TO CONTROLLER
    }

    @Override
    public void update() {
        Room.getInstance().setWidth(jRadioButtonRoomWidthList.stream() // FIXME: DELEGATE TO CONTROLLER
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(20));
    }
}
