package com.game.snake.view.gui.mainmenu.component;

import com.game.snake.objects.room.Room;
import com.game.snake.view.graphics.ChangeColor;

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
public class ButtonPlay implements MainMenuComponent {

    private final JFrame jFrame;

    private final JButton buttonPlay = new JButton();

    private final Container container;
    private final GridBagConstraints gridBagConstraints;

    @Getter @Setter private String text = String.valueOf("PLAY");

    public ButtonPlay(@NonNull final Container container,
                      @NonNull final GridBagConstraints gridBagConstraints,
                      @NonNull final JFrame jFrame) {
        this.container = container;
        this.gridBagConstraints = gridBagConstraints;
        this.jFrame = jFrame;
    }

    @Override
    public void init() {
        buttonPlay.setText(text);
        gridBagConstraints.gridy++;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        container.add(buttonPlay, gridBagConstraints);
    }

    @Override
    public void setAction() {
        buttonPlay.addActionListener(e -> {
            jFrame.setVisible(false);
            ChangeColor.setMainMenuWaitThread(true);
            Room.room = new Room(jFrame);
            val executor = Executors.newSingleThreadExecutor();
            executor.execute(Room.room);
            executor.shutdown();
        });
    }
}
