package com.game.snake.view.swing.gui.setting.component;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public class ComponentSizeOfGame extends AbstractComponent {

    private final List<JRadioButton> sizeOfGameForSelectList = new ArrayList<>(Arrays.asList(
            new JRadioButton("10"),
            new JRadioButton("15"),
            new JRadioButton("20")
    ));

    @Getter @Setter private String text = String.valueOf("Size of the game: ");

    public ComponentSizeOfGame(@NonNull final Container container,
                               @NonNull final GridBagConstraints gridBagConstraints) {
        super(container, gridBagConstraints);
    }

    @Override
    public void init() {
        val sizeOfGameLabel = new JLabel(text);
        val sizeOfGameGroup = new ButtonGroup();

        setJComponentPlace(sizeOfGameLabel);
        setJRadioButtonPlace(sizeOfGameGroup, sizeOfGameForSelectList);
        setVisibleJRadioButton(sizeOfGameForSelectList,  setting.getSizeOfGame() + "");
    }

    @Override
    public void update() {
        setting.setSizeOfGame(sizeOfGameForSelectList.stream() // FIXME: DELEGATE TO CONTROLLER
                .filter(AbstractButton::isSelected)
                .findFirst()
                .map(JRadioButton::getText)
                .map(Integer::parseInt)
                .orElse(15));
    }
}
