package com.game.snake.graphics;

import com.game.snake.setting.Setting;
import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.SnakeSection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class is Graphic class
 */
public final class Layer extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        final int size = Setting.getSizeOfGame();

        final int width = Setting.getRoomWidth() + 2;
        final int height = Setting.getRoomHeight() + 2;


        /* Red color of face */
        g.setColor(java.awt.Color.RED);
        /* Draw a rectangle showing the edge of the field to the right */
        g.fillRect(width * size, 0, size, (height * size));
        /* Draw a rectangle showing the edge of the field to the down */
        g.fillRect(0, height * size, (width * size) + size, size);
        /* Draw a rectangle showing the edge of the field to the left */
        g.fillRect(0, 0, size, (height * size));
        /* Draw a rectangle showing the edge of the field to the up */
        g.fillRect(0, 0, (width * size) , size);

        /* Gray color of the mouse */
        g.setColor(Color.GRAY);
        /* draw rectangle showing mouse */
        g.fillRect(Room.room.getMouse().getX() * size, Room.room.getMouse().getY() * size, size, size);

        /* Gray color of the mouse */
        g.setColor(Color.GREEN);
        /* Get sections of the snake */
        List<SnakeSection> getSection = Room.room.getSnake().getSections();
        for (SnakeSection aGetSection : getSection) {
            /* Drawing the snake sections */
            g.fillRect(aGetSection.getX() * size, aGetSection.getY() * size, size, size);
        }
    }
}