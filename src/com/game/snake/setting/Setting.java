package com.game.snake.setting;

import org.jetbrains.annotations.Contract;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class contains main parameters of the game
 */
public class Setting {

    private static int sizeOfGame = 15;

    private static int mainMenuWidth = 300;
    private static int mainMenuHeight = 300;

    private static String author = "Author: Nikita Koliadin";
    private static String mail = "Mail: qThegamEp@gmail.com";
    private static String facebook = "Facebook: https://www.facebook.com/koliadin.nikita";
    private static String instagram = "Instagram: https://www.instagram.com/koliadin_nik/";
    private static String gitHub ="Github: https://github.com/qThegamEp";
    private static String skype ="Skype: koliadin321";

    private static int roomWidth = 20;
    private static int roomHeight = 20;

    private static int exitWidth = 320;
    private static int exitHeight = 320;

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
    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        Setting.author = author;
    }

    @Contract(pure = true)
    public static String getMail() {
        return mail;
    }

    public static void setMail(String mail) {
        Setting.mail = mail;
    }

    @Contract(pure = true)
    public static String getFacebook() {
        return facebook;
    }

    public static void setFacebook(String facebook) {
        Setting.facebook = facebook;
    }

    @Contract(pure = true)
    public static String getInstagram() {
        return instagram;
    }

    public static void setInstagram(String instagram) {
        Setting.instagram = instagram;
    }

    @Contract(pure = true)
    public static String getGitHub() {
        return gitHub;
    }

    public static void setGitHub(String gitHub) {
        Setting.gitHub = gitHub;
    }

    @Contract(pure = true)
    public static String getSkype() {
        return skype;
    }

    public static void setSkype(String skype) {
        Setting.skype = skype;
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
}
