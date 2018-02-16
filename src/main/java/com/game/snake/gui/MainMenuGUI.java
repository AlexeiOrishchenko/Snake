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

    private final Container container = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    private SettingGUI settingGUI;

    public MainMenuGUI() {
        setTitle(setting.getMainMenuGUIJFrameTitle());
        container.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        final List<MainMenuJComponent> mainMenuJComponentList = loadMainMenuJComponentList();

        mainMenuJComponentList.forEach(mainMenuJComponent -> {
            mainMenuJComponent.init();
            mainMenuJComponent.setAction();
        });

        setJFrame();
    }

    @NotNull
    private List<MainMenuJComponent> loadMainMenuJComponentList() {
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
            setLocationRelativeTo(null); /* Set the center of the screen */
        }
    }

    private interface MainMenuJComponent {

        /**
         * This method must implement the initialization of the component,
         * giving it a name and location and add it to the container.
         *
         * This method should be called for each component.
         */
        void init();

        /**
         * This method must implement the action of each button.
         *
         * This method should be called when the button is pressed.
         */
        void setAction();
    }

    private class LabelWelcome implements MainMenuJComponent {

        private final JLabel labelWelcome = new JLabel(setting.getMainMenuGUIJLabelWelcome());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(-100, 0, 25, 0);
            container.add(labelWelcome, gridBagConstraints);
        }

        @Override
        public void setAction() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(labelWelcome)); // FIXME: shutdown
        }
    }

    private class ButtonPlay implements MainMenuJComponent {

        private final JButton buttonPlay = new JButton(setting.getMainMenuGUIJButtonPlay());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(10, 0, 0, 0);
            container.add(buttonPlay, gridBagConstraints);
        }

        @Override
        public void setAction() {
            buttonPlay.addActionListener(e -> {
                setVisible(false);
                setting.setMainMenuWaitThread(true);
                Room.room = new Room(MainMenuGUI.this);
                Executors.newSingleThreadExecutor().execute(Room.room); // FIXME: shutdown
            });
        }
    }

    private class ButtonSetting implements MainMenuJComponent {

        private final JButton buttonSetting = new JButton(setting.getMainMenuGUIJButtonSetting());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            container.add(buttonSetting, gridBagConstraints);
        }

        @Override
        public void setAction() {
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

    private class ButtonInfo implements MainMenuJComponent {

        private final JButton buttonInfo = new JButton(setting.getMainMenuGUIJButtonInfo());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            container.add(buttonInfo, gridBagConstraints);
        }

        @Override
        public void setAction() {
            buttonInfo.addActionListener(e -> {
                Executors.newSingleThreadExecutor().execute(new InfoGUI()); // FIXME: shutdown
            });
        }
    }

    private class ButtonExit implements MainMenuJComponent {

        private final JButton buttonExit = new JButton(setting.getMainMenuGUIJButtonExit());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            container.add(buttonExit, gridBagConstraints);
        }

        @Override
        public void setAction() {
            buttonExit.addActionListener(e -> {
                MainMenuGUI.this.setVisible(false);
                Executors.newSingleThreadExecutor().execute((new ExitGUI())); // FIXME: shutdown
            });
        }
    }

    private class LabelAuthor implements MainMenuJComponent {

        private final JLabel labelAuthor = new JLabel(Setting.getAUTHOR());

        @Override
        public void init() {
            gridBagConstraints.gridy++;
            gridBagConstraints.insets = new Insets(0, 60, -100, 0);
            container.add(labelAuthor, gridBagConstraints);
        }

        @Override
        public void setAction() {
            Executors.newSingleThreadExecutor().execute(new ChangeColor(labelAuthor)); // FIXME: shutdown
        }
    }
}
