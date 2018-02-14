package com.game.snake.gui;

import com.game.snake.setting.Setting;

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
 * @version 1.10
 */
public final class SettingGUI extends JFrame implements Runnable {

    private final Setting setting = Setting.getInstance();

    private final Container pane = this.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public SettingGUI() {
        setTitle(setting.getSettingGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        final List<SettingParameters> settingParametersList = loadSettingParametersList();

        for (SettingParameters label : settingParametersList) {
            label.set();
        }

        setButtonEnter(settingParametersList);

        setJFrame();
    }

    @NotNull
    private List<SettingParameters> loadSettingParametersList() {
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

    private void setButtonEnter(final List<SettingParameters> settingParametersList) {
        final JButton jButtonEnter = new JButton("Enter");

        gridBagConstraints.gridy++;
        pane.add(jButtonEnter, gridBagConstraints);

        jButtonEnter.addActionListener(e -> {
            settingParametersList.forEach(SettingParameters::update);
            setVisible(false);
        });
    }

    private void setJFrame() {
        setPreferredSize(new Dimension(setting.getSettingGUIWidth(), setting.getSettingGUIHeight()));
        setLocationRelativeTo(null); /* The center of the screen */
        pack();
        setVisible(true);
    }

    private interface SettingParameters {
        void set();
        void update();
    }

    private class ColorHead implements SettingParameters {

        final List<JRadioButton> colorHeadRadioButtonList = createColorList();

        @Override
        public void set() {
            final JLabel colorHeadLabel = new JLabel("Color of the head: ");

            setJLabel(colorHeadLabel);
            ButtonGroup colorHeadGroup = new ButtonGroup();
            fillJRadioButton(colorHeadGroup, colorHeadRadioButtonList);
            colorHeadRadioButtonList.get(5).setSelected(true); /* Default Snake color : BLACK TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorHeadRadioButton : colorHeadRadioButtonList) {
                if (colorHeadRadioButton.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorHeadRadioButton.getText());
                        setting.setColorHead((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorSnake implements SettingParameters {

        final List<JRadioButton> colorSnakeRadioButtonList = createColorList();

        @Override
        public void set() {
            final JLabel colorSnakeLabel = new JLabel("Color of the snake: ");

            setJLabel(colorSnakeLabel);
            ButtonGroup colorSnakeGroup = new ButtonGroup();
            fillJRadioButton(colorSnakeGroup, colorSnakeRadioButtonList);
            colorSnakeRadioButtonList.get(1).setSelected(true); /* Default Snake color : GREEN TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorSnakeRadioButton : colorSnakeRadioButtonList) {
                if (colorSnakeRadioButton.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorSnakeRadioButton.getText());
                        setting.setColorSnake((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorMouse implements SettingParameters {

        final List<JRadioButton> colorMouseRadioButtonList = createColorList();

        @Override
        public void set() {
            final JLabel colorMouseLabel = new JLabel("Color of the mouse: ");

            setJLabel(colorMouseLabel);
            ButtonGroup colorMouseGroup = new ButtonGroup();
            fillJRadioButton(colorMouseGroup, colorMouseRadioButtonList);
            colorMouseRadioButtonList.get(4).setSelected(true); /* Default Mouse color : GRAY TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorMouseRadioButton : colorMouseRadioButtonList) {
                if (colorMouseRadioButton.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorMouseRadioButton.getText());
                        setting.setColorMouse((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorFace implements SettingParameters {

        final List<JRadioButton> colorFaceRadioButtonList = createColorList();

        @Override
        public void set() {
            final JLabel colorFaceLabel = new JLabel("Color of the face: ");

            setJLabel(colorFaceLabel);
            ButtonGroup colorFaceGroup = new ButtonGroup();
            fillJRadioButton(colorFaceGroup, colorFaceRadioButtonList);
            colorFaceRadioButtonList.get(0).setSelected(true); /* Default Face color : RED TODO: do auto select */
        }

        @Override
        public void update() {
            for (JRadioButton colorFaceRadioButton : colorFaceRadioButtonList) {
                if (colorFaceRadioButton.isSelected()) {
                    final Field field;
                    try {
                        field = Color.class.getField(colorFaceRadioButton.getText());
                        setting.setColorFace((Color) field.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class MainMenuFullScreen implements SettingParameters {

        final List<JRadioButton> mainMenuFullScreenRadioButtonList = createTrueFalseList();

        @Override
        public void set() {
            final JLabel mainMenuFullScreenLabel = new JLabel("Full screen main menu: ");

            setJLabel(mainMenuFullScreenLabel);
            ButtonGroup mainMenuFullScreenGroup = new ButtonGroup();
            fillJRadioButton(mainMenuFullScreenGroup, mainMenuFullScreenRadioButtonList);
            setVisibleJRadioButton(mainMenuFullScreenRadioButtonList, setting.isMainMenuFullScreen() + "");
        }

        @Override
        public void update() {
            setting.setMainMenuFullScreen(mainMenuFullScreenRadioButtonList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class ChangeColor implements SettingParameters {

        final List<JRadioButton> changeColorRadioButtonList = createTrueFalseList();

        @Override
        public void set() {
            final JLabel changeColorLabel = new JLabel("Change color: ");

            setJLabel(changeColorLabel);
            ButtonGroup changeColorGroup = new ButtonGroup();
            fillJRadioButton(changeColorGroup, changeColorRadioButtonList);
            setVisibleJRadioButton(changeColorRadioButtonList, setting.isChangeColor() + "");
        }

        @Override
        public void update() {
            setting.setChangeColor(changeColorRadioButtonList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class SizeOfGame implements SettingParameters {

        final List<JRadioButton> sizeOfGameRadioButtonList = new ArrayList<>(Arrays.asList(
                new JRadioButton("10"),
                new JRadioButton("15"),
                new JRadioButton("20")
        ));

        @Override
        public void set() {
            final JLabel sizeOfGameLabel = new JLabel("Size of the game: ");

            setJLabel(sizeOfGameLabel);
            ButtonGroup sizeOfGameGroup = new ButtonGroup();
            fillJRadioButton(sizeOfGameGroup, sizeOfGameRadioButtonList);
            setVisibleJRadioButton(sizeOfGameRadioButtonList,  setting.getSizeOfGame() + "");
        }

        @Override
        public void update() {
            setting.setSizeOfGame(sizeOfGameRadioButtonList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(15));
        }
    }

    private class RoomWidth implements SettingParameters {

        final List<JRadioButton> roomWidthRadioButtonList = createSizeList();

        @Override
        public void set() {
            final JLabel roomWidthLabel = new JLabel("Room width: ");

            setJLabel(roomWidthLabel);
            ButtonGroup roomWidthGroup = new ButtonGroup();
            fillJRadioButton(roomWidthGroup, roomWidthRadioButtonList);
            setVisibleJRadioButton(roomWidthRadioButtonList, setting.getRoomWidth() + "");
        }

        @Override
        public void update() {
            setting.setRoomWidth(roomWidthRadioButtonList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private class RoomHeight implements SettingParameters {

        final List<JRadioButton> roomHeightRadioButtonList = createSizeList();

        @Override
        public void set() {
            final JLabel roomHeightLabel = new JLabel("Room height: ");

            setJLabel(roomHeightLabel);
            ButtonGroup roomHeightGroup = new ButtonGroup();
            fillJRadioButton(roomHeightGroup, roomHeightRadioButtonList);
            setVisibleJRadioButton(roomHeightRadioButtonList, setting.getRoomHeight() + "");
        }

        @Override
        public void update() {
            setting.setRoomHeight(roomHeightRadioButtonList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private void setJLabel(JLabel jLabel) {
        gridBagConstraints.gridy++;
        pane.add(jLabel, gridBagConstraints);
    }

    private void fillJRadioButton (@NotNull final ButtonGroup buttonGroup,
                                   @NotNull final List<JRadioButton> jRadioButtons) {

        jRadioButtons.forEach(buttonGroup::add);

        int i = 1;
        for (JRadioButton button : jRadioButtons) {
            gridBagConstraints.gridx = i++;
            pane.add(button, gridBagConstraints);
        }
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

        for (JRadioButton jRadioButton : jRadioButtons) {
            if (jRadioButton.getText().equals(value)) {
                jRadioButton.setSelected(true);
                break;
            }
        }
    }
}
