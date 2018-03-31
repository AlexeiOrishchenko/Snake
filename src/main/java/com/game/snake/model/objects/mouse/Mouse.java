package com.game.snake.model.objects.mouse;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Mouse implements Serializable {

    private int x;
    private int y;
}
