package com.game.snake.view.gui.setting;

import com.game.snake.setting.Setting;

import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public final class SettingGUI extends JFrame implements Runnable {

    private static volatile SettingGUI settingGUI;

    private final Setting setting = Setting.getInstance();

    private final Container container = getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    @Getter private boolean initialized = false;

    private SettingGUI() {
        setTitle(setting.getSettingGUIJFrameTitle());
        container.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    public static SettingGUI getInstance() {
        if (settingGUI == null) {
            synchronized (SettingGUI.class) {
                if (settingGUI == null) {
                    settingGUI = new SettingGUI();
                }
            }
        }
        return settingGUI;
    }

    public void onVisible() {
        setVisible(true);
    }

    @Override
    public void run() {
        final List<SettingJComponent> settingJComponentList = loadSettingJComponentList();

        settingJComponentList.forEach(SettingJComponent::init);

        initJButtonEnter(settingJComponentList);

        initJFrame();
    }

    @NotNull
    private List<SettingJComponent> loadSettingJComponentList() {
        return new ArrayList<>(Arrays.asList(
                new ColorHead(),
                new ColorSnake(),
                new ColorMouse(),
                new ColorFace(),
                new MainMenuFullScreen(),
                new ChangeColor(),
                new SizeOfGame(),
                new RoomWidth(),
                new RoomHeight()
        ));
    }

    private void initJButtonEnter(final List<SettingJComponent> settingJComponentList) {
        final JButton jButtonEnter = new JButton("Enter");

        setJComponentPlace(jButtonEnter);

        jButtonEnter.addActionListener(e -> {
            settingJComponentList.forEach(SettingJComponent::update);
            setVisible(false);
        });
    }

    private void initJFrame() {
        setPreferredSize(new Dimension(setting.getSettingGUIWidth(), setting.getSettingGUIHeight()));
        pack();
        setLocationRelativeTo(null); /* Set the center of the screen */
        setVisible(true);
        initialized = true;
    }

    private interface SettingJComponent {

        /**
         * This method must implement the initialization of the component,
         * giving it a name and a position.
         *
         * This method should be called when all components are in
         * the initialization process.
         */
        void init();

        /**
         * This method should implement updating settings from each component.
         *
         * This method should be called when the Enter button is pressed.
         */
        void update();
    }

    private class ColorHead implements SettingJComponent {

        private final List<JRadioButton> colorHeadForSelectList = createColorList();

        @Override
        public void init() {
            final JLabel colorHeadLabel = new JLabel("Color of the head: ");

            setJComponentPlace(colorHeadLabel);
            ButtonGroup colorHeadGroup = new ButtonGroup();
            fillJRadioButton(colorHeadGroup, colorHeadForSelectList);
            colorHeadForSelectList.get(5).setSelected(true); /* Default Snake color : BLACK TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorHead : colorHeadForSelectList) {
                if (colorHead.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorHead.getText());
                        setting.setColorHead((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorSnake implements SettingJComponent {

        private final List<JRadioButton> colorSnakeForSelectList = createColorList();

        @Override
        public void init() {
            final JLabel colorSnakeLabel = new JLabel("Color of the snake: ");

            setJComponentPlace(colorSnakeLabel);
            ButtonGroup colorSnakeGroup = new ButtonGroup();
            fillJRadioButton(colorSnakeGroup, colorSnakeForSelectList);
            colorSnakeForSelectList.get(1).setSelected(true); /* Default Snake color : GREEN TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorSnake : colorSnakeForSelectList) {
                if (colorSnake.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorSnake.getText());
                        setting.setColorSnake((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorMouse implements SettingJComponent {

        private final List<JRadioButton> colorMouseForSelectList = createColorList();

        @Override
        public void init() {
            final JLabel colorMouseLabel = new JLabel("Color of the mouse: ");

            setJComponentPlace(colorMouseLabel);
            ButtonGroup colorMouseGroup = new ButtonGroup();
            fillJRadioButton(colorMouseGroup, colorMouseForSelectList);
            colorMouseForSelectList.get(4).setSelected(true); /* Default Mouse color : GRAY TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorMouse : colorMouseForSelectList) {
                if (colorMouse.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorMouse.getText());
                        setting.setColorMouse((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorFace implements SettingJComponent {

        private final List<JRadioButton> colorFaceForSelectList = createColorList();

        @Override
        public void init() {
            final JLabel colorFaceLabel = new JLabel("Color of the face: ");

            setJComponentPlace(colorFaceLabel);
            ButtonGroup colorFaceGroup = new ButtonGroup();
            fillJRadioButton(colorFaceGroup, colorFaceForSelectList);
            colorFaceForSelectList.get(0).setSelected(true); /* Default Face color : RED TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorFace : colorFaceForSelectList) {
                if (colorFace.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorFace.getText());
                        setting.setColorFace((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class MainMenuFullScreen implements SettingJComponent {

        private final List<JRadioButton> mainMenuFullScreenForSelectList = createTrueFalseList();

        @Override
        public void init() {
            final JLabel mainMenuFullScreenLabel = new JLabel("Full screen main menu: ");

            setJComponentPlace(mainMenuFullScreenLabel);
            ButtonGroup mainMenuFullScreenGroup = new ButtonGroup();
            fillJRadioButton(mainMenuFullScreenGroup, mainMenuFullScreenForSelectList);
            setVisibleJRadioButton(mainMenuFullScreenForSelectList, setting.isMainMenuFullScreen() + "");
        }

        @Override
        public void update() {
            setting.setMainMenuFullScreen(mainMenuFullScreenForSelectList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class ChangeColor implements SettingJComponent {

        private final List<JRadioButton> changeColorForSelectList = createTrueFalseList();

        @Override
        public void init() {
            final JLabel changeColorLabel = new JLabel("Change color: ");

            setJComponentPlace(changeColorLabel);
            ButtonGroup changeColorGroup = new ButtonGroup();
            fillJRadioButton(changeColorGroup, changeColorForSelectList);
            setVisibleJRadioButton(changeColorForSelectList, setting.isChangeColor() + "");
        }

        @Override
        public void update() {
            setting.setChangeColor(changeColorForSelectList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class SizeOfGame implements SettingJComponent {

        private final List<JRadioButton> sizeOfGameForSelectList = new ArrayList<>(Arrays.asList(
                new JRadioButton("10"),
                new JRadioButton("15"),
                new JRadioButton("20")
        ));

        @Override
        public void init() {
            final JLabel sizeOfGameLabel = new JLabel("Size of the game: ");

            setJComponentPlace(sizeOfGameLabel);
            ButtonGroup sizeOfGameGroup = new ButtonGroup();
            fillJRadioButton(sizeOfGameGroup, sizeOfGameForSelectList);
            setVisibleJRadioButton(sizeOfGameForSelectList,  setting.getSizeOfGame() + "");
        }

        @Override
        public void update() {
            setting.setSizeOfGame(sizeOfGameForSelectList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(15));
        }
    }

    private class RoomWidth implements SettingJComponent {

        private final List<JRadioButton> roomWidthForSelectList = createSizeList();

        @Override
        public void init() {
            final JLabel roomWidthLabel = new JLabel("Room width: ");

            setJComponentPlace(roomWidthLabel);
            ButtonGroup roomWidthGroup = new ButtonGroup();
            fillJRadioButton(roomWidthGroup, roomWidthForSelectList);
            setVisibleJRadioButton(roomWidthForSelectList, setting.getRoomWidth() + "");
        }

        @Override
        public void update() {
            setting.setRoomWidth(roomWidthForSelectList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private class RoomHeight implements SettingJComponent {

        private final List<JRadioButton> roomHeightForSelectList = createSizeList();

        @Override
        public void init() {
            final JLabel roomHeightLabel = new JLabel("Room height: ");

            setJComponentPlace(roomHeightLabel);
            ButtonGroup roomHeightGroup = new ButtonGroup();
            fillJRadioButton(roomHeightGroup, roomHeightForSelectList);
            setVisibleJRadioButton(roomHeightForSelectList, setting.getRoomHeight() + "");
        }

        @Override
        public void update() {
            setting.setRoomHeight(roomHeightForSelectList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private void setJComponentPlace(@NotNull final JComponent jComponent) {
        gridBagConstraints.gridy++;
        container.add(jComponent, gridBagConstraints);
    }

    private void fillJRadioButton (@NotNull final ButtonGroup buttonGroup,
                                   @NotNull final List<JRadioButton> jRadioButtons) {

        jRadioButtons.forEach(buttonGroup::add);

        gridBagConstraints.gridx = 1;
        jRadioButtons.forEach(button -> {
            gridBagConstraints.gridx++;
            container.add(button, gridBagConstraints);
        });
        gridBagConstraints.gridx = 0;
    }

    @NotNull
    @Contract(pure = true)
    private ArrayList<JRadioButton> createSizeList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton(setting.getSizeListValue1()),
                new JRadioButton(setting.getSizeListValue2()),
                new JRadioButton(setting.getSizeListValue3()),
                new JRadioButton(setting.getSizeListValue4()),
                new JRadioButton(setting.getSizeListValue5())
        ));
    }

    @NotNull
    private ArrayList<JRadioButton> createTrueFalseList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton("true"),
                new JRadioButton("false")
        ));
    }

    @NotNull
    private List<JRadioButton> createColorList() {
        return new ArrayList<>(Arrays.asList(
                new JRadioButton(setting.getColor1()),
                new JRadioButton(setting.getColor2()),
                new JRadioButton(setting.getColor3()),
                new JRadioButton(setting.getColor4()),
                new JRadioButton(setting.getColor5()),
                new JRadioButton(setting.getColor6())
        ));
    }

    private void setVisibleJRadioButton(@NotNull final List<JRadioButton> jRadioButtons,
                                        @NotNull final String value) {

        jRadioButtons.stream()
                .filter(jRadioButton -> jRadioButton.getText().equals(value))
                .findFirst()
                .ifPresent(jRadioButton -> jRadioButton.setSelected(true));
    }
}
