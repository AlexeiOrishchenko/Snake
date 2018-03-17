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
 * @version 1.15
 */
public class ComponentColorMouse extends ComponentAbstract {

    private final List<JRadioButton> jRadioButtonColorMouseList = createColorList();

    @Getter @Setter private String text = String.valueOf("Color of the mouse: ");

    public ComponentColorMouse(@NonNull final Container container,
                               @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val colorMouseLabel = new JLabel(text);
        val colorMouseGroup = new ButtonGroup();

        setJComponentPlace(colorMouseLabel);
        setJRadioButtonPlace(colorMouseGroup, jRadioButtonColorMouseList);
        jRadioButtonColorMouseList.get(4).setSelected(true); /* Default Mouse color : GRAY TODO: do auto select */
    }

    @Override
    public void update() {
        for (JRadioButton colorMouse : jRadioButtonColorMouseList) {
            if (colorMouse.isSelected()) {
                try {
                    val field = Color.class.getField(colorMouse.getText());
                    setting.setColorMouse((Color) field.get(null));
                } catch (NoSuchFieldException | IllegalAccessException err) {
                    err.printStackTrace();
                }
                break;
            }
        }
    }
}
