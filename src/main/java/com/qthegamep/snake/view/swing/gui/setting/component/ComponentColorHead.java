package com.qthegamep.snake.view.swing.gui.setting.component;

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
public class ComponentColorHead extends ComponentAbstract {

    private final List<JRadioButton> jRadioButtonColorHeadList = createColorList();

    @Getter @Setter private String text = String.valueOf("Color of the head: ");

    public ComponentColorHead(@NonNull final Container container,
                              @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val colorHeadLabel = new JLabel(text);
        val colorHeadGroup = new ButtonGroup();

        setJComponentPlace(colorHeadLabel);
        setJRadioButtonPlace(colorHeadGroup, jRadioButtonColorHeadList);
        jRadioButtonColorHeadList.get(5).setSelected(true); /* Default Snake color : BLACK TODO: do auto select */
    }

    @Override
    public void update() {
        for (JRadioButton colorHead : jRadioButtonColorHeadList) {
            if (colorHead.isSelected()) {
                try {
                    val field = Color.class.getField(colorHead.getText());
                    setting.setColorHead((Color) field.get(null));
                } catch (NoSuchFieldException | IllegalAccessException err) {
                    err.printStackTrace();
                }
                break;
            }
        }
    }
}
