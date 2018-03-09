package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.info.InfoGUI;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class ButtonInfo implements MainMenuComponent {

    private final JButton jButtonInfo = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("INFO");

    @Getter @Setter private int buttonWidth = 150;
    @Getter @Setter private int buttonHeight = 150;

    public ButtonInfo(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jButtonInfo.setText(text);
        jButtonInfo.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButtonInfo.setMinimumSize(new Dimension(buttonWidth, buttonHeight));
        gridBagConstraints.gridy++;
        container.add(jButtonInfo, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jButtonInfo.addActionListener(e -> {
            val infoGUI = InfoGUI.getInstance();
            if (!infoGUI.isInitialized()) {
                val executor = Executors.newSingleThreadExecutor();
                executor.execute(infoGUI);
                executor.shutdown();
            } else {
                infoGUI.onVisible();
            }
        });
    }
}
