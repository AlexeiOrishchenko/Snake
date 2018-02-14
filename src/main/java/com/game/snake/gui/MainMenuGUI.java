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
public class MainMenuGUI extends JFrame implements Runnable {

    private final Setting setting = Setting.getInstance();

    private final Container pane = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private SettingGUI settingGUI;

    public MainMenuGUI() {
        setTitle(setting.getMainMenuGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        final List<ComponentMainMenuGUI> componentMainMenuGUIList = loadComponentMainMenuGUIList();

        componentMainMenuGUIList.forEach(componentMainMenuGUI -> {
            componentMainMenuGUI.set();
            componentMainMenuGUI.action();
        });

        setJFrame();
    }

    @NotNull
    private List<ComponentMainMenuGUI> loadComponentMainMenuGUIList() {
        return new ArrayList<>(Arrays.asList(
                new LabelWelcome(),
                new ButtonPlay(),
                new ButtonSetting(),
                new ButtonInfo(),
                new ButtonExit(),
                new LabelAuthor()
        ));
    }

    private void setJFrame() {
        setFullScreen();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void setFullScreen() {
        if (setting.isMainMenuFullScreen()) {
            setExtendedState(Frame.MAXIMIZED_BOTH);
        } else {
            setPreferredSize(new Dimension(setting.getMainMenuWidth(), setting.getMainMenuHeight()));
            setLocationRelativeTo(null); /* The center of the screen */
        }
    }

    private interface ComponentMainMenuGUI {
        void set();
        void action();
    }

    private class LabelWelcome implements ComponentMainMenuGUI {

        private final JLabel labelWelcome = new JLabel(setting.getMainMenuGUIJLabelWelcome());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(-100, 0, 25, 0);
            pane.add(labelWelcome, gridBagConstraints);
        }

        @Override
        public void action() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(labelWelcome)); // FIXME: shutdown
        }
    }

    private class ButtonPlay implements ComponentMainMenuGUI {

        private final JButton buttonPlay = new JButton(setting.getMainMenuGUIJButtonPlay());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            pane.add(buttonPlay, gridBagConstraints);
        }

        @Override
        public void action() {
            buttonPlay.addActionListener(e -> {
                setVisible(false);
                setting.setMainMenuWaitThread(true);
                Room.room = new Room(MainMenuGUI.this);
                Executors.newSingleThreadExecutor().execute(Room.room); // FIXME: shutdown
            });
        }
    }

    private class ButtonSetting implements ComponentMainMenuGUI {

        private final JButton buttonSetting = new JButton(setting.getMainMenuGUIJButtonSetting());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(buttonSetting, gridBagConstraints);
        }

        @Override
        public void action() {
            buttonSetting.addActionListener(e -> {
                if (settingGUI == null) {
                    settingGUI = new SettingGUI();
                    Executors.newSingleThreadExecutor().execute(settingGUI); // FIXME: shutdown
                } else {
                    settingGUI.setVisible(true);
                }
            });
        }
    }

    private class ButtonInfo implements ComponentMainMenuGUI {

        private final JButton buttonInfo = new JButton(setting.getMainMenuGUIJButtonInfo());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(buttonInfo, gridBagConstraints);
        }

        @Override
        public void action() {
            buttonInfo.addActionListener(e -> {
                Executors.newSingleThreadExecutor().execute(new InfoGUI()); // FIXME: shutdown
            });
        }
    }

    private class ButtonExit implements ComponentMainMenuGUI {

        private final JButton buttonExit = new JButton(setting.getMainMenuGUIJButtonExit());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            pane.add(buttonExit, gridBagConstraints);
        }

        @Override
        public void action() {
            buttonExit.addActionListener(e -> {
                MainMenuGUI.this.setVisible(false);
                Executors.newSingleThreadExecutor().execute((new ExitGUI())); // FIXME: shutdown
            });
        }
    }

    private class LabelAuthor implements ComponentMainMenuGUI {

        private final JLabel labelAuthor = new JLabel(Setting.getAUTHOR());

        @Override
        public void set() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(0, 60, -100, 0);
            pane.add(labelAuthor, gridBagConstraints);
        }

        @Override
        public void action() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(labelAuthor)); // FIXME: shutdown
        }
    }
}
