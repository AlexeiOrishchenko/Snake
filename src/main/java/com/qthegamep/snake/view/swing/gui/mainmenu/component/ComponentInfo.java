package com.qthegamep.snake.view.swing.gui.mainmenu.component;

import com.qthegamep.snake.view.swing.gui.info.InfoGUI;

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
 * @version 1.15
 */
public class ComponentInfo implements ComponentMainMenu {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelInfo;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuInfo.gif");

    @Getter @Setter private int componentWidth = 350;
    @Getter @Setter private int componentHeight = 80;

    public ComponentInfo(@NonNull final Container container,
                         @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        loadResource();
        setJComponentSize();
        setJComponentOpaque();
        setGridBagConstraints();
        addToContainer();
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

    private void setJComponentSize() {
        jLabelInfo.setPreferredSize(new Dimension(
                componentWidth,
                componentHeight
        ));
        jLabelInfo.setMinimumSize(new Dimension(
                componentWidth,
                componentHeight
        ));
    }

    private void setJComponentOpaque() {
        jLabelInfo.setFocusable(false);
        jLabelInfo.setOpaque(true);
    }

    private void setGridBagConstraints() {
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
    }

    private void addToContainer() {
        container.add(jLabelInfo, gridBagConstraints);
    }
}
