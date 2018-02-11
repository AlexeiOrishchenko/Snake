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
 *
 * This GUI class has settings for this game.
 */
public final class SettingGUI extends JFrame implements Runnable {

    /* Our Setting singleton object */
    private final Setting setting = Setting.getInstance();

    /* This is list of the setting label */
    private final List<JLabel> settingGUIJLabelList = new ArrayList<JLabel>(Arrays.asList(
            new JLabel("Color of the head: "),
            new JLabel("Color of the snake: "),
            new JLabel("Color of the mouse: "),
            new JLabel("Color of the face: "),
            new JLabel("Full screen main menu: "),
            new JLabel("Change color: "),
            new JLabel("Size of the game: "),
            new JLabel("Room width: "),
            new JLabel("Room height: ")
    ));

    /* This is list of the inner class setting*/
    private final List<LabelSettingGUI> LabelSettingGUIList = new ArrayList<LabelSettingGUI>(Arrays.asList(
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

    /* Button for apply setting change */
    private final JButton jButtonEnter = new JButton("Enter");

    /* Our container and Bag for set label at the GUI */
    private final Container pane = this.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /**
     * Constructor that set GUI title and create new BagLayout.
     */
    public SettingGUI() {
        /* Get SettingGUI title from the setting */
        setTitle(setting.getSettingGUIJFrameTitle());

        pane.setLayout(new GridBagLayout());

        /* Centralize all the labels */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    /**
     * This method is the main method of this class.
     * This method set label and radio button and do
     * update of Setting class
     */
    @Override
    public void run() {
        /* Set every label to the GUI */
        for (LabelSettingGUI label : LabelSettingGUIList) {
            label.set();
        }

        /* Enter */
        gridBagConstraints.gridy++;
        pane.add(jButtonEnter, gridBagConstraints);
        jButtonEnter.addActionListener(e -> {

            /* Do update */
            for (LabelSettingGUI setting : LabelSettingGUIList) {
                setting.update();
            }

            /* Close setting GUI */
            setVisible(false);
        });

        setJFrame();
    }

    /**
     * This method set JLabel to the current "y" position and autoincrement
     * gridy.
     */
    private void setJLabel() {
        gridBagConstraints.gridy++;
        pane.add(settingGUIJLabelList.get(gridBagConstraints.gridy), gridBagConstraints);
    }

    /**
     * This method create groups of the jRadioButton and add to the pane
     *
     * @param buttonGroup add JRadioButton to this group
     */
    private void fillJRadioButton (@NotNull final ButtonGroup buttonGroup,
                                   @NotNull final ArrayList<JRadioButton> jRadioButtons) {

        /* Create group of the jRadioButton */
        jRadioButtons.forEach(buttonGroup::add);

        /* Add every jRadioButton to the pane */
        int i = 1;
        for (JRadioButton button : jRadioButtons) {
            gridBagConstraints.gridx = i++;
            pane.add(button, gridBagConstraints);
        }
        gridBagConstraints.gridx = 0;
    }

    /**
     * @return new ArrayList of the new JRadioButton for the
     * size of height or width of the room. Size of game take
     * from the Setting class.
     */
    @NotNull
    @Contract(pure = true)
    private ArrayList<JRadioButton> createSizeList() {
        return new ArrayList<JRadioButton>(Arrays.asList(
                new JRadioButton(setting.getSizeListValue1()),
                new JRadioButton(setting.getSizeListValue2()),
                new JRadioButton(setting.getSizeListValue3()),
                new JRadioButton(setting.getSizeListValue4()),
                new JRadioButton(setting.getSizeListValue5())
        ));
    }

    /**
     * @return new ArrayList of the new JRadioButton for the
     * true/false choice. We can't change value of the button.
     */
    @NotNull
    private ArrayList<JRadioButton> createTrueFalseList() {
        return new ArrayList<JRadioButton>(Arrays.asList(
                new JRadioButton("true"),
                new JRadioButton("false")
        ));
    }

    /**
     * @return new ArrayList of the new JRadioButton for the
     * color choice. Color name take from the Setting class.
     */
    @NotNull
    private ArrayList<JRadioButton> createColorList() {
        return new ArrayList<JRadioButton>(Arrays.asList(
                new JRadioButton(setting.getColor1()),
                new JRadioButton(setting.getColor2()),
                new JRadioButton(setting.getColor3()),
                new JRadioButton(setting.getColor4()),
                new JRadioButton(setting.getColor5()),
                new JRadioButton(setting.getColor6())
        ));
    }

    /**
     * This method compare selected parameter in Setting class
     * and selected equals JRadioButton
     *
     * @param jRadioButtons list of the JRadioButton
     * @param value setting value of something to compare
     */
    private void setVisibleJRadioButton(@NotNull final ArrayList<JRadioButton> jRadioButtons,
                                        @NotNull final String value) {

        for (JRadioButton jRadioButton : jRadioButtons) {
            if (jRadioButton.getText().equals(value)) {
                jRadioButton.setSelected(true);
                break;
            }
        }
    }

    /**
     * Set size and locations of the window, and start it
     */
    private void setJFrame() {
        setPreferredSize(new Dimension(setting.getSettingGUIWidth(), setting.getSettingGUIHeight()));
        setLocationRelativeTo(null); // the center of the screen
        pack();
        setVisible(true);
    }

    /**
     * This interface has 2 method: set and update.
     * 
     * @see LabelSettingGUI#set()
     * @see LabelSettingGUI#update()
     */
    private interface LabelSettingGUI {

        /**
         * set label to the Setting GUI class
         */
        void set();

        /**
         * update information in Setting class
         */
        void update();
    }

    private class LabelColorHead implements LabelSettingGUI {

        ArrayList<JRadioButton> jRadioButtonsColorHeadList = createColorList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupColorHead = new ButtonGroup();
            fillJRadioButton(groupColorHead, jRadioButtonsColorHeadList);
            jRadioButtonsColorHeadList.get(5).setSelected(true); /* do default selected Snake color : BLACK */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorHeadList) {
                if (jRadioButton.isSelected()) {
                    /* Try to get a color by name using reflection */
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); // Get the color if we can
                        setting.setColorHead((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorSnake implements LabelSettingGUI {

        ArrayList<JRadioButton> jRadioButtonsColorSnakeList = createColorList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupColorSnake = new ButtonGroup();
            fillJRadioButton(groupColorSnake, jRadioButtonsColorSnakeList);
            jRadioButtonsColorSnakeList.get(1).setSelected(true); /* do default selected Snake color : GREEN */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorSnakeList) {
                if (jRadioButton.isSelected()) {
                    /* Try to get a color by name using reflection */
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); // Get the color if we can
                        setting.setColorSnake((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorMouse implements LabelSettingGUI {

        ArrayList<JRadioButton> jRadioButtonsColorMouseList = createColorList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupColorMouse = new ButtonGroup();
            fillJRadioButton(groupColorMouse, jRadioButtonsColorMouseList);
            jRadioButtonsColorMouseList.get(4).setSelected(true); /* do default selected Mouse color : GRAY */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorMouseList) {
                if (jRadioButton.isSelected()) {
                    /* Try to get a color by name using reflection */
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); // Get the color if we can
                        setting.setColorMouse((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelColorFace implements LabelSettingGUI {

        ArrayList<JRadioButton> jRadioButtonsColorFaceList = createColorList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupColorFace = new ButtonGroup();
            fillJRadioButton(groupColorFace, jRadioButtonsColorFaceList);
            jRadioButtonsColorFaceList.get(0).setSelected(true); /* do default selected Face color : RED */
        }

        @Override
        public void update() {
            for (JRadioButton jRadioButton : jRadioButtonsColorFaceList) {
                if (jRadioButton.isSelected()) {
                    /* Try to get a color by name using reflection */
                    final Field f;
                    try {
                        f = Color.class.getField(jRadioButton.getText()); // Get the color if we can
                        setting.setColorFace((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class LabelFullScreenMainMenu implements LabelSettingGUI {

        ArrayList<JRadioButton> jRadioButtonsFullScreenMainMenuList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel();
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

        ArrayList<JRadioButton> jRadioButtonsChangeColorList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel();
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

        ArrayList<JRadioButton> jRadioButtonsSizeOfGameList =new ArrayList<JRadioButton>(Arrays.asList(
                new JRadioButton("10"),
                new JRadioButton("15"),
                new JRadioButton("20")
        ));

        @Override
        public void set() {
            setJLabel();
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

        ArrayList<JRadioButton> jRadioButtonsRoomWidthList = createSizeList();

        @Override
        public void set() {
            setJLabel();
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

        ArrayList<JRadioButton> jRadioButtonsRoomHeightList = createSizeList();

        @Override
        public void set() {
            setJLabel();
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
}