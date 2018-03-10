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
public class ComponentBottomRight implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelBottomRight;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuBottomRight.gif");

    public ComponentBottomRight(@NonNull final Container container,
                                @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setGridBagConstraints();
        container.add(jLabelBottomRight, gridBagConstraints);
    }

    @Override
    public void setAction() {
        /* Do nothing */
    }

    private void loadResource() {
        if (jLabelBottomRight == null) {
            jLabelBottomRight = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setGridBagConstraints() {
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
    }
}
