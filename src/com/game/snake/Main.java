package com.game.snake;

import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.Snake;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is main class
 */
public class Main {
    public static void main(String[] args) {
        Room.room = new Room(15, 10, new Snake());
        Room.room.createMouse();
        Room.room.run();
    }
}
