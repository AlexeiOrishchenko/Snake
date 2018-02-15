package com.game.snake.objects.mouse;

import org.jetbrains.annotations.Contract;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public final class Mouse {

    private final int x;
    private final int y;

    public Mouse(final int x, final int y) {
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
