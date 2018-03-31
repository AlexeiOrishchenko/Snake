package com.game.snake.model.objects.snake;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class SnakeSection implements Serializable {

    private int x;
    private int y;
}
