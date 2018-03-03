package com.game.snake.model.objects.snake;

import com.game.snake.model.objects.mouse.Mouse;
import com.game.snake.model.objects.room.Room;
import com.game.snake.model.setting.Setting;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.10
 */
public final class Snake {

    private final Setting setting = Setting.getInstance();

    private final List<SnakeSection> sections = new ArrayList<>();

    private SnakeDirection direction;

    private boolean isAlive;

    public Snake() {
        sections.add(new SnakeSection(1, 1));
        direction = SnakeDirection.DOWN;
        isAlive = true;
    }

    @Contract(pure = true)
    public boolean isAlive() {
        return isAlive;
    }

    @Contract(pure = true)
    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    @Contract(pure = true)
    public List<SnakeSection> getSections() {
        return sections;
    }

    public int getHeadX() {
        return sections.get(0).getX();
    }

    public int getHeadY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (!isAlive) {
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
        final SnakeSection head = new SnakeSection(getHeadX() + dx, getHeadY() + dy);

        checkBorders(head);
        if (!isAlive) {
            return;
        }

        checkBody(head);
        if (!isAlive) {
            return;
        }

        checkEatMouse(head);
    }

    private void checkBorders(@NotNull final SnakeSection head) {
        isAlive = (head.getX() >= 1 && head.getX() < setting.getRoomWidth() + 2)
                && (head.getY() >= 1 && head.getY() < setting.getRoomHeight() + 2);
    }

    private void checkBody(@NotNull final SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    private void checkEatMouse(@NotNull final SnakeSection head) {
        final Mouse mouse = Room.room.getMouse();

        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) {
            sections.add(0, head);
            Room.room.eatMouse();
        } else {
            sections.add(0, head);
            sections.remove(sections.size() - 1);
        }
    }
}
