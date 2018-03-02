package com.game.snake.view.gui.mainmenu.components;

import com.game.snake.view.gui.info.InfoGUI;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class ButtonInfo implements MainMenuComponent {

    private final JButton jButtonInfo = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("INFO");

    public ButtonInfo(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jButtonInfo.setText(text);
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
