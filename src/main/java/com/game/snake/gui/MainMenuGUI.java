package com.game.snake.gui;

import com.game.snake.graphics.ChangeColor;
import com.game.snake.objects.room.Room;
import com.game.snake.setting.Setting;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public class MainMenuGUI implements Runnable {

    private final Setting setting = Setting.getInstance();
    private final JFrame jFrameMainMenu = new JFrame(); // FIXME: 13.02.2018
    private final Container pane = jFrameMainMenu.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private SettingGUI settingGUI;

    public MainMenuGUI() {
        jFrameMainMenu.setTitle(setting.getMainMenuGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }


    @Override
    public void run() {
        final List<ButtonMainMenuGUI> buttonMainMenuGUIList = loadButtonMainMenuGUIList();

        for (ButtonMainMenuGUI buttonMainMenuGUI : buttonMainMenuGUIList) {
            buttonMainMenuGUI.set();
            buttonMainMenuGUI.action();
        }

        setJFrame();
    }

    @NotNull
    private List<ButtonMainMenuGUI> loadButtonMainMenuGUIList() {
        return new ArrayList<ButtonMainMenuGUI>(Arrays.asList(
                new LabelWelcome(),
                new ButtonPlay(),
                new ButtonSetting(),
                new ButtonInfo(),
                new ButtonExit(),
                new LabelAuthor()
        ));
    }

    private void setJFrame() {
        if (setting.isMainMenuFullScreen()) {
            jFrameMainMenu.setExtendedState(Frame.MAXIMIZED_BOTH);
        } else {
            jFrameMainMenu.setPreferredSize(new Dimension(setting.getMainMenuWidth(), setting.getMainMenuHeight()));
            jFrameMainMenu.setLocationRelativeTo(null); /* The center of the screen */
        }
        jFrameMainMenu.setDefaultCloseOperation(jFrameMainMenu.EXIT_ON_CLOSE);
        jFrameMainMenu.pack();
        jFrameMainMenu.setVisible(true);
    }

    private interface ButtonMainMenuGUI {
        void set();
        void action();
    }

    private class LabelWelcome implements ButtonMainMenuGUI {

        private final JLabel jLabelWelcome = new JLabel(setting.getMainMenuGUIJLabelWelcome());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(-100, 0, 25, 0);
            pane.add(jLabelWelcome, gridBagConstraints);
        }

        @Override
        public void action() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(jLabelWelcome)); // FIXME: 13.02.2018
        }
    }

    private class ButtonPlay implements ButtonMainMenuGUI {

        private final JButton jButtonPlay = new JButton(setting.getMainMenuGUIJButtonPlay());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            pane.add(jButtonPlay, gridBagConstraints);
        }

        @Override
        public void action() {
            jButtonPlay.addActionListener(e -> {
                jFrameMainMenu.setVisible(false);
                setting.setMainMenuWaitThread(true);
                Room.room = new Room(jFrameMainMenu);
                Executors.newSingleThreadExecutor().execute(Room.room); // FIXME: 13.02.2018
            });
        }
    }

    private class ButtonSetting implements ButtonMainMenuGUI {

        private final JButton jButtonSetting = new JButton(setting.getMainMenuGUIJButtonSetting());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(jButtonSetting, gridBagConstraints);
        }

        @Override
        public void action() {
            jButtonSetting.addActionListener(e -> {
                if (settingGUI == null) {
                    settingGUI = new SettingGUI();
                    Executors.newSingleThreadExecutor().execute(settingGUI); // FIXME: 13.02.2018
                } else {
                    settingGUI.setVisible(true);
                }
            });
        }
    }

    private class ButtonInfo implements ButtonMainMenuGUI {

        private final JButton jButtonInfo = new JButton(setting.getMainMenuGUIJButtonInfo());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(jButtonInfo, gridBagConstraints);
        }

        @Override
        public void action() {
            jButtonInfo.addActionListener(e -> {
                Executors.newSingleThreadExecutor().execute(new InfoGUI()); // FIXME: 13.02.2018
            });
        }
    }

    private class ButtonExit implements ButtonMainMenuGUI {

        private final JButton jButtonExit = new JButton(setting.getMainMenuGUIJButtonExit());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(jButtonExit, gridBagConstraints);
        }

        @Override
        public void action() {
            jButtonExit.addActionListener(e -> {
                MainMenuGUI.this.jFrameMainMenu.setVisible(false);
                Executors.newSingleThreadExecutor().execute((new ExitGUI())); // FIXME: 13.02.2018
            });
        }
    }

    private class LabelAuthor implements ButtonMainMenuGUI {

        private final JLabel jLabelAuthor = new JLabel(Setting.getAUTHOR());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(0, 60, -100, 0);
            pane.add(jLabelAuthor, gridBagConstraints);
        }

        @Override
        public void action() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(jLabelAuthor)); // FIXME: 13.02.2018
        }
    }
}
