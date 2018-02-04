package com.game.snake.setting;

import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.8
 *
 * This class contains main parameters of the game
 */
public class Setting {

    private static final String AUTHOR = "Author: Nikita Koliadin";

    private static String mainMenuGUIJFrameTitle = "Snake - MAIN MENU";
    private static String playJFrameTitle = "Snake - PLAY"; // FIXME: 04.02.2018
    private static String settingGUIJFrameTitle = "Snake - SETTING";
    private static String infoGUIJFrameTitle = "Snake - INFO";
    private static String exitGUIJFrameTitle = "Snake - EXIT";

    private static String mainMenuGUIJLabelWelcome = "Welcome to the game \"SNAKE\"";
    private static String mainMenuGUIJButtonPlay = "PLAY";
    private static String mainMenuGUIJButtonSetting = "SETTING";
    private static String mainMenuGUIJButtonInfo = "INFO";
    private static String mainMenuGUIJButtonExit = "EXIT";

    private static String infoDataCreate = "01.28.2018 - Ukraine - Dnipro";
    private static String infoMail = "Mail: qThegamEp@gmail.com";
    private static String infoFacebook = "Facebook: https://www.facebook.com/koliadin.nikita";
    private static String infoInstagram = "Instagram: https://www.instagram.com/koliadin_nik/";
    private static String infoGitHub = "Github: https://github.com/qThegamEp";
    private static String infoSkype = "Skype: koliadin321";
    private static String infoThanks = "!!!Thank you for playing this game!!!";

    private static String color1 = "RED";
    private static String color2 = "GREEN";
    private static String color3 = "BLUE";
    private static String color4 = "YELLOW";
    private static String color5 = "GRAY";
    private static String color6 = "BLACK";

    private static String sizeListValue1 = "15";
    private static String sizeListValue2 = "20";
    private static String sizeListValue3 = "30";
    private static String sizeListValue4 = "40";
    private static String sizeListValue5 = "50";

    private static List<JLabel> exitGUIJLabelList = new ArrayList<JLabel>(Arrays.asList(
            new JLabel(Setting.getInfoThanks())));

    private static List<JLabel> infoGUIJLabelList = new ArrayList<JLabel>(Arrays.asList( // FIXME: 04.02.2018
            new JLabel(Setting.getAUTHOR()),
            new JLabel(Setting.getInfoDataCreate()),
            new JLabel(Setting.getInfoMail()),
            new JLabel(Setting.getInfoFacebook()),
            new JLabel(Setting.getInfoInstagram()),
            new JLabel(Setting.getInfoGitHub()),
            new JLabel(Setting.getInfoSkype()),
            new JLabel(Setting.getInfoThanks())
    ));

    private static int mainMenuWidth = 350;
    private static int mainMenuHeight = 350;

    private static int settingGUIWidth = 550;
    private static int settingGUIHeight = 300;

    private static int infoGUIWidth = 350;
    private static int infoGUIHeight = 350;

    private static int exitGUIWidth = 320;
    private static int exitGUIHeight = 320;

    private static int sizeOfGame = 15;

    private static int roomWidth = 20;
    private static int roomHeight = 20;

    private static int colorChangeSleepTimeMS = 1;

    private static int exitGUISleepTimeMS = 3000;

    private static Color colorFace = Color.RED;
    private static Color colorMouse = Color.GRAY;
    private static Color colorSnake = Color.GREEN;

    private static boolean changeColor = true;

    /* Go to pause 2 thread in method changeColorOfLabel if waitThread is true */
    private static boolean mainMenuWaitThread = false;

    private static boolean mainMenuFullScreen = true;

    @Contract(pure = true)
    public static String getAUTHOR() {
        return AUTHOR;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJFrameTitle() {
        return mainMenuGUIJFrameTitle;
    }

    public static void setMainMenuGUIJFrameTitle(String mainMenuGUIJFrameTitle) {
        Setting.mainMenuGUIJFrameTitle = mainMenuGUIJFrameTitle;
    }

    @Contract(pure = true)
    public static String getPlayJFrameTitle() {
        return playJFrameTitle;
    }

    public static void setPlayJFrameTitle(String playJFrameTitle) {
        Setting.playJFrameTitle = playJFrameTitle;
    }

    @Contract(pure = true)
    public static String getInfoGUIJFrameTitle() {
        return infoGUIJFrameTitle;
    }

    public static void setInfoGUIJFrameTitle(String infoGUIJFrameTitle) {
        Setting.infoGUIJFrameTitle = infoGUIJFrameTitle;
    }

    @Contract(pure = true)
    public static String getSettingGUIJFrameTitle() {
        return settingGUIJFrameTitle;
    }

    public static void setSettingGUIJFrameTitle(String settingGUIJFrameTitle) {
        Setting.settingGUIJFrameTitle = settingGUIJFrameTitle;
    }

    @Contract(pure = true)
    public static String getExitGUIJFrameTitle() {
        return exitGUIJFrameTitle;
    }

    public static void setExitGUIJFrameTitle(String exitGUIJFrameTitle) {
        Setting.exitGUIJFrameTitle = exitGUIJFrameTitle;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJLabelWelcome() {
        return mainMenuGUIJLabelWelcome;
    }

    public static void setMainMenuGUIJLabelWelcome(String mainMenuGUIJLabelWelcome) {
        Setting.mainMenuGUIJLabelWelcome = mainMenuGUIJLabelWelcome;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJButtonPlay() {
        return mainMenuGUIJButtonPlay;
    }

    public static void setMainMenuGUIJButtonPlay(String mainMenuGUIJButtonPlay) {
        Setting.mainMenuGUIJButtonPlay = mainMenuGUIJButtonPlay;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJButtonSetting() {
        return mainMenuGUIJButtonSetting;
    }

    public static void setMainMenuGUIJButtonSetting(String mainMenuGUIJButtonSetting) {
        Setting.mainMenuGUIJButtonSetting = mainMenuGUIJButtonSetting;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJButtonInfo() {
        return mainMenuGUIJButtonInfo;
    }

    public static void setMainMenuGUIJButtonInfo(String mainMenuGUIJButtonInfo) {
        Setting.mainMenuGUIJButtonInfo = mainMenuGUIJButtonInfo;
    }

    @Contract(pure = true)
    public static String getMainMenuGUIJButtonExit() {
        return mainMenuGUIJButtonExit;
    }

    public static void setMainMenuGUIJButtonExit(String mainMenuGUIJButtonExit) {
        Setting.mainMenuGUIJButtonExit = mainMenuGUIJButtonExit;
    }

    @Contract(pure = true)
    public static String getInfoDataCreate() {
        return infoDataCreate;
    }

    public static void setInfoDataCreate(String infoDataCreate) {
        Setting.infoDataCreate = infoDataCreate;
    }

    @Contract(pure = true)
    public static String getInfoMail() {
        return infoMail;
    }

    public static void setInfoMail(String infoMail) {
        Setting.infoMail = infoMail;
    }

    @Contract(pure = true)
    public static String getInfoFacebook() {
        return infoFacebook;
    }

    public static void setInfoFacebook(String infoFacebook) {
        Setting.infoFacebook = infoFacebook;
    }

    @Contract(pure = true)
    public static String getInfoInstagram() {
        return infoInstagram;
    }

    public static void setInfoInstagram(String infoInstagram) {
        Setting.infoInstagram = infoInstagram;
    }

    @Contract(pure = true)
    public static String getInfoGitHub() {
        return infoGitHub;
    }

    public static void setInfoGitHub(String infoGitHub) {
        Setting.infoGitHub = infoGitHub;
    }

    @Contract(pure = true)
    public static String getInfoSkype() {
        return infoSkype;
    }

    public static void setInfoSkype(String infoSkype) {
        Setting.infoSkype = infoSkype;
    }

    @Contract(pure = true)
    public static String getInfoThanks() {
        return infoThanks;
    }

    public static void setInfoThanks(String infoThanks) {
        Setting.infoThanks = infoThanks;
    }

    @Contract(pure = true)
    public static String getColor1() {
        return color1;
    }

    public static void setColor1(String color1) {
        Setting.color1 = color1;
    }

    @Contract(pure = true)
    public static String getColor2() {
        return color2;
    }

    public static void setColor2(String color2) {
        Setting.color2 = color2;
    }

    @Contract(pure = true)
    public static String getColor3() {
        return color3;
    }

    public static void setColor3(String color3) {
        Setting.color3 = color3;
    }

    @Contract(pure = true)
    public static String getColor4() {
        return color4;
    }

    public static void setColor4(String color4) {
        Setting.color4 = color4;
    }

    @Contract(pure = true)
    public static String getColor5() {
        return color5;
    }

    public static void setColor5(String color5) {
        Setting.color5 = color5;
    }

    @Contract(pure = true)
    public static String getColor6() {
        return color6;
    }

    public static void setColor6(String color6) {
        Setting.color6 = color6;
    }

    @Contract(pure = true)
    public static String getSizeListValue1() {
        return sizeListValue1;
    }

    public static void setSizeListValue1(String sizeListValue1) {
        Setting.sizeListValue1 = sizeListValue1;
    }

    @Contract(pure = true)
    public static String getSizeListValue2() {
        return sizeListValue2;
    }

    public static void setSizeListValue2(String sizeListValue2) {
        Setting.sizeListValue2 = sizeListValue2;
    }

    @Contract(pure = true)
    public static String getSizeListValue3() {
        return sizeListValue3;
    }

    public static void setSizeListValue3(String sizeListValue3) {
        Setting.sizeListValue3 = sizeListValue3;
    }

    @Contract(pure = true)
    public static String getSizeListValue4() {
        return sizeListValue4;
    }

    public static void setSizeListValue4(String sizeListValue4) {
        Setting.sizeListValue4 = sizeListValue4;
    }

    @Contract(pure = true)
    public static String getSizeListValue5() {
        return sizeListValue5;
    }

    public static void setSizeListValue5(String sizeListValue5) {
        Setting.sizeListValue5 = sizeListValue5;
    }

    @Contract(pure = true)
    public static int getSizeOfGame() {
        return sizeOfGame;
    }

    public static void setSizeOfGame(int sizeOfGame) {
        Setting.sizeOfGame = sizeOfGame;
    }

    @Contract(pure = true)
    public static int getMainMenuWidth() {
        return mainMenuWidth;
    }

    public static void setMainMenuWidth(int mainMenuWidth) {
        Setting.mainMenuWidth = mainMenuWidth;
    }

    @Contract(pure = true)
    public static int getMainMenuHeight() {
        return mainMenuHeight;
    }

    public static void setMainMenuHeight(int mainMenuHeight) {
        Setting.mainMenuHeight = mainMenuHeight;
    }

    @Contract(pure = true)
    public static int getSettingGUIWidth() {
        return settingGUIWidth;
    }

    public static void setSettingGUIWidth(int settingGUIWidth) {
        Setting.settingGUIWidth = settingGUIWidth;
    }

    @Contract(pure = true)
    public static int getSettingGUIHeight() {
        return settingGUIHeight;
    }

    public static void setSettingGUIHeight(int settingGUIHeight) {
        Setting.settingGUIHeight = settingGUIHeight;
    }

    @Contract(pure = true)
    public static int getInfoGUIWidth() {
        return infoGUIWidth;
    }

    public static void setInfoGUIWidth(int infoGUIWidth) {
        Setting.infoGUIWidth = infoGUIWidth;
    }

    @Contract(pure = true)
    public static int getInfoGUIHeight() {
        return infoGUIHeight;
    }

    public static void setInfoGUIHeight(int infoGUIHeight) {
        Setting.infoGUIHeight = infoGUIHeight;
    }

    @Contract(pure = true)
    public static int getExitGUIWidth() {
        return exitGUIWidth;
    }

    public static void setExitGUIWidth(int exitGUIWidth) {
        Setting.exitGUIWidth = exitGUIWidth;
    }

    @Contract(pure = true)
    public static int getExitGUIHeight() {
        return exitGUIHeight;
    }

    public static void setExitGUIHeight(int exitGUIHeight) {
        Setting.exitGUIHeight = exitGUIHeight;
    }

    @Contract(pure = true)
    public static int getRoomWidth() {
        return roomWidth;
    }

    public static void setRoomWidth(int roomWidth) {
        Setting.roomWidth = roomWidth;
    }

    @Contract(pure = true)
    public static int getRoomHeight() {
        return roomHeight;
    }

    public static void setRoomHeight(int roomHeight) {
        Setting.roomHeight = roomHeight;
    }

    @Contract(pure = true)
    public static int getColorChangeSleepTimeMS() {
        return colorChangeSleepTimeMS;
    }

    public static void setColorChangeSleepTimeMS(int colorChangeSleepTimeMS) {
        Setting.colorChangeSleepTimeMS = colorChangeSleepTimeMS;
    }

    @Contract(pure = true)
    public static Color getColorFace() {
        return colorFace;
    }

    public static void setColorFace(Color colorFace) {
        Setting.colorFace = colorFace;
    }

    @Contract(pure = true)
    public static Color getColorMouse() {
        return colorMouse;
    }

    public static void setColorMouse(Color colorMouse) {
        Setting.colorMouse = colorMouse;
    }

    @Contract(pure = true)
    public static Color getColorSnake() {
        return colorSnake;
    }

    public static void setColorSnake(Color colorSnake) {
        Setting.colorSnake = colorSnake;
    }

    @Contract(pure = true)
    public static boolean isChangeColor() {
        return changeColor;
    }

    public static void setChangeColor(boolean changeColor) {
        Setting.changeColor = changeColor;
    }

    @Contract(pure = true)
    public static boolean isMainMenuWaitThread() {
        return mainMenuWaitThread;
    }

    public static void setMainMenuWaitThread(boolean mainMenuWaitThread) {
        Setting.mainMenuWaitThread = mainMenuWaitThread;
    }

    @Contract(pure = true)
    public static boolean isMainMenuFullScreen() {
        return mainMenuFullScreen;
    }

    public static void setMainMenuFullScreen(boolean mainMenuFullScreen) {
        Setting.mainMenuFullScreen = mainMenuFullScreen;
    }

    @Contract(pure = true)
    public static List<JLabel> getExitGUIJLabelList() {
        return exitGUIJLabelList;
    }

    public static void setExitGUIJLabelList(List<JLabel> exitGUIJLabelList) {
        Setting.exitGUIJLabelList = exitGUIJLabelList;
    }

    @Contract(pure = true)
    public static int getExitGUISleepTimeMS() {
        return exitGUISleepTimeMS;
    }

    public static void setExitGUISleepTimeMS(int exitGUISleepTimeMS) {
        Setting.exitGUISleepTimeMS = exitGUISleepTimeMS;
    }

    @Contract(pure = true)
    public static List<JLabel> getInfoGUIJLabelList() {
        return infoGUIJLabelList;
    }

    public static void setInfoGUIJLabelList(List<JLabel> infoGUIJLabelList) {
        Setting.infoGUIJLabelList = infoGUIJLabelList;
    }
}

