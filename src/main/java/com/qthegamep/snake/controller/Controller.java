package com.qthegamep.snake.controller;

import com.qthegamep.snake.model.ModelInterface;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class Controller {

    private static volatile Controller instance;

    @Getter @Setter private ModelInterface model;

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
        model.startGame();
    }
}
