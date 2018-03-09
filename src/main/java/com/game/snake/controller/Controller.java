package com.game.snake.controller;

import com.game.snake.model.objects.room.Room;
import lombok.val;

import java.util.concurrent.Executors;

public class Controller {

    private static volatile Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (Controller.instance == null) {
            synchronized (Controller.class) {
                if (Controller.instance == null) {
                    Controller.instance = new Controller();
                }
            }
        }
        return Controller.instance;
    }

    public void startGame() {
        val executor = Executors.newSingleThreadExecutor();
        executor.execute(Room.getInstance());
        executor.shutdown();
    }
}
