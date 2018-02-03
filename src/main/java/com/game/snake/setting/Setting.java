package com.game.snake.setting;

import org.jetbrains.annotations.Contract;

import java.awt.*;

/**
 * @author Koliadin Nikita
 * @version 1.6
 *
 * This class contains main parameters of the game
 */
public class Setting {

    private static final String AUTHOR = "Author: Nikita Koliadin";

    private static String mainMenuJFrameTitle = "Snake - MAIN MENU";
    private static String playJFrameTitle = "Snake - PLAY";
    private static String infoJFrameTitle = "Snake - INFO";
    private static String settingJFrameTitle = "Snake - SETTING";
    private static String exitJFrameTitle = "Snake - EXIT";

    private static String mainMenuJLabelWelcome = "Welcome to the game \"SNAKE\"";
    private static String mainMenuJButtonPlay = "PLAY";
    private static String mainMenuJButtonSetting = "SETTING";
    private static String mainMenuJButtonInfo = "INFO";
    private static String mainMenuJButtonExit = "EXIT";

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

    private static int sizeOfGame = 15;

    private static int mainMenuWidth = 350;
    private static int mainMenuHeight = 350;

    private static int settingWidth = 550;
    private static int settingHeight = 300;

    private static int infoWidth = 350;
    private static int infoHeight = 350;

    private static int exitWidth = 320;
    private static int exitHeight = 320;

    private static int roomWidth = 20;
    private static int roomHeight = 20;

    private static int sleepColorChangeTimeMS = 5;

    private static Color colorFace = Color.RED;
    private static Color colorMouse = Color.GRAY;
    private static Color colorSnake = Color.GREEN;

    private static boolean changeColor = true;

    /* Go to pause 2 thread in method changeColorOfLabel if waitThread is true */
    private static boolean waitThreadMainMenu = false;

    private static boolean fullScreenMainMenu = true;

    @Contract(pure = true)
    public static String getAUTHOR() {
        return AUTHOR;
    }

    @Contract(pure = true)
    public static String getMainMenuJFrameTitle() {
        return mainMenuJFrameTitle;
    }

    public static void setMainMenuJFrameTitle(String mainMenuJFrameTitle) {
        Setting.mainMenuJFrameTitle = mainMenuJFrameTitle;
    }

    @Contract(pure = true)
    public static String getPlayJFrameTitle() {
        return playJFrameTitle;
    }

    public static void setPlayJFrameTitle(String playJFrameTitle) {
        Setting.playJFrameTitle = playJFrameTitle;
    }

    @Contract(pure = true)
    public static String getInfoJFrameTitle() {
        return infoJFrameTitle;
    }

    public static void setInfoJFrameTitle(String infoJFrameTitle) {
        Setting.infoJFrameTitle = infoJFrameTitle;
    }

    @Contract(pure = true)
    public static String getSettingJFrameTitle() {
        return settingJFrameTitle;
    }

    public static void setSettingJFrameTitle(String settingJFrameTitle) {
        Setting.settingJFrameTitle = settingJFrameTitle;
    }

    @Contract(pure = true)
    public static String getExitJFrameTitle() {
        return exitJFrameTitle;
    }

    public static void setExitJFrameTitle(String exitJFrameTitle) {
        Setting.exitJFrameTitle = exitJFrameTitle;
    }

    @Contract(pure = true)
    public static String getMainMenuJLabelWelcome() {
        return mainMenuJLabelWelcome;
    }

    public static void setMainMenuJLabelWelcome(String mainMenuJLabelWelcome) {
        Setting.mainMenuJLabelWelcome = mainMenuJLabelWelcome;
    }

    @Contract(pure = true)
    public static String getMainMenuJButtonPlay() {
        return mainMenuJButtonPlay;
    }

    public static void setMainMenuJButtonPlay(String mainMenuJButtonPlay) {
        Setting.mainMenuJButtonPlay = mainMenuJButtonPlay;
    }

    @Contract(pure = true)
    public static String getMainMenuJButtonSetting() {
        return mainMenuJButtonSetting;
    }

    public static void setMainMenuJButtonSetting(String mainMenuJButtonSetting) {
        Setting.mainMenuJButtonSetting = mainMenuJButtonSetting;
    }

    @Contract(pure = true)
    public static String getMainMenuJButtonInfo() {
        return mainMenuJButtonInfo;
    }

    public static void setMainMenuJButtonInfo(String mainMenuJButtonInfo) {
        Setting.mainMenuJButtonInfo = mainMenuJButtonInfo;
    }

    @Contract(pure = true)
    public static String getMainMenuJButtonExit() {
        return mainMenuJButtonExit;
    }

    public static void setMainMenuJButtonExit(String mainMenuJButtonExit) {
        Setting.mainMenuJButtonExit = mainMenuJButtonExit;
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
    public static int getSettingWidth() {
        return settingWidth;
    }

    public static void setSettingWidth(int settingWidth) {
        Setting.settingWidth = settingWidth;
    }

    @Contract(pure = true)
    public static int getSettingHeight() {
        return settingHeight;
    }

    public static void setSettingHeight(int settingHeight) {
        Setting.settingHeight = settingHeight;
    }

    @Contract(pure = true)
    public static int getInfoWidth() {
        return infoWidth;
    }

    public static void setInfoWidth(int infoWidth) {
        Setting.infoWidth = infoWidth;
    }

    @Contract(pure = true)
    public static int getInfoHeight() {
        return infoHeight;
    }

    public static void setInfoHeight(int infoHeight) {
        Setting.infoHeight = infoHeight;
    }

    @Contract(pure = true)
    public static int getExitWidth() {
        return exitWidth;
    }

    public static void setExitWidth(int exitWidth) {
        Setting.exitWidth = exitWidth;
    }

    @Contract(pure = true)
    public static int getExitHeight() {
        return exitHeight;
    }

    public static void setExitHeight(int exitHeight) {
        Setting.exitHeight = exitHeight;
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
    public static int getSleepColorChangeTimeMS() {
        return sleepColorChangeTimeMS;
    }

    public static void setSleepColorChangeTimeMS(int sleepColorChangeTimeMS) {
        Setting.sleepColorChangeTimeMS = sleepColorChangeTimeMS;
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
    public static boolean isWaitThreadMainMenu() {
        return waitThreadMainMenu;
    }

    public static void setWaitThreadMainMenu(boolean waitThreadMainMenu) {
        Setting.waitThreadMainMenu = waitThreadMainMenu;
    }

    @Contract(pure = true)
    public static boolean isFullScreenMainMenu() {
        return fullScreenMainMenu;
    }

    public static void setFullScreenMainMenu(boolean fullScreenMainMenu) {
        Setting.fullScreenMainMenu = fullScreenMainMenu;
    }
}

