package com.game.snake;

import com.game.snake.gui.MainGUI;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Koliadin Nikita
 * @version 1.4
 *
 * Start MainGUI in SingleThreadExecutor
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*
        Thread thread = new Thread(new MainGUI());
        thread.start();
        */

        /*
        ExecutorService executorMainGUI = Executors.newSingleThreadExecutor();
        executorMainGUI.execute(new MainGUI());
        executorMainGUI.shutdown();
        */

        /*
        Executors.newSingleThreadExecutor().execute(new MainGUI());
        */

        new MainGUI().run();
    }
}
