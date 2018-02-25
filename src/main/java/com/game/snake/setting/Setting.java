package com.game.snake.setting;

import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public class Setting {

    private static volatile Setting ourInstance;

    private static final String AUTHOR = "Author: Nikita Koliadin";

    private String mainMenuGUIJFrameTitle = "Snake - MAIN MENU";
    private String playJFrameTitle = "Snake - PLAY"; // FIXME: 04.02.2018
    private String settingGUIJFrameTitle = "Snake - SETTING";

    private String mainMenuGUIJLabelWelcome = "Welcome to the game \"SNAKE\"";
    private String mainMenuGUIJButtonPlay = "PLAY";
    private String mainMenuGUIJButtonSetting = "SETTING";
    private String mainMenuGUIJButtonInfo = "INFO";
    private String mainMenuGUIJButtonExit = "EXIT";

    private String color1 = "RED";
    private String color2 = "GREEN";
    private String color3 = "BLUE";
    private String color4 = "YELLOW";
    private String color5 = "GRAY";
    private String color6 = "BLACK";

    private String sizeListValue1 = "15";
    private String sizeListValue2 = "20";
    private String sizeListValue3 = "30";
    private String sizeListValue4 = "40";
    private String sizeListValue5 = "50";

    private int mainMenuWidth = 350;
    private int mainMenuHeight = 350;

    private int settingGUIWidth = 550;
    private int settingGUIHeight = 300;

    private int sizeOfGame = 15;

    private int roomWidth = 20;
    private int roomHeight = 20;

    private int colorChangeSleepTimeMS = 1;

    private Color colorFace = Color.RED;
    private Color colorMouse = Color.GRAY;
    private Color colorSnake = Color.GREEN;
    private Color colorHead = Color.BLACK;

    private boolean changeColor = true;

    /* Go to pause 2 thread in method changeColorOfLabel if waitThread is true */
    private boolean mainMenuWaitThread = false;

    private boolean mainMenuFullScreen = true;

    private Setting() {
    }

    public static Setting getInstance() {
        if (ourInstance == null) {
            synchronized (Setting.class) {
                if (ourInstance == null) {
                    ourInstance = new Setting();
                }
            }
        }
        return ourInstance;
    }

    @Contract(pure = true)
    public static String getAUTHOR() {
        return AUTHOR;
    }

    public String getMainMenuGUIJFrameTitle() {
        return mainMenuGUIJFrameTitle;
    }

    public void setMainMenuGUIJFrameTitle(String mainMenuGUIJFrameTitle) {
        this.mainMenuGUIJFrameTitle = mainMenuGUIJFrameTitle;
    }

    public String getPlayJFrameTitle() {
        return playJFrameTitle;
    }

    public void setPlayJFrameTitle(String playJFrameTitle) {
        this.playJFrameTitle = playJFrameTitle;
    }

    public String getSettingGUIJFrameTitle() {
        return settingGUIJFrameTitle;
    }

    public void setSettingGUIJFrameTitle(String settingGUIJFrameTitle) {
        this.settingGUIJFrameTitle = settingGUIJFrameTitle;
    }

    public String getMainMenuGUIJLabelWelcome() {
        return mainMenuGUIJLabelWelcome;
    }

    public void setMainMenuGUIJLabelWelcome(String mainMenuGUIJLabelWelcome) {
        this.mainMenuGUIJLabelWelcome = mainMenuGUIJLabelWelcome;
    }

    public String getMainMenuGUIJButtonPlay() {
        return mainMenuGUIJButtonPlay;
    }

    public void setMainMenuGUIJButtonPlay(String mainMenuGUIJButtonPlay) {
        this.mainMenuGUIJButtonPlay = mainMenuGUIJButtonPlay;
    }

    public String getMainMenuGUIJButtonSetting() {
        return mainMenuGUIJButtonSetting;
    }

    public void setMainMenuGUIJButtonSetting(String mainMenuGUIJButtonSetting) {
        this.mainMenuGUIJButtonSetting = mainMenuGUIJButtonSetting;
    }

    public String getMainMenuGUIJButtonInfo() {
        return mainMenuGUIJButtonInfo;
    }

    public void setMainMenuGUIJButtonInfo(String mainMenuGUIJButtonInfo) {
        this.mainMenuGUIJButtonInfo = mainMenuGUIJButtonInfo;
    }

    public String getMainMenuGUIJButtonExit() {
        return mainMenuGUIJButtonExit;
    }

    public void setMainMenuGUIJButtonExit(String mainMenuGUIJButtonExit) {
        this.mainMenuGUIJButtonExit = mainMenuGUIJButtonExit;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getColor3() {
        return color3;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public String getColor4() {
        return color4;
    }

    public void setColor4(String color4) {
        this.color4 = color4;
    }

    public String getColor5() {
        return color5;
    }

    public void setColor5(String color5) {
        this.color5 = color5;
    }

    public String getColor6() {
        return color6;
    }

    public void setColor6(String color6) {
        this.color6 = color6;
    }

    public String getSizeListValue1() {
        return sizeListValue1;
    }

    public void setSizeListValue1(String sizeListValue1) {
        this.sizeListValue1 = sizeListValue1;
    }

    public String getSizeListValue2() {
        return sizeListValue2;
    }

    public void setSizeListValue2(String sizeListValue2) {
        this.sizeListValue2 = sizeListValue2;
    }

    public String getSizeListValue3() {
        return sizeListValue3;
    }

    public void setSizeListValue3(String sizeListValue3) {
        this.sizeListValue3 = sizeListValue3;
    }

    public String getSizeListValue4() {
        return sizeListValue4;
    }

    public void setSizeListValue4(String sizeListValue4) {
        this.sizeListValue4 = sizeListValue4;
    }

    public String getSizeListValue5() {
        return sizeListValue5;
    }

    public void setSizeListValue5(String sizeListValue5) {
        this.sizeListValue5 = sizeListValue5;
    }

    public int getMainMenuWidth() {
        return mainMenuWidth;
    }

    public void setMainMenuWidth(int mainMenuWidth) {
        this.mainMenuWidth = mainMenuWidth;
    }

    public int getMainMenuHeight() {
        return mainMenuHeight;
    }

    public void setMainMenuHeight(int mainMenuHeight) {
        this.mainMenuHeight = mainMenuHeight;
    }

    public int getSettingGUIWidth() {
        return settingGUIWidth;
    }

    public void setSettingGUIWidth(int settingGUIWidth) {
        this.settingGUIWidth = settingGUIWidth;
    }

    public int getSettingGUIHeight() {
        return settingGUIHeight;
    }

    public void setSettingGUIHeight(int settingGUIHeight) {
        this.settingGUIHeight = settingGUIHeight;
    }

    public int getSizeOfGame() {
        return sizeOfGame;
    }

    public void setSizeOfGame(int sizeOfGame) {
        this.sizeOfGame = sizeOfGame;
    }

    public int getRoomWidth() {
        return roomWidth;
    }

    public void setRoomWidth(int roomWidth) {
        this.roomWidth = roomWidth;
    }

    public int getRoomHeight() {
        return roomHeight;
    }

    public void setRoomHeight(int roomHeight) {
        this.roomHeight = roomHeight;
    }

    public int getColorChangeSleepTimeMS() {
        return colorChangeSleepTimeMS;
    }

    public void setColorChangeSleepTimeMS(int colorChangeSleepTimeMS) {
        this.colorChangeSleepTimeMS = colorChangeSleepTimeMS;
    }

    public Color getColorFace() {
        return colorFace;
    }

    public void setColorFace(Color colorFace) {
        this.colorFace = colorFace;
    }

    public Color getColorMouse() {
        return colorMouse;
    }

    public void setColorMouse(Color colorMouse) {
        this.colorMouse = colorMouse;
    }

    public Color getColorSnake() {
        return colorSnake;
    }

    public void setColorSnake(Color colorSnake) {
        this.colorSnake = colorSnake;
    }

    public Color getColorHead() {
        return colorHead;
    }

    public void setColorHead(Color colorHead) {
        this.colorHead = colorHead;
    }

    public boolean isChangeColor() {
        return changeColor;
    }

    public void setChangeColor(boolean changeColor) {
        this.changeColor = changeColor;
    }

    public boolean isMainMenuWaitThread() {
        return mainMenuWaitThread;
    }

    public void setMainMenuWaitThread(boolean mainMenuWaitThread) {
        this.mainMenuWaitThread = mainMenuWaitThread;
    }

    public boolean isMainMenuFullScreen() {
        return mainMenuFullScreen;
    }

    public void setMainMenuFullScreen(boolean mainMenuFullScreen) {
        this.mainMenuFullScreen = mainMenuFullScreen;
    }
}
