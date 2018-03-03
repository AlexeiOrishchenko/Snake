package com.game.snake.view.gui.setting.component;

import com.game.snake.setting.Setting;

import lombok.NonNull;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public abstract class AbstractComponent implements SettingComponent {

    final Setting setting = Setting.getInstance();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    AbstractComponent(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    void setJComponentPlace(@NonNull final JComponent jComponent) {
        gridBagConstraints.gridy++;
        container.add(jComponent, gridBagConstraints);
    }

    void setJRadioButtonPlace(@NonNull final ButtonGroup buttonGroup,
                              @NonNull final List<JRadioButton> jRadioButtonList) {

        jRadioButtonList.forEach(buttonGroup::add);

        gridBagConstraints.gridx = 1;
        jRadioButtonList.forEach(jRadioButton -> {
            gridBagConstraints.gridx++;
            container.add(jRadioButton, gridBagConstraints);
            jRadioButton.setFocusable(false);
        });
        gridBagConstraints.gridx = 0;
    }

    void setVisibleJRadioButton(@NonNull final List<JRadioButton> jRadioButtonList,
                                @NonNull final String value) {

        jRadioButtonList.stream()
                .filter(jRadioButton -> jRadioButton.getText().equals(value))
                .findFirst()
                .ifPresent(jRadioButton -> jRadioButton.setSelected(true));
    }

    @NotNull
    @Contract(pure = true)
    ArrayList<JRadioButton> createSizeList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton(setting.getSizeListValue1()),
                new JRadioButton(setting.getSizeListValue2()),
                new JRadioButton(setting.getSizeListValue3()),
                new JRadioButton(setting.getSizeListValue4()),
                new JRadioButton(setting.getSizeListValue5())
        ));
    }

    @NotNull
    ArrayList<JRadioButton> createTrueFalseList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton("true"),
                new JRadioButton("false")
        ));
    }

    @NotNull
    List<JRadioButton> createColorList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton(setting.getColor1()),
                new JRadioButton(setting.getColor2()),
                new JRadioButton(setting.getColor3()),
                new JRadioButton(setting.getColor4()),
                new JRadioButton(setting.getColor5()),
                new JRadioButton(setting.getColor6())
        ));
    }
}
