package com.game.snake.model.objects.mouse;

import lombok.Getter;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public final class Mouse {

    @Getter private final int x;
    @Getter private final int y;

    public Mouse(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
