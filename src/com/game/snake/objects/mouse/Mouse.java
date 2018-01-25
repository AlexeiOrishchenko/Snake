package com.game.snake.objects.mouse;

import org.jetbrains.annotations.Contract;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is the mouse
 * We can not extends this class
 */
public final class Mouse {

    /* The coordinate of the mouse */
    private final int x;
    private final int y;

    public Mouse(int x, int y) {
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
}
