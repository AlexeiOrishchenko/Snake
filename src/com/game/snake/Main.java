package com.game.snake;

import com.game.snake.objects.Room;
import com.game.snake.objects.Snake;
import com.game.snake.objects.SnakeDirection;

/**
 * @author Koliadin Nikita
 * @version 1.1
 * <p>This class is main class</p>
 */
public class Main {
    public static void main(String[] args) {
        Room.game = new Room(50, 50, new Snake(10, 10));
        Room.game.getSnake().setDirection(SnakeDirection.DOWN);
        Room.game.createMouse();
        Room.game.run();
    }
}
