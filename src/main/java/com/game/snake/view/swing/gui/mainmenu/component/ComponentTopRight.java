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
public class ComponentTopRight implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelTopRight;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuTopRight.gif");

    public ComponentTopRight(@NonNull final Container container,
                             @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setGridBagConstraints();
        addToContainer();
    }

    @Override
    public void setAction() {
        /* Do nothing */
    }

    private void loadResource() {
        if (jLabelTopRight == null) {
            jLabelTopRight = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setGridBagConstraints() {
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
    }

    private void addToContainer() {
        container.add(jLabelTopRight, gridBagConstraints);
    }
}
