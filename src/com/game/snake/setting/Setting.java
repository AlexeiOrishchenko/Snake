package com.game.snake.setting;

import org.jetbrains.annotations.Contract;

/**
 * @author Koliadin Nikita
 * @version 1.3
 *
 * This class will be the setting of main parametr of the game
 */
public class Setting {

    private static int sizeOfGame;

    @Contract(pure = true)
    public static int getSizeOfGame() {
        return sizeOfGame;
    }

    public static void setSizeOfGame(int sizeOfGame) {
        Setting.sizeOfGame = sizeOfGame;
    }
}
