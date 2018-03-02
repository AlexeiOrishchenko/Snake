package com.game.snake.view.gui.mainmenu.components;

import com.game.snake.view.graphics.ChangeColor;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class LabelWelcome implements MainMenuComponent{

    private final JLabel jLabelWelcome = new JLabel();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("Welcome to the game \"SNAKE\"");

    public LabelWelcome(@NonNull final Container container,
                        @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jLabelWelcome.setText(text);
        gridBagConstraints.gridy++;
        gridBagConstraints.insets = new Insets(0, 0, 50, 0);
        container.add(jLabelWelcome, gridBagConstraints);
    }

    @Override
    public void setAction() {
        val executor = Executors.newSingleThreadExecutor();
        executor.execute(new ChangeColor(jLabelWelcome));
        executor.shutdown();
    }
}
