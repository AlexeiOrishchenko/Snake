package com.game.snake.view.swing.gui.mainmenu.component;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class ComponentTopLeft implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelTopLeft;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuTopLeft.gif");

    public ComponentTopLeft(@NonNull final Container container,
                            @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setGridBagConstraints();
        container.add(jLabelTopLeft, gridBagConstraints);
    }

    @Override
    public void setAction() {
        /* Do nothing */
    }

    private void loadResource() {
        if (jLabelTopLeft == null) {
            jLabelTopLeft = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setGridBagConstraints() {
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
    }
}
