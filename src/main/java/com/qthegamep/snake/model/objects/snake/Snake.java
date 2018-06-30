package com.qthegamep.snake.model.objects.snake;

import com.qthegamep.snake.model.objects.room.Room;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class Snake {

    @Getter @Setter private List<SnakeSection> sections = new ArrayList<>();

    @Getter @Setter private SnakeDirection direction;

    @Getter @Setter private boolean alive;

    public Snake() {
        sections.add(0, new SnakeSection(1, 1));
        sections.add(0, new SnakeSection(1, 2));
        sections.add(0, new SnakeSection(1, 3));
        direction = SnakeDirection.DOWN;
        alive = true;
    }

    public int getHeadX() {
        return sections.get(0).getX();
    }

    public int getHeadY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!alive) {
            return;
        }

        if (direction == SnakeDirection.UP) {
            move(0, -1);
        } else if (direction == SnakeDirection.RIGHT) {
            move(1, 0);
        } else if (direction == SnakeDirection.DOWN) {
            move(0, 1);
        } else if (direction == SnakeDirection.LEFT) {
            move(-1, 0);
        }
    }

    private void move(final int dx, final int dy) {
        val head = new SnakeSection(getHeadX() + dx, getHeadY() + dy);

        checkBorders(head);
        if (!alive) {
            return;
        }

        checkBody(head);
        if (!alive) {
            return;
        }

        nextStep(head);
        checkEatMouse(head);
    }

    private void checkBorders(@NonNull final SnakeSection head) {
        val headX = head.getX();
        val headY = head.getY();
        val room = Room.getInstance();

        alive = (headX > 0 && headX < room.getWidth() + 1)
                && (headY > 0 && headY < room.getHeight() + 1);
    }

    private void checkBody(@NonNull final SnakeSection head) {
        if (sections.contains(head)) {
            alive = false;
        }
    }

    private void nextStep(@NonNull final SnakeSection head) {
        sections.add(0, head);
    }

    private void checkEatMouse(@NonNull final SnakeSection head) {
        val room = Room.getInstance();
        val mouse = room.getMouse();

        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) {
            room.eatMouse();
        } else {
            sections.remove(sections.size() - 1);
        }
    }
}
