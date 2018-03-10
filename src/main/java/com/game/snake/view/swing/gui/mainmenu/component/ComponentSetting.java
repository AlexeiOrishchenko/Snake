package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.setting.SettingGUI;

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
public class ComponentSetting implements MainMenuComponent {

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    private JLabel jLabelSetting;

    @Getter @Setter private String resourceName = String.valueOf("/MainMenuSetting.gif");

    @Getter @Setter private int componentWidth = 350;
    @Getter @Setter private int componentHeight = 80;

    public ComponentSetting(@NonNull final Container container,
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
        jLabelSetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    val settingGUI = SettingGUI.getInstance();
                    if (!settingGUI.isInitialized()) {
                        val executor = Executors.newSingleThreadExecutor();
                        executor.execute(settingGUI);
                        executor.shutdown();
                    } else {
                        settingGUI.onVisible();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                jLabelSetting.setBackground(Color.GREEN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jLabelSetting.setBackground(new Color(238,238,238));
            }
        });

    }

    private void loadResource() {
        if (jLabelSetting == null) {
            jLabelSetting = new JLabel(new ImageIcon(getClass().getResource(resourceName)));
        }
    }

    private void setJComponentSize() {
        jLabelSetting.setPreferredSize(new Dimension(
                componentWidth,
                componentHeight
        ));
        jLabelSetting.setMinimumSize(new Dimension(
                componentWidth,
                componentHeight
        ));
    }

    private void setJComponentOpaque() {
        jLabelSetting.setFocusable(false);
        jLabelSetting.setOpaque(true);
    }

    private void setGridBagConstraints() {
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
    }

    private void addToContainer() {
        container.add(jLabelSetting, gridBagConstraints);
    }
}
