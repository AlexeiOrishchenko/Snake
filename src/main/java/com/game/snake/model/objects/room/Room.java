package com.game.snake.model.objects.room;

import com.game.snake.view.swing.gui.play.PlayGUI;
import com.game.snake.model.objects.mouse.Mouse;
import com.game.snake.view.swing.graphics.ChangeColor;
import com.game.snake.view.swing.graphics.Layer;
import com.game.snake.model.objects.snake.Snake;
import com.game.snake.model.objects.snake.SnakeDirection;
import com.game.snake.model.objects.snake.SnakeSection;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.val;

import java.awt.event.KeyEvent;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.14
 */
public class Room implements Runnable {

    private static volatile Room instance = new Room();

    private PlayGUI playGUI; // FIXME: DELETE DEPENDENCY

    @Getter @Setter private Snake snake;
    @Getter @Setter private Mouse mouse;

    @Getter @Setter private int width = 20;
    @Getter @Setter private int height = 20;

    private Room() {
    }

    public static Room getInstance() {
        if (Room.instance == null) {
            synchronized (Room.class) {
                if (Room.instance == null) {
                    Room.instance = new Room();
                }
            }
        }
        return Room.instance;
    }

    public void eatMouse() {
        createMouse();
    }

    @Override
    public void run() {
        initStart();
        startKeyListener();

        while (snake.isAlive()) {
            if (playGUI.hasKeyEvents()) { // FIXME: DELEGATE TO CONTROLLER
                val event = playGUI.getEventFromTop();

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

    private void initStart() {
        this.playGUI = new PlayGUI();
        this.snake = new Snake();
        createMouse();
    }

    private void startKeyListener() { // FIXME: DELEGATE TO CONTROLLER
        val executor = Executors.newSingleThreadExecutor();
        executor.execute(playGUI);
        executor.shutdown();
    }

    private void checkPause(@NonNull final KeyEvent event) {
        if (event.getKeyChar() == 'p') {
            while (true) {
                sleep();
                if (playGUI.hasKeyEvents()) {
                    KeyEvent eventNew = playGUI.getEventFromTop();
                    if (eventNew.getKeyChar() == 'p') {
                        break;
                    }
                }
            }
        }
    }

    private boolean isExit(@NonNull final KeyEvent event) {
        return event.getKeyChar() == KeyEvent.VK_ESCAPE;
    }

    private void checkDirection(@NonNull final KeyEvent event) {
        val i = event.getKeyCode();

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

    private void print() { // FIXME: DELETE DEPENDENCY FROM JFRAME - DELEGATE TO CONTROLLER
        if (playGUI != null) {
            playGUI.getJFrame().setContentPane(new Layer());
            playGUI.onVisible();
        }
    }

    private void sleep() {
        try {
            val level = snake.getSections().size();
            val delay = level <= 16 ? (300 - 10 * level - 1) : 150;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void gameOver() { // FIXME: DELEGATE TO CONTROLLER
        playGUI.offVisible();
        ChangeColor.setMainMenuWaitThread(false);
    }

    private void createMouse() {
        mouse = new Mouse((int) (Math.random() * width + 1), (int) (Math.random() * height + 1));
        for (SnakeSection snakeSection : snake.getSections()) {
            if (snakeSection.getX() == mouse.getX() && snakeSection.getY() == mouse.getY()) {
                createMouse();
            }
        }
    }
}
