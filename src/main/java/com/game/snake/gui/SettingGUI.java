package com.game.snake.gui;

import com.game.snake.setting.Setting;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.6
 *
 * This GUI class has settings for this game.
 */
public final class SettingGUI extends JFrame implements Runnable {

    /* This is synchronized singleton object of this class */
    private static volatile SettingGUI ourSettingGUI;

    /* This is list of the setting label */
    private final List<JLabel> jLabelSettingList = new ArrayList<JLabel>(Arrays.asList(
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
    private final List<SetSettingLabel> setSettingLabelList = new ArrayList<SetSettingLabel>(Arrays.asList(
            new ColorSnake(),
            new ColorMouse(),
            new ColorFace(),
            new FullScreenMainMenu(),
            new ChangeColor(),
            new SizeOfGame(),
            new RoomWidth(),
            new RoomHeight()
    ));

    /* Button for apply setting change */
    private final JButton jButtonEnter = new JButton("Enter");

    /* Our container and Bag for set label at the GUI */
    private final Container pane = this.getContentPane();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    /* Count "Y" position at the GUI */
    private int gridyValue = 0;

    /**
     * Private constructor that set GUI title and create
     * new BagLayout.
     */
    private SettingGUI() {
        super(Setting.getSettingJFrameTitle());

        pane.setLayout(new GridBagLayout());

        /* Centralize all the labels */
        gridBagConstraints.fill = GridBagConstraints.BOTH;
    }

    /**
     * Double-Checked Singleton.
     *
     * @return singleton object of this class
     */
    public static SettingGUI getInstance() {
        if (ourSettingGUI == null) {
            synchronized (SettingGUI.class) {
                if (ourSettingGUI == null) {
                    ourSettingGUI = new SettingGUI();
                }
            }
        }
        return ourSettingGUI;
    }

    /**
     * This method is the main method of this class.
     * This method set label and radio button and do
     * update of Setting class
     */
    @Override
    public void run() {
        /* Set every label to the GUI */
        for (SetSettingLabel label : setSettingLabelList) {
            label.set();
        }

        /* Enter */
        gridBagConstraints.gridy = gridyValue++;
        pane.add(jButtonEnter, gridBagConstraints);
        jButtonEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                /* Do update */
                for (SetSettingLabel setting : setSettingLabelList) {
                    setting.update();
                }

                /* Close setting GUI */
                setVisible(false);
            }
        });

        setJFrame();
    }

    /**
     * This method set JLabel to the current "y" position and autoincrement
     * gridy.
     */
    private void setJLabel() {
        gridBagConstraints.gridy = gridyValue;
        pane.add(jLabelSettingList.get(gridyValue++), gridBagConstraints);
    }

    /**
     * This method create groups of the jRadioButton and add to the pane
     *
     * @param buttonGroup add JRadioButton to this group
     */
    private void fillJRadioButton (@NotNull final ButtonGroup buttonGroup,
                                   @NotNull ArrayList<JRadioButton> jRadioButtons) {

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
                new JRadioButton(Setting.getSizeListValue1()),
                new JRadioButton(Setting.getSizeListValue2()),
                new JRadioButton(Setting.getSizeListValue3()),
                new JRadioButton(Setting.getSizeListValue4()),
                new JRadioButton(Setting.getSizeListValue5())
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
                new JRadioButton(Setting.getColor1()),
                new JRadioButton(Setting.getColor2()),
                new JRadioButton(Setting.getColor3()),
                new JRadioButton(Setting.getColor4()),
                new JRadioButton(Setting.getColor5()),
                new JRadioButton(Setting.getColor6())
        ));
    }

    /**
     * This method compare selected parameter in Setting class
     * and selected equals JRadioButton
     *
     * @param jRadioButtons list of the JRadioButton
     * @param value setting value of something to compare
     */
    private void setVisibleJRadioButton(@NotNull ArrayList<JRadioButton> jRadioButtons, String value) {
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
        setPreferredSize(new Dimension(Setting.getSettingWidth(), Setting.getSettingHeight()));
        setLocationRelativeTo(null); // the center of the screen
        pack();
        setVisible(true);
    }

    /**
     * This interface has 2 method: set and update.
     * 
     * @see SetSettingLabel#set()
     * @see SetSettingLabel#update()
     */
    private interface SetSettingLabel {

        /**
         * set label to the Setting GUI class
         */
        void set();

        /**
         * update information in Setting class
         */
        void update();
    }

    private class ColorSnake implements SetSettingLabel {

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
                        Setting.setColorSnake((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorMouse implements SetSettingLabel {

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
                        Setting.setColorMouse((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class ColorFace implements SetSettingLabel {

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
                        Setting.setColorFace((Color) f.get(null)); // Set the color
                    } catch (NoSuchFieldException | IllegalAccessException err) {
                        err.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    private class FullScreenMainMenu implements SetSettingLabel {

        ArrayList<JRadioButton> jRadioButtonsFullScreenMainMenuList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupFullScreenMainMenu = new ButtonGroup();
            fillJRadioButton(groupFullScreenMainMenu, jRadioButtonsFullScreenMainMenuList);
            setVisibleJRadioButton(jRadioButtonsFullScreenMainMenuList, Setting.isFullScreenMainMenu() + "");
        }

        @Override
        public void update() {
            Setting.setFullScreenMainMenu(jRadioButtonsFullScreenMainMenuList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class ChangeColor implements SetSettingLabel {

        ArrayList<JRadioButton> jRadioButtonsChangeColorList = createTrueFalseList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupChangeColor = new ButtonGroup();
            fillJRadioButton(groupChangeColor, jRadioButtonsChangeColorList);
            setVisibleJRadioButton(jRadioButtonsChangeColorList, Setting.isChangeColor() + "");
        }

        @Override
        public void update() {
            Setting.setChangeColor(jRadioButtonsChangeColorList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Boolean::parseBoolean)
                    .orElse(true));
        }
    }

    private class SizeOfGame implements SetSettingLabel {

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
            setVisibleJRadioButton(jRadioButtonsSizeOfGameList,  Setting.getSizeOfGame() + "");
        }

        @Override
        public void update() {
            Setting.setSizeOfGame(jRadioButtonsSizeOfGameList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(15));
        }
    }

    private class RoomWidth implements SetSettingLabel {

        ArrayList<JRadioButton> jRadioButtonsRoomWidthList = createSizeList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupRoomWidth = new ButtonGroup();
            fillJRadioButton(groupRoomWidth, jRadioButtonsRoomWidthList);
            setVisibleJRadioButton(jRadioButtonsRoomWidthList, Setting.getRoomWidth() + "");
        }

        @Override
        public void update() {
            Setting.setRoomWidth(jRadioButtonsRoomWidthList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }

    private class RoomHeight implements SetSettingLabel {

        ArrayList<JRadioButton> jRadioButtonsRoomHeightList = createSizeList();

        @Override
        public void set() {
            setJLabel();
            ButtonGroup groupRoomHeight = new ButtonGroup();
            fillJRadioButton(groupRoomHeight, jRadioButtonsRoomHeightList);
            setVisibleJRadioButton(jRadioButtonsRoomHeightList, Setting.getRoomHeight() + "");
        }

        @Override
        public void update() {
            Setting.setRoomHeight(jRadioButtonsRoomHeightList.stream()
                    .filter(AbstractButton::isSelected)
                    .findFirst()
                    .map(JRadioButton::getText)
                    .map(Integer::parseInt)
                    .orElse(20));
        }
    }
}