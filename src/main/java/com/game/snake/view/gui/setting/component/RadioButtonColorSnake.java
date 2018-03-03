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
public class RadioButtonColorSnake extends AbstractComponent {

    private final List<JRadioButton> jRadioButtonColorSnakeList = createColorList();

    @Getter @Setter private String text = String.valueOf("Color of the snake: ");

    public RadioButtonColorSnake(@NonNull final Container container,
                                 @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val colorSnakeLabel = new JLabel(text);
        val colorSnakeGroup = new ButtonGroup();

        setJComponentPlace(colorSnakeLabel);
        setJRadioButtonPlace(colorSnakeGroup, jRadioButtonColorSnakeList);
        jRadioButtonColorSnakeList.get(1).setSelected(true); /* Default Snake color : GREEN TODO: do auto select */
    }

    @Override
    public void update() {
        for (JRadioButton colorSnake : jRadioButtonColorSnakeList) {
            if (colorSnake.isSelected()) {
                try {
                    val field = Color.class.getField(colorSnake.getText());
                    setting.setColorSnake((Color) field.get(null));
                } catch (NoSuchFieldException | IllegalAccessException err) {
                    err.printStackTrace();
                }
                break;
            }
        }
    }
}
