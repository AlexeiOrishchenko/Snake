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
        setVisibleJRadioButton(jRadioButtonRoomHeightList, Room.getInstance().getHeight() + ""); // TODO: DELEGATE TO CONTROLLER
    }

    @Override
    public void update() {
        Room.getInstance().setHeight(jRadioButtonRoomHeightList.stream() // FIXME: DELEGATE TO CONTROLLER
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(20));
    }
}
