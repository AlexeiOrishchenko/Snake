package com.game.snake.model;

import com.game.snake.model.objects.mouse.Mouse;
import com.game.snake.model.objects.room.Room;
import com.game.snake.model.objects.snake.Snake;
import com.game.snake.model.objects.snake.SnakeDirection;
import com.game.snake.model.objects.snake.SnakeSection;

import lombok.val;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class Model implements ModelInterfaceExtended {

    private static volatile Model instance;

    private Model() {
    }

    public static Model getInstance() {
        if (Model.instance == null) {
            synchronized (Model.class) {
                if (Model.instance == null) {
                    Model.instance = new Model();
                }
            }
        }
        return Model.instance;
    }

    @Override
    public void startGame() {
        val executor = Executors.newSingleThreadExecutor();
        executor.execute(Room.getInstance());
        executor.shutdown();
    }

    @Override
    public Snake getSnake() {
        return Room.getInstance().getSnake();
    }

    @Override
    public void setSnake(Snake snake) {
        getRoom().setSnake(snake);
    }

    @Override
    public boolean isSnakeAlive() {
        return getSnake().isAlive();
    }

    @Override
    public void setSnakeAlive(final boolean alive) {
        getSnake().setAlive(alive);
    }

    @Override
    public SnakeDirection getSnakeDirection() {
        return getSnake().getDirection();
    }

    @Override
    public void setSnakeDirection(final SnakeDirection direction) {
        getSnake().setDirection(direction);
    }

    @Override
    public List<SnakeSection> getSnakeSections() {
        return getSnake().getSections();
    }

    @Override
    public void setSnakeSections(final List<SnakeSection> sections) {
        getSnake().setSections(sections);
    }

    @Override
    public int getSnakeSectionsX(final int i) {
        return getSnakeSections().get(i).getX();
    }

    @Override
    public int getSnakeSectionsY(final int i) {
        return getSnakeSections().get(i).getY();
    }

    @Override
    public int getSnakeHeadX() {
        return getSnake().getHeadX();
    }

    @Override
    public int getSnakeHeadY() {
        return getSnake().getHeadY();
    }

    @Override
    public Mouse getMouse() {
        return Room.getInstance().getMouse();
    }

    @Override
    public void setMouse(Mouse mouse) {
        getRoom().setMouse(mouse);
    }

    @Override
    public int getMouseX() {
        return getMouse().getX();
    }

    @Override
    public int getMouseY() {
        return getMouse().getY();
    }

    @Override
    public Room getRoom() {
        return Room.getInstance();
    }

    @Override
    public int getRoomWidth() {
        return getRoom().getWidth();
    }

    @Override
    public void setRoomWidth(int width) {
        getRoom().setWidth(width);
    }

    @Override
    public int getRoomHeight() {
        return getRoom().getHeight();
    }

    @Override
    public void setRoomHeight(int height) {
        getRoom().setHeight(height);
    }
}
