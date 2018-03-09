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
 * @version 1.14
 */
public class MainMenuGUI implements Runnable {

    private static volatile MainMenuGUI instance;

    private final JFrame jFrame = new JFrame();

    private final Container container = jFrame.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    @Getter @Setter private LabelTop labelTop = new LabelTop(container, gridBagConstraints);
    @Getter @Setter private ButtonPlay buttonPlay = new ButtonPlay(container, gridBagConstraints);
    @Getter @Setter private ButtonSetting buttonSetting = new ButtonSetting(container, gridBagConstraints);
    @Getter @Setter private ButtonInfo buttonInfo = new ButtonInfo(container, gridBagConstraints);
    @Getter @Setter private ButtonExit buttonExit = new ButtonExit(container, gridBagConstraints);
    @Getter @Setter private LabelButton labelButton =  new LabelButton(container, gridBagConstraints);

    @Getter @Setter private String titleName = String.valueOf("Snake - MAIN MENU");

    @Getter @Setter private int minWidth = 800;
    @Getter @Setter private int minHeight = 600;

    private MainMenuGUI() {
        container.setLayout(new GridBagLayout());
        gridBagConstraints.gridx = 1;
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
        val mainMenuComponentList = loadMainMenuComponentList();

        mainMenuComponentList.forEach(mainMenuComponent -> {
            mainMenuComponent.init();
            mainMenuComponent.setAction();
        });

        initJFrame();
    }

    @NotNull
    private List<MainMenuComponent> loadMainMenuComponentList() {
        return new ArrayList<>(Arrays.asList(
                labelTop,
                buttonPlay,
                buttonSetting,
                buttonInfo,
                buttonExit,
                labelButton
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
