package com.game.snake;

import com.game.snake.controller.Controller;
import com.game.snake.model.Model;
import com.game.snake.view.swing.gui.mainmenu.MainMenuGUI;

/**
 * @author Koliadin Nikita
 * @version 1.17
 */
public class Main {
    public static void main(String[] args) {
        var model = Model.getInstance();
        var controller = Controller.getInstance();

        controller.setModel(model);

        MainMenuGUI.getInstance().run();
    }
}
