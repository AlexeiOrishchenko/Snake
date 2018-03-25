package com.game.snake.model.objects.snake;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SnakeTest {

    private Snake snake;

    @Before
    public void createSnake() {
        snake = new Snake();
    }

    @Test
    public void checkSnakeCreate() {
        assertEquals(snake.getSections().size(), 3);
        assertEquals(snake.getDirection(), SnakeDirection.DOWN);
        assertTrue(snake.isAlive());
    }

    @Test
    public void getHeadX() {
        assertEquals(snake.getHeadX(), 1);
        snake.getSections().add(0, new SnakeSection(1, 4));
        assertEquals(snake.getHeadX(), 1);
    }

    @Test
    public void getHeadY() {
        assertEquals(snake.getHeadY(), 3);
        snake.getSections().add(0, new SnakeSection(1,4));
        assertEquals(snake.getHeadY(), 4);
    }

    @Test
    public void move() {
    }

    @Test
    public void getSections() {
        assertNotNull(snake.getSections());
    }

    @Test
    public void getDirection() {
        assertEquals(snake.getDirection(), SnakeDirection.DOWN);
    }

    @Test
    public void isAlive() {
        assertEquals(snake.isAlive(), true);
    }

    @Test
    public void setDirection() {
        snake.setDirection(SnakeDirection.LEFT);
        assertEquals(snake.getDirection(), SnakeDirection.LEFT);
    }
}