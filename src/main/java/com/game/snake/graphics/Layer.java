package com.game.snake.graphics;

import com.game.snake.setting.Setting;
import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.SnakeSection;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Koliadin Nikita
 * @version 1.10
 *
 */
public class Layer extends JPanel {

    private final Setting setting = Setting.getInstance();
    private final List<SnakeSection> getSection = Room.room.getSnake().getSections();

    private final int size = setting.getSizeOfGame();
    private final int width = setting.getRoomWidth() + 2;
    private final int height = setting.getRoomHeight() + 2;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        printFace(g);
        printMouse(g);
        printHead(g);
        printSnake(g);
    }

    private void printFace(@NotNull Graphics g) {
        g.setColor(setting.getColorFace());
        g.fillRect(width * size, 0, size, (height * size)); /* Right */
        g.fillRect(0, height * size, (width * size) + size, size); /* Down */
        g.fillRect(0, 0, size, (height * size)); /* Left */
        g.fillRect(0, 0, (width * size) , size); /* Up */
    }

    private void printMouse(@NotNull Graphics g) {
        g.setColor(setting.getColorMouse());
        g.fillRect(Room.room.getMouse().getX() * size, Room.room.getMouse().getY() * size, size, size);
    }

    private void printHead(@NotNull Graphics g) {
        g.setColor(setting.getColorHead());
        g.fillRect(
                getSection.get(0).getX() * size,
                getSection.get(0).getY() * size,
                size,
                size);
    }

    private void printSnake(@NotNull Graphics g) {
        g.setColor(setting.getColorSnake());
        IntStream.range(1, getSection.size())
                .forEachOrdered(i -> g.fillRect(
                        getSection.get(i).getX() * size,
                        getSection.get(i).getY() * size,
                        size,
                        size)
                );
    }
}
