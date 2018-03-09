package com.game.snake.view.swing.gui.mainmenu.component;

import com.game.snake.view.swing.gui.exit.ExitGUI;
import com.game.snake.view.swing.gui.mainmenu.MainMenuGUI;

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
public class ButtonExit implements MainMenuComponent {

    private final JButton jButtonExit = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("EXIT");

    @Getter @Setter private int buttonWidth = 150;
    @Getter @Setter private int buttonHeight = 25;

    public ButtonExit(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
    }

    @Override
    public void init() {
        jButtonExit.setText(text);
        jButtonExit.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        jButtonExit.setMinimumSize(new Dimension(buttonWidth, buttonHeight));
        gridBagConstraints.gridy++;
        container.add(jButtonExit, gridBagConstraints);
    }

    @Override
    public void setAction() {
        jButtonExit.addActionListener(e -> {
            val exitGUI = ExitGUI.getInstance();
            if (!exitGUI.isInitialized()) {
                MainMenuGUI.getInstance().offVisible();
                val executor = Executors.newSingleThreadExecutor();
                executor.execute(exitGUI);
                executor.shutdown();
            } else {
                exitGUI.onVisible();
            }
        });
    }
}
