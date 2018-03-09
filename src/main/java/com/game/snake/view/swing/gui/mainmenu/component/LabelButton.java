package com.game.snake.view.swing.gui.mainmenu.component;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class LabelButton implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelButton;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuButton.gif");

    public LabelButton(@NonNull final Container container,
                       @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        gridBagConstraints.gridy++;
        gridBagConstraints.insets = new Insets(0, 90, 0, 0);
        container.add(jLabelButton, gridBagConstraints);
    }

    @Override
    public void setAction() {
        /* Do nothing */
    }

    private void loadResource() {
        if (jLabelButton == null) {
            jLabelButton = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }
}
