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

    private final JButton jButtonEnter = new JButton("Enter"); // FIXME: 13.02.2018


    public SettingGUI() {
        setTitle(setting.getSettingGUIJFrameTitle());
        pane.setLayout(new GridBagLayout());
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    @Override
    public void run() {
        final List<LabelSettingGUI> LabelSettingGUIList = loadLabelSettingGUIList();

        for (LabelSettingGUI label : LabelSettingGUIList) {
            label.set();
        }

        /* Enter */
        gridBagConstraints.gridy++;
        pane.add(jButtonEnter, gridBagConstraints);
        jButtonEnter.addActionListener(e -> {

            for (LabelSettingGUI setting : LabelSettingGUIList) {
                setting.update();
            }

            setVisible(false);
        });

        setJFrame();
    }

    @NotNull
    private List<LabelSettingGUI> loadLabelSettingGUIList() {
        return new ArrayList<LabelSettingGUI>(Arrays.asList(
                new LabelColorHead(),
                new LabelColorSnake(),
                new LabelColorMouse(),
                new LabelColorFace(),
                new LabelFullScreenMainMenu(),
                new LabelChangeColor(),
                new LabelSizeOfGame(),
                new LabelRoomWidth(),
                new LabelRoomHeight()
        ));
    }

    private void setJFrame() {
        setPreferredSize(new Dimension(setting.getSettingGUIWidth(), setting.getSettingGUIHeight()));
        setLocationRelativeTo(null); /* The center of the screen */
        pack();
        setVisible(true);
    }

    private interface LabelSettingGUI {
        void set();
        void update();
    }

    private class LabelColorHead implements LabelSettingGUI {

        final JLabel jLabelColorHead = new JLabel("Color of the head: ");
        final List<JRadioButton> jRadioButtonsColorHeadList = createColorList();

        @Override
        public void set() {
            setJLabel(jLabelColorHead); // TODO: not current work
            ButtonGroup groupColorHead = new ButtonGroup();
            fillJRadioButton(groupColorHead, jRadioButtonsColorHeadList);
            jRadioButtonsColorHeadList.get(5).setSelected(true); /* Default selected Snake color : BLACK */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorHeadList) {
                if (jRadioButton.isSelected()) {
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText());
                        setting.setColorHead((Color) f.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorSnake implements LabelSettingGUI {

        final JLabel jLabelColorSnake = new JLabel("Color of the snake: ");
        final List<JRadioButton> jRadioButtonsColorSnakeList = createColorList();

        @Override
        public void set() {
            setJLabel(jLabelColorSnake);
            ButtonGroup groupColorSnake = new ButtonGroup();
            fillJRadioButton(groupColorSnake, jRadioButtonsColorSnakeList);
            jRadioButtonsColorSnakeList.get(1).setSelected(true); /* Default selected Snake color : GREEN */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorSnakeList) {
                if (jRadioButton.isSelected()) {
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText());
                        setting.setColorSnake((Color) f.get(null));
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorMouse implements LabelSettingGUI {

        final JLabel jLabelColorMouse = new JLabel("Color of the mouse: ");
        final List<JRadioButton> jRadioButtonsColorMouseList = createColorList();

        @Override
        public void set() {
            setJLabel(jLabelColorMouse);
            ButtonGroup groupColorMouse = new ButtonGroup();
            fillJRadioButton(groupColorMouse, jRadioButtonsColorMouseList);
            jRadioButtonsColorMouseList.get(4).setSelected(true); /* Default selected Mouse color : GRAY */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorMouseList) {
                if (jRadioButton.isSelected()) {
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); 
                        setting.setColorMouse((Color) f.get(null)); 
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorFace implements LabelSettingGUI {

        final JLabel jLabelColorFace = new JLabel("Color of the face: ");
        final List<JRadioButton> jRadioButtonsColorFaceList = createColorList();

        @Override
        public void set() {
            setJLabel(jLabelColorFace);
            ButtonGroup groupColorFace = new ButtonGroup();
            fillJRadioButton(groupColorFace, jRadioButtonsColorFaceList);
            jRadioButtonsColorFaceList.get(0).setSelected(true); /* Default selected Face color : RED */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorFaceList) {
                if (jRadioButton.isSelected()) {
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); 
                        setting.setColorFace((Color) f.get(null)); 
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelFullScreenMainMenu implements LabelSettingGUI {

        final JLabel jLabelFullScreenMainMenu = new JLabel("Full screen main menu: ");
        final List<JRadioButton> jRadioButtonsFullScreenMainMenuList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel(jLabelFullScreenMainMenu);
            ButtonGroup groupFullScreenMainMenu = new ButtonGroup();
            fillJRadioButton(groupFullScreenMainMenu, jRadioButtonsFullScreenMainMenuList);
            setVisibleJRadioButton(jRadioButtonsFullScreenMainMenuList, setting.isMainMenuFullScreen() + "");
        }

        @Override
        public void update() {
            setting.setMainMenuFullScreen(jRadioButtonsFullScreenMainMenuList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class LabelChangeColor implements LabelSettingGUI {

        final JLabel jLabelChangeColor = new JLabel("Change color: ");
        final List<JRadioButton> jRadioButtonsChangeColorList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel(jLabelChangeColor);
            ButtonGroup groupChangeColor = new ButtonGroup();
            fillJRadioButton(groupChangeColor, jRadioButtonsChangeColorList);
            setVisibleJRadioButton(jRadioButtonsChangeColorList, setting.isChangeColor() + "");
        }

        @Override
        public void update() {
            setting.setChangeColor(jRadioButtonsChangeColorList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class LabelSizeOfGame implements LabelSettingGUI {

        final JLabel jLabelSizeOfGame = new JLabel("Size of the game: ");
        final List<JRadioButton> jRadioButtonsSizeOfGameList = new ArrayList<>(Arrays.asList(
                new JRadioButton("10"),
                new JRadioButton("15"),
                new JRadioButton("20")
        ));

        @Override
        public void set() {
            setJLabel(jLabelSizeOfGame);
            ButtonGroup groupSizeOfGame = new ButtonGroup();
            fillJRadioButton(groupSizeOfGame, jRadioButtonsSizeOfGameList);
            setVisibleJRadioButton(jRadioButtonsSizeOfGameList,  setting.getSizeOfGame() + "");
        }

        @Override
        public void update() {
            setting.setSizeOfGame(jRadioButtonsSizeOfGameList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(15));
        }
    }

    private class LabelRoomWidth implements LabelSettingGUI {

        final JLabel jLabelRoomWidth = new JLabel("Room width: ");
        final List<JRadioButton> jRadioButtonsRoomWidthList = createSizeList();

        @Override
        public void set() {
            setJLabel(jLabelRoomWidth);
            ButtonGroup groupRoomWidth = new ButtonGroup();
            fillJRadioButton(groupRoomWidth, jRadioButtonsRoomWidthList);
            setVisibleJRadioButton(jRadioButtonsRoomWidthList, setting.getRoomWidth() + "");
        }

        @Override
        public void update() {
            setting.setRoomWidth(jRadioButtonsRoomWidthList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private class LabelRoomHeight implements LabelSettingGUI {

        final JLabel jLabelRoomHeight = new JLabel("Room height: ");
        final List<JRadioButton> jRadioButtonsRoomHeightList = createSizeList();

        @Override
        public void set() {
            setJLabel(jLabelRoomHeight);
            ButtonGroup groupRoomHeight = new ButtonGroup();
            fillJRadioButton(groupRoomHeight, jRadioButtonsRoomHeightList);
            setVisibleJRadioButton(jRadioButtonsRoomHeightList, setting.getRoomHeight() + "");
        }

        @Override
        public void update() {
            setting.setRoomHeight(jRadioButtonsRoomHeightList.stream()
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
