package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.exit.ExitGUI;
import com.game.snake.view.swing.gui.mainmenu.MainMenuGUI;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class LabelExit implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelExit;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuExit.gif");

    @Getter @Setter private int componentWidth = 350;
    @Getter @Setter private int componentHeight = 80;

    public LabelExit(@NonNull final Container container,
                     @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setJButtonSize();
        jLabelExit.setFocusable(false);
        jLabelExit.setOpaque(true);
        gridBagConstraints.gridy++;
        container.add(jLabelExit, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jLabelExit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    val exitGUI = ExitGUI.getInstance();
                    if (!exitGUI.isInitialized()) {
                        MainMenuGUI.getInstance().offVisible();
                        val executor = Executors.newSingleThreadExecutor();
                        executor.execute(exitGUI);
                        executor.shutdown();
                    } else {
                        exitGUI.onVisible();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jLabelExit.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jLabelExit.setBackground(new Color(238,238,238));
            }
        });
    }

    private void loadResource() {
        if (jLabelExit == null) {
            jLabelExit= new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setJButtonSize() {
        jLabelExit.setPreferredSize(new Dimension(
                componentWidth,
                componentHeight
        ));
        jLabelExit.setMinimumSize(new Dimension(
                componentWidth,
                componentHeight
        ));
    }
}
