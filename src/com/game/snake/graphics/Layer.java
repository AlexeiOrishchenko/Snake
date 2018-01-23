package com.game.snake.graphics;

import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.SnakeSection;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is Graphic class
 */
public class Layer extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Green color of the snake and mouse */
        g.setColor(java.awt.Color.GREEN);

        /* Do nt need from version 1.1 */
//        /* Draw a rectangle showing the edge of the field to the right */
        g.fillRect(Room.room.getWidth() * 10, 0, 10, (Room.room.getHeight() * 10) + 10);
//        /* Draw a rectangle showing the edge of the field to the down */
        g.fillRect(0, Room.room.getHeight() * 10, (Room.room.getWidth() * 10) + 10, 10);


        /* draw rectangle showing mouse */
        g.fillRect(Room.room.getMouse().getX()*10, Room.room.getMouse().getY()*10, 10, 10);

        /* Get sections of the snake */
        List<SnakeSection> getSection = Room.room.getSnake().getSections();

        for (SnakeSection aGetSection : getSection) {
            /* Drawing the snake sections */
            g.fillRect(aGetSection.getX() * 10, aGetSection.getY() * 10, 10, 10);
        }
    }
}