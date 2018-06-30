package com.qthegamep.snake.model;

import com.qthegamep.snake.model.objects.mouse.Mouse;
import com.qthegamep.snake.model.objects.room.Room;
import com.qthegamep.snake.model.objects.snake.Snake;
import com.qthegamep.snake.model.objects.snake.SnakeDirection;
import com.qthegamep.snake.model.objects.snake.SnakeSection;

import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.17
 *
 * Implement this interface if you need full access to the model
 * or you need to change something in the model
 */
public interface ModelInterfaceExtended extends ModelInterface {

    Snake getSnake();

    void setSnake(final Snake snake);

    boolean isSnakeAlive();

    void setSnakeAlive(final boolean alive);

    SnakeDirection getSnakeDirection();

    void setSnakeDirection(final SnakeDirection direction);

    List<SnakeSection> getSnakeSections();

    void setSnakeSections(final List<SnakeSection> sections);

    int getSnakeSectionsX(final int i);

    int getSnakeSectionsY(final int i);

    int getSnakeHeadX();

    int getSnakeHeadY();

    Mouse getMouse();

    void setMouse(final Mouse mouse);

    int getMouseX();

    int getMouseY();

    Room getRoom();

    int getRoomWidth();

    void setRoomWidth(final int width);

    int getRoomHeight();

    void setRoomHeight(final int height);
}
