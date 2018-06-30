package com.qthegamep.snake.view.swing.graphics;

import com.qthegamep.snake.model.Model;
import com.qthegamep.snake.view.swing.setting.Setting;

import lombok.NonNull;
import lombok.val;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class Layer extends JPanel {

    private final Setting setting = Setting.getInstance();
    private final Model model = Model.getInstance();

    private final int size = setting.getSizeOfGame();

    @Override
    public void paintComponent(@NonNull final Graphics g) {
        super.paintComponent(g);

        printFace(g);
        printMouse(g);
        printHead(g);
        printSnake(g);
    }

    private void printFace(@NonNull final Graphics g) {
        val width = model.getRoomWidth() + 1;
        val height = model.getRoomHeight() + 1;

        g.setColor(setting.getColorFace());
        g.fillRect(width * size, 0, size, (height * size)); /* Right */
        g.fillRect(0, height * size, (width * size) + size, size); /* Down */
        g.fillRect(0, 0, size, (height * size)); /* Left */
        g.fillRect(0, 0, (width * size) , size); /* Up */
    }

    private void printMouse(@NonNull final Graphics g) {
        g.setColor(setting.getColorMouse());
        g.fillRect(
                model.getMouseX() * size,
                model.getMouseY() * size,
                size,
                size
        );
    }

    private void printHead(@NonNull final Graphics g) {
        g.setColor(setting.getColorHead());
        g.fillRect(
                model.getSnakeHeadX() * size,
                model.getSnakeHeadY() * size,
                size,
                size
        );
    }

    private void printSnake(@NonNull final Graphics g) {
        val snakeSection = model.getSnakeSections();

        g.setColor(setting.getColorSnake());
        IntStream.range(1, snakeSection.size())
                .forEachOrdered(i -> g.fillRect(
                        model.getSnakeSectionsX(i) * size,
                        model.getSnakeSectionsY(i) * size,
                        size,
                        size
                ));
    }
}
