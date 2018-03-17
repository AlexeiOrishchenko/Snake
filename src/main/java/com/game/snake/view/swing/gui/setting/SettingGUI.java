package com.game.snake.view.swing.gui.setting;

import com.game.snake.view.swing.gui.setting.component.*;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public final class SettingGUI implements Runnable {

    private static volatile SettingGUI instance;

    private final JFrame jFrame = new JFrame();

    private final Container container = jFrame.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    @Getter @Setter private ComponentColorHead componentColorHead = new ComponentColorHead(container, gridBagConstraints);
    @Getter @Setter private ComponentColorSnake componentColorSnake = new ComponentColorSnake(container, gridBagConstraints);
    @Getter @Setter private ComponentColorMouse componentColorMouse = new ComponentColorMouse(container, gridBagConstraints);
    @Getter @Setter private ComponentColorFace componentColorFace = new ComponentColorFace(container, gridBagConstraints);
    @Getter @Setter private ComponentSizeOfGame componentSizeOfGame = new ComponentSizeOfGame(container, gridBagConstraints);
    @Getter @Setter private ComponentRoomWidth componentRoomWidth = new ComponentRoomWidth(container, gridBagConstraints);
    @Getter @Setter private ComponentRoomHeight componentRoomHeight = new ComponentRoomHeight(container, gridBagConstraints);

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
        val componentSettingList = loadComponentSettingList();
        componentSettingList.forEach(ComponentSetting::init);
        new ComponentEnter(jFrame, container, gridBagConstraints, componentSettingList).init();
        initJFrame();
    }

    @NotNull
    private List<ComponentSetting> loadComponentSettingList() {
        return new ArrayList<>(Arrays.asList(
                componentColorHead,
                componentColorSnake,
                componentColorMouse,
                componentColorFace,
                componentSizeOfGame,
                componentRoomWidth,
                componentRoomHeight
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
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    jFrame.dispose();
                }
            }
        });
    }
}
