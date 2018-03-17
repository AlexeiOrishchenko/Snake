package com.game.snake.view.swing.gui.mainmenu;

import com.game.snake.view.swing.gui.mainmenu.component.*;

import lombok.Getter;
import lombok.Setter;
import lombok.val;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public class MainMenuGUI implements Runnable {

    private static volatile MainMenuGUI instance;

    private final JFrame jFrame = new JFrame();

    private final Container container = jFrame.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    @Getter @Setter private ComponentTopLeft componentTopLeft = new ComponentTopLeft(container, gridBagConstraints);
    @Getter @Setter private ComponentTopRight componentTopRight = new ComponentTopRight(container, gridBagConstraints);
    @Getter @Setter private ComponentBottomRight componentBottomRight =  new ComponentBottomRight(container, gridBagConstraints);
    @Getter @Setter private ComponentPlay componentPlay = new ComponentPlay(container, gridBagConstraints);
    @Getter @Setter private ComponentSetting componentSetting = new ComponentSetting(container, gridBagConstraints);
    @Getter @Setter private ComponentInfo componentInfo = new ComponentInfo(container, gridBagConstraints);
    @Getter @Setter private ComponentExit componentExit = new ComponentExit(container, gridBagConstraints);

    @Getter @Setter private String titleName = String.valueOf("Snake - MAIN MENU");

    @Getter @Setter private int minWidth = 1000;
    @Getter @Setter private int minHeight = 750;

    private MainMenuGUI() {
        container.setLayout(new GridBagLayout());
    }

    public static MainMenuGUI getInstance() {
        if (MainMenuGUI.instance == null) {
            synchronized (MainMenuGUI.class) {
                if (MainMenuGUI.instance == null) {
                    MainMenuGUI.instance = new MainMenuGUI();
                }
            }
        }
        return MainMenuGUI.instance;
    }

    public void onVisible() {
        jFrame.setVisible(true);
    }

    public void offVisible() {
        jFrame.dispose();
    }

    @Override
    public void run() {
        val componentMainMenuList = loadComponentMainMenuList();

        componentMainMenuList.forEach(componentMainMenu -> {
            componentMainMenu.init();
            componentMainMenu.setAction();
        });

        initJFrame();
    }

    @NotNull
    private List<ComponentMainMenu> loadComponentMainMenuList() {
        return new ArrayList<>(Arrays.asList(
                componentTopLeft,
                componentTopRight,
                componentBottomRight,
                componentPlay,
                componentSetting,
                componentInfo,
                componentExit
        ));
    }

    private void initJFrame() {
        jFrame.setTitle(titleName);
        setJFrameSize();
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setLocationRelativeTo(null); /* Set the center of the screen */
        jFrame.setVisible(true);
    }

    private void setJFrameSize() {
        jFrame.setMinimumSize(new Dimension(
                minWidth,
                minHeight
        ));
        jFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
    }
}
