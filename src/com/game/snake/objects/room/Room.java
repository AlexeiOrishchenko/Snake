package com.game.snake.objects.room;

import com.game.snake.controller.KeyboardObserver;
import com.game.snake.graphics.Layer;
import com.game.snake.objects.mouse.Mouse;
import com.game.snake.objects.snake.Snake;
import com.game.snake.objects.snake.SnakeDirection;
import com.game.snake.objects.snake.SnakeSection;
import com.game.snake.setting.Setting;
import org.jetbrains.annotations.Contract;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class is the "Room" for the snake
 */
public class Room implements Runnable {

    /* static object of the room - room can be only one */
    public static Room room;

    /* real objects of the game */
    private Snake snake;
    private Mouse mouse;

    /* MainGUI JFrame */
    private final JFrame jFrame;

    /* Height and width of the room */
    private  int width;
    private  int height;

    public Room(Snake snake, JFrame jFrame) {
        this.width = Setting.getRoomWidth();
        this.height = Setting.getRoomHeight();
        this.snake = snake;
        createMouse();
        this.jFrame = jFrame;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    @Contract(pure = true)
    public int getWidth() {
        return width;
    }

    @Contract(pure = true)
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Create new mouse
     */
    public void createMouse() {
        mouse = new Mouse((int) (Math.random() * width + 1), (int) (Math.random() * height + 1));
        for (SnakeSection snakeSection : snake.getSections()) {
            if (snakeSection.getX() == mouse.getX() && snakeSection.getY() == mouse.getY()) {
                createMouse();
            }
        }
    }

    /**
     * The method is called when the mouse is eaten
     */
    public void eatMouse() {
        createMouse();
    }

    /**
     * The main program cycle.
     * All important actions take place here
     */
    @Override
    public void run() {
        /* Create the object "the observer for the keyboard" and start it */
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        ExecutorService executorKeyboardObserver = Executors.newSingleThreadExecutor();
        executorKeyboardObserver.execute(keyboardObserver);
        executorKeyboardObserver.shutdown();

        /* While snake is alive */
        while (snake.isAlive()) {
            /* "Observer" contains events about keystrokes? */
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();
                /* if equals 'q' -> exit */
                if (event.getKeyChar() == 'p') { /* PAUSE */
                    while (true) {
                        try {
                            Thread.sleep(1000);
                            if (keyboardObserver.hasKeyEvents()) {
                                KeyEvent eventNew = keyboardObserver.getEventFromTop();
                                if (eventNew.getKeyChar() == 'p') {
                                    break;
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (event.getKeyChar() == 'q') {
                    return;
                }

                /* Arrow movement */
                switch (event.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        if (snake.getDirection() != SnakeDirection.RIGHT) {
                            snake.setDirection(SnakeDirection.LEFT);
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (snake.getDirection() != SnakeDirection.LEFT) {
                            snake.setDirection(SnakeDirection.RIGHT);
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (snake.getDirection() != SnakeDirection.DOWN) {
                            snake.setDirection(SnakeDirection.UP);
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (snake.getDirection() != SnakeDirection.UP) {
                            snake.setDirection(SnakeDirection.DOWN);
                        }
                        break;
                    case KeyEvent.VK_W:
                        if (snake.getDirection() != SnakeDirection.DOWN) {
                            snake.setDirection(SnakeDirection.UP);
                        }
                        break;
                    case KeyEvent.VK_S:
                        if (snake.getDirection() != SnakeDirection.UP) {
                            snake.setDirection(SnakeDirection.DOWN);
                        }
                        break;
                    case KeyEvent.VK_A:
                        if (snake.getDirection() != SnakeDirection.RIGHT) {
                            snake.setDirection(SnakeDirection.LEFT);
                        }
                        break;
                    case KeyEvent.VK_D:
                        if (snake.getDirection() != SnakeDirection.LEFT) {
                            snake.setDirection(SnakeDirection.RIGHT);
                        }
                        break;
                }
            }

            snake.move();   /* Move the snake */
            print();        /* Display the current state of the game */
            sleep();        /* Pause between moves */
        }

        /* Display the message "Game Over" */
        System.out.println("Game Over!");
        /* Turn on mainMenu visible */
        KeyboardObserver.jFrame.setVisible(false);
        Setting.setWaitThreadMainMenu(false);
        jFrame.setVisible(true);
    }

    /**
     * Print everything to the window
     */
    private void print() {
        if (KeyboardObserver.jFrame != null) {
            KeyboardObserver.jFrame.setContentPane(new Layer());
            KeyboardObserver.jFrame.setVisible(true);
        }
    }

    /**
     * The program pauses, the length of which depends on the length of the snake.
     */
    private void sleep() {
        try {
            int level = snake.getSections().size();
            int delay = level <= 16 ? (300 - 10 * level - 1) : 150;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
