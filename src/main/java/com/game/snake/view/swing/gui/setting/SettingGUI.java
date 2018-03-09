package com.game.snake.view.swing.gui.setting;

import com.game.snake.view.swing.gui.setting.component.*;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public final class SettingGUI implements Runnable {

    private static volatile SettingGUI instance;

    private final JFrame jFrame = new JFrame();

    private final Container container = jFrame.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    @Getter @Setter private RadioButtonColorHead radioButtonColorHead = new RadioButtonColorHead(container, gridBagConstraints);
    @Getter @Setter private RadioButtonColorSnake radioButtonColorSnake = new RadioButtonColorSnake(container, gridBagConstraints);
    @Getter @Setter private RadioButtonColorMouse radioButtonColorMouse = new RadioButtonColorMouse(container, gridBagConstraints);
    @Getter @Setter private RadioButtonColorFace radioButtonColorFace = new RadioButtonColorFace(container, gridBagConstraints);
    @Getter @Setter private RadioButtonChangeColor radioButtonChangeColor = new RadioButtonChangeColor(container, gridBagConstraints);
    @Getter @Setter private RadioButtonSizeOfGame radioButtonSizeOfGame = new RadioButtonSizeOfGame(container, gridBagConstraints);
    @Getter @Setter private RadioButtonRoomWidth radioButtonRoomWidth = new RadioButtonRoomWidth(container, gridBagConstraints);
    @Getter @Setter private RadioButtonRoomHeight radioButtonRoomHeight = new RadioButtonRoomHeight(container, gridBagConstraints);

    @Getter @Setter private String titleName = String.valueOf("Snake - SETTING");

    @Getter @Setter private int minWidth = 550;
    @Getter @Setter private int minHeight = 300;

    @Getter private boolean initialized = false;

    private SettingGUI() {
        container.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    public static SettingGUI getInstance() {
        if (SettingGUI.instance == null) {
            synchronized (SettingGUI.class) {
                if (SettingGUI.instance == null) {
                    SettingGUI.instance = new SettingGUI();
                }
            }
        }
        return SettingGUI.instance;
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    @Override
    public void run() {
        val settingComponentList = loadSettingComponentList();
        settingComponentList.forEach(SettingComponent::init);
        new ButtonEnter(jFrame, container, gridBagConstraints, settingComponentList).init();
        initJFrame();
    }

    @NotNull
    private List<SettingComponent> loadSettingComponentList() {
        return new ArrayList<>(Arrays.asList(
                radioButtonColorHead,
                radioButtonColorSnake,
                radioButtonColorMouse,
                radioButtonColorFace,
                radioButtonChangeColor,
                radioButtonSizeOfGame,
                radioButtonRoomWidth,
                radioButtonRoomHeight
        ));
    }

    private void initJFrame() {
        jFrame.setTitle(titleName);
        setJFrameSize();
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); /* Set the center of the screen */
        setJFrameKeyEvent();
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jFrame.setVisible(true);
        initialized = true;
    }

    private void setJFrameSize() {
        jFrame.setMinimumSize(new Dimension(
                minWidth,
                minHeight
        ));
    }

    private void setJFrameKeyEvent() {
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(final KeyEvent e) {
                /* Do nothing */
            }

            @Override
            public void keyPressed(final KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.dispose();
                }
            }

            @Override
            public void keyReleased(final KeyEvent e) {
                /* Do nothing */
            }
        });
    }
}
