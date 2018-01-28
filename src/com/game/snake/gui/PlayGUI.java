package com.game.snake.gui;

import com.game.snake.objects.room.Room;
import com.game.snake.objects.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * This class create SingleThread and start the game.
 * This class implements Runnable and extends JFrame.
 */
public class PlayGUI extends JFrame implements Runnable {

    private final JFrame jFrame;

    public PlayGUI(JFrame jFrame) throws HeadlessException {
        this.jFrame = jFrame;
    }

    @Override
    public void run() {
        /* Create Room and Snake */
        Room.room = new Room(new Snake(), jFrame);

        ExecutorService executorService = Executors.newWorkStealingPool();
        executorService.execute(Room.room);
        executorService.shutdown();
    }
}
