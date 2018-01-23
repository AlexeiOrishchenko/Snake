package com.game.snake.objects.snake;

import org.jetbrains.annotations.Contract;

import java.util.Objects;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is the part of the snake.
 * We can not extends this class.
 */
public final class SnakeSection {

    /* The coordinate of the snakes section */
    private final int x;
    private final int y;

    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Contract(pure = true)
    public int getX() {
        return x;
    }

    @Contract(pure = true)
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SnakeSection)) {
            return false;
        }
        SnakeSection that = (SnakeSection) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
