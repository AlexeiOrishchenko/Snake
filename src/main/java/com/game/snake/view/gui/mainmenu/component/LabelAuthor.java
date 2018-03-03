package com.game.snake.view.gui.mainmenu.component;

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
public class LabelAuthor implements MainMenuComponent {

    private final JLabel jLabelAuthor = new JLabel();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("Author: Koliadin Nikita");

    public LabelAuthor(@NonNull final Container container,
                       @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jLabelAuthor.setText(text);
        gridBagConstraints.gridy++;
        gridBagConstraints.insets = new Insets(50, 60, 0, 0);
        container.add(jLabelAuthor, gridBagConstraints);
    }

    @Override
    public void setAction() {
        val executor = Executors.newSingleThreadExecutor();
        executor.execute(new ChangeColor(jLabelAuthor));
        executor.shutdown();
    }
}
