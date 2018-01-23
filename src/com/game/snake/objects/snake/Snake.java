package com.game.snake.objects.snake;

import com.game.snake.objects.mouse.Mouse;
import com.game.snake.objects.room.Room;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Koliadin Nikita
 * @version 1.2
 *
 * This class is the snake
 */
public final class Snake {

    /* Direction of movement of a snake */
    private SnakeDirection direction;
    /* Status - whether the snake is alive or not */
    private boolean isAlive;
    /* List of snake pieces */
    private List<SnakeSection> sections;

    public Snake() {
        sections = new ArrayList<SnakeSection>();
        sections.add(new SnakeSection(0, 0));
        direction = SnakeDirection.DOWN;
        isAlive = true;
    }

    @Contract(pure = true)
    public boolean isAlive() {
        return isAlive;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
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

    /**
     * The method moves the snake one turn.
     * The direction of movement is specified by the variable direction.
     */
    public void move() {
        if (!isAlive) {
            return;
        }

        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case RIGHT:
                move(1, 0);
                break;
            case DOWN:
                move(0, 1);
                break;
            case LEFT:
                move(-1, 0);
                break;
        }
    }

    /**
     * The method moves the snake into the next cell.
     * Cell coordinates are given relative to the current head with the help of variables (dx, dy).
     *
     * @param dx <b>direction x</b>
     * @param dy <b>direction y</b>
     */
    private void move(int dx, int dy) {
        /* Create a new head - a new "piece of snake" */
        SnakeSection head = sections.get(0);
        head = new SnakeSection(head.getX() + dx, head.getY() + dy);

        /* Check - whether the head has got out of the room */
        checkBorders(head);
        if (!isAlive) {
            return;
        }

        /* Check whether the snake crosses itself */
        checkBody(head);
        if (!isAlive) {
            return;
        }

        /* Check - did not eat a snake mouse */
        Mouse mouse = Room.room.getMouse();
        if (head.getX() == mouse.getX() && head.getY() == mouse.getY()) {       // Ate
            sections.add(0, head);                                        // Add a new head
            Room.room.eatMouse();                         //We do not delete the tail, but create a new mouse
        } else {                                          // Just moves
            sections.add(0, head);                  // Added a new head
            sections.remove(sections.size() - 1);   // Removed the last element from the tail
        }
    }

    /**
     * The method checks whether the head does not coincide with any part of the body of the snake
     */
    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    /**
     * The method checks whether the new head is within the room
     */
    private void checkBorders(@NotNull SnakeSection head) {
        isAlive = (head.getX() >= 0 && head.getX() < Room.room.getWidth()) && (head.getY() >= 0 && head.getY() < Room.room.getHeight());
    }
}
