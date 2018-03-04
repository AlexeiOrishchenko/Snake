package com.game.snake.view.graphics;

import com.game.snake.model.setting.Setting;
import com.game.snake.model.objects.room.Room;

import lombok.NonNull;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class Layer extends JPanel {

    private final Setting setting = Setting.getInstance();
    private final Room room = Room.getRoom();

    private final int size = setting.getSizeOfGame();
    private final int width = setting.getRoomWidth() + 2;
    private final int height = setting.getRoomHeight() + 2;

    @Override
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);

        printFace(g);
        printMouse(g);
        printHead(g);
        printSnake(g);
    }

    private void printFace(@NonNull final Graphics g) {
        g.setColor(setting.getColorFace());
        g.fillRect(width * size, 0, size, (height * size)); /* Right */
        g.fillRect(0, height * size, (width * size) + size, size); /* Down */
        g.fillRect(0, 0, size, (height * size)); /* Left */
        g.fillRect(0, 0, (width * size) , size); /* Up */
    }

    private void printMouse(@NonNull final Graphics g) {
        g.setColor(setting.getColorMouse());
        g.fillRect(
                room.getMouse().getX() * size,
                room.getMouse().getY() * size,
                size,
                size
        );
    }

    private void printHead(@NonNull final Graphics g) {
        g.setColor(setting.getColorHead());
        g.fillRect(
                room.getSnake().getHeadX() * size,
                room.getSnake().getHeadY() * size,
                size,
                size
        );
    }

    private void printSnake(@NonNull final Graphics g) {
        val snakeSection = room.getSnake().getSections();

        g.setColor(setting.getColorSnake());
        IntStream.range(1, snakeSection.size())
                .forEachOrdered(i -> g.fillRect(
                        snakeSection.get(i).getX() * size,
                        snakeSection.get(i).getY() * size,
                        size,
                        size
                ));
    }
}
