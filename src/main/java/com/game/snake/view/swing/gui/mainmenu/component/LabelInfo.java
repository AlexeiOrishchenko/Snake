package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.info.InfoGUI;

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
public class LabelInfo implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelInfo;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuInfo.gif");

    @Getter @Setter private int componentWidth = 350;
    @Getter @Setter private int componentHeight = 80;

    public LabelInfo(@NonNull final Container container,
                     @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setJButtonSize();
        jLabelInfo.setFocusable(false);
        jLabelInfo.setOpaque(true);
        gridBagConstraints.gridy++;
        container.add(jLabelInfo, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jLabelInfo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    val infoGUI = InfoGUI.getInstance();
                    if (!infoGUI.isInitialized()) {
                        val executor = Executors.newSingleThreadExecutor();
                        executor.execute(infoGUI);
                        executor.shutdown();
                    } else {
                        infoGUI.onVisible();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jLabelInfo.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jLabelInfo.setBackground(new Color(238,238,238));
            }
        });
    }

    private void loadResource() {
        if (jLabelInfo == null) {
            jLabelInfo = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setJButtonSize() {
        jLabelInfo.setPreferredSize(new Dimension(
                componentWidth,
                componentHeight
        ));
        jLabelInfo.setMinimumSize(new Dimension(
                componentWidth,
                componentHeight
        ));
    }
}
