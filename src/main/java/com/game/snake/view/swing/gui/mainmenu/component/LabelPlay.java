package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.controller.Controller;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class LabelPlay implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelPlay;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuPlay.gif");

    @Getter @Setter private int componentWidth = 350;
    @Getter @Setter private int componentHeight = 80;

    public LabelPlay(@NonNull final Container container,
                     @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setJComponentSize();
        jLabelPlay.setFocusable(false);
        jLabelPlay.setOpaque(true);
        gridBagConstraints.gridy++;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        container.add(jLabelPlay, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jLabelPlay.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    Controller.getInstance().startGame();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jLabelPlay.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jLabelPlay.setBackground(new Color(238,238,238));
            }
        });
    }

    private void loadResource() {
        if (jLabelPlay == null) {
            jLabelPlay = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setJComponentSize() {
        jLabelPlay.setPreferredSize(new Dimension(
                componentWidth,
                componentHeight
        ));
        jLabelPlay.setMinimumSize(new Dimension(
                componentWidth,
                componentHeight
        ));
    }
}
