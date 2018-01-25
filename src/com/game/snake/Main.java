package com.game.snake;


import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.Snake;
import com.game.snake.setting.Setting;

/**
 * @author Koliadin Nikita
 * @version 1.3
 *
 * This class  emulate GUI, in future will be GUI
 */
public class Main {
    public static void main(String[] args) {
        Room.room = new Room(20, 20, new Snake());
        Setting.setSizeOfGame(15);
        Room.room.createMouse();
        Room.room.run();
    }
}
