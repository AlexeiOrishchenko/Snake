package com.game.snake.objects.room;

import com.game.snake.controller.KeyboardObserver;
import com.game.snake.view.graphics.ChangeColor;
import com.game.snake.view.graphics.Layer;
import com.game.snake.objects.mouse.Mouse;
import com.game.snake.objects.snake.Snake;
import com.game.snake.objects.snake.SnakeDirection;
import com.game.snake.objects.snake.SnakeSection;
import com.game.snake.setting.Setting;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public class Room implements Runnable {

    public static Room room; // FIXME: do non Static in future

    private final Setting setting = Setting.getInstance();

    private final JFrame jFrame;

    private final KeyboardObserver keyboardObserver = new KeyboardObserver();

    @Getter @Setter private Snake snake;
    @Getter @Setter private Mouse mouse;

    @Getter @Setter private int width = setting.getRoomWidth(); //TODO: edit setting
    @Getter @Setter private int height = setting.getRoomHeight(); //TODO: edit setting

    public Room(final JFrame jFrame) {
        this.jFrame = jFrame;
        this.snake = new Snake();
        createMouse();
    }

    @Override
    public void run() {
        Executors.newSingleThreadExecutor().execute(keyboardObserver); // FIXME: shutdown

        while (snake.isAlive()) {
            if (keyboardObserver.hasKeyEvents()) {
                final KeyEvent event = keyboardObserver.getEventFromTop();

                checkPause(event);

                if (isExit(event)) {
                    gameOver();
                    return;
                }

                checkDirection(event);
            }
            snake.move();
            print();
            sleep();
        }
        gameOver();
    }

    public void eatMouse() {
        createMouse();
    }

    private void checkPause(@NotNull final KeyEvent event) {
        if (event.getKeyChar() == 'p') {
            while (true) {
                sleep(1000);
                if (keyboardObserver.hasKeyEvents()) {
                    KeyEvent eventNew = keyboardObserver.getEventFromTop();
                    if (eventNew.getKeyChar() == 'p') {
                        break;
                    }
                }
            }
        }
    }

    private boolean isExit(@NotNull final KeyEvent event) {
        return event.getKeyChar() == KeyEvent.VK_ESCAPE;
    }

    private void checkDirection(@NotNull final KeyEvent event) {
        final int i = event.getKeyCode();

        if (i == KeyEvent.VK_LEFT) {
            if (snake.getDirection() != SnakeDirection.RIGHT) {
                snake.setDirection(SnakeDirection.LEFT);
            }
        } else if (i == KeyEvent.VK_RIGHT) {
            if (snake.getDirection() != SnakeDirection.LEFT) {
                snake.setDirection(SnakeDirection.RIGHT);
            }
        } else if (i == KeyEvent.VK_UP) {
            if (snake.getDirection() != SnakeDirection.DOWN) {
                snake.setDirection(SnakeDirection.UP);
            }
        } else if (i == KeyEvent.VK_DOWN) {
            if (snake.getDirection() != SnakeDirection.UP) {
                snake.setDirection(SnakeDirection.DOWN);
            }
        } else if (i == KeyEvent.VK_W) {
            if (snake.getDirection() != SnakeDirection.DOWN) {
                snake.setDirection(SnakeDirection.UP);
            }
        } else if (i == KeyEvent.VK_S) {
            if (snake.getDirection() != SnakeDirection.UP) {
                snake.setDirection(SnakeDirection.DOWN);
            }
        } else if (i == KeyEvent.VK_A) {
            if (snake.getDirection() != SnakeDirection.RIGHT) {
                snake.setDirection(SnakeDirection.LEFT);
            }
        } else if (i == KeyEvent.VK_D) {
            if (snake.getDirection() != SnakeDirection.LEFT) {
                snake.setDirection(SnakeDirection.RIGHT);
            }
        }
    }

    private void gameOver() {
        keyboardObserver.setVisible(false);
        ChangeColor.setMainMenuWaitThread(false);
        jFrame.setVisible(true);
    }

    private void createMouse() {
        mouse = new Mouse((int) (Math.random() * width + 1), (int) (Math.random() * height + 1));
        for (SnakeSection snakeSection : snake.getSections()) {
            if (snakeSection.getX() == mouse.getX() && snakeSection.getY() == mouse.getY()) {
                createMouse();
            }
        }
    }

    private void print() {
        if (keyboardObserver != null) {
            keyboardObserver.setContentPane(new Layer());
            keyboardObserver.setVisible(true);
        }
    }

    private void sleep() {
        try {
            int level = snake.getSections().size();
            int delay = level <= 16 ? (300 - 10 * level - 1) : 150;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep(final long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
