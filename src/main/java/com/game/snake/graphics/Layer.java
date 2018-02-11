package com.game.snake.graphics;

import com.game.snake.setting.Setting;
import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.SnakeSection;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Koliadin Nikita
 * @version 1.10
 *
 * This class is Graphic class
 */
public class Layer extends JPanel {

    /* Our Setting for this game object */
    private final Setting setting = Setting.getInstance();

    /**
     * @param g our graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Get sections of the snake */
        List<SnakeSection> getSection = Room.room.getSnake().getSections();

        /* Size of the game rectangle */
        final int size = setting.getSizeOfGame();

        /* Room width and height */
        final int width = setting.getRoomWidth() + 2;
        final int height = setting.getRoomHeight() + 2;

        /* Color color of face */
        g.setColor(setting.getColorFace());
        /* Draw a rectangle showing the edge of the field to the right */
        g.fillRect(width * size, 0, size, (height * size));
        /* Draw a rectangle showing the edge of the field to the down */
        g.fillRect(0, height * size, (width * size) + size, size);
        /* Draw a rectangle showing the edge of the field to the left */
        g.fillRect(0, 0, size, (height * size));
        /* Draw a rectangle showing the edge of the field to the up */
        g.fillRect(0, 0, (width * size) , size);

        /* Color of the mouse */
        g.setColor(setting.getColorMouse());
        /* draw rectangle showing mouse */
        g.fillRect(Room.room.getMouse().getX() * size, Room.room.getMouse().getY() * size, size, size);

        /* Color of the Head */
        g.setColor(setting.getColorHead());
        /* Drawing the head sections */
        g.fillRect(
                getSection.get(0).getX() * size,
                getSection.get(0).getY() * size,
                size,
                size);

        /* Color of the Snake */
        g.setColor(setting.getColorSnake());
        /* Drawing the snake sections */
        IntStream.range(1, getSection.size())
                .forEachOrdered(i -> g.fillRect(
                        getSection.get(i).getX() * size,
                        getSection.get(i).getY() * size,
                        size,
                        size)
                );
    }
}