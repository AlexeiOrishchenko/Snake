package com.game.snake.view.gui.mainmenu.component;

import com.game.snake.view.gui.exit.ExitGUI;

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
public class ButtonExit implements MainMenuComponent {

    private final JFrame jFrame;

    private final JButton buttonExit = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("EXIT");

    public ButtonExit(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints,
                      @NonNull final JFrame jFrame) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
        this.jFrame = jFrame;
    }

    @Override
    public void init() {
        buttonExit.setText(text);
        gridBagConstraints.gridy++;
        container.add(buttonExit, gridBagConstraints);
    }

    @Override
    public void setAction() {
        buttonExit.addActionListener(e -> {
            val exitGUI = ExitGUI.getInstance();
            if (!exitGUI.isInitialized()) {
                jFrame.setVisible(false);
                val executor = Executors.newSingleThreadExecutor();
                executor.execute(exitGUI);
                executor.shutdown();
            } else {
                exitGUI.onVisible();
            }
        });
    }
}
