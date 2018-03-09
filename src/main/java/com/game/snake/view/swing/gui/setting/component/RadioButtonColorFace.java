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
public class RadioButtonColorFace extends AbstractComponent {

    private final List<JRadioButton> jRadioButtonColorFaceList = createColorList();

    @Getter @Setter private String text = String.valueOf("Color of the face: ");

    public RadioButtonColorFace(@NonNull final Container container,
                                @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val colorFaceLabel = new JLabel(text);
        val colorFaceGroup = new ButtonGroup();

        setJComponentPlace(colorFaceLabel);
        setJRadioButtonPlace(colorFaceGroup, jRadioButtonColorFaceList);
        jRadioButtonColorFaceList.get(0).setSelected(true); /* Default Face color : RED TODO: do auto select */
    }

    @Override
    public void update() {
        for (JRadioButton colorFace : jRadioButtonColorFaceList) {
            if (colorFace.isSelected()) {
                try {
                    val field = Color.class.getField(colorFace.getText());
                    setting.setColorFace((Color) field.get(null));
                } catch (NoSuchFieldException | IllegalAccessException err) {
                    err.printStackTrace();
                }
                break;
            }
        }
    }
}
