package com.game.snake.view.gui.mainmenu.component;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public interface MainMenuComponent {

    /**
     * This method must implement the initialization of the component,
     * giving it a name and location and add it to the container.
     */
    void init();

    /**
     * This method must implement the action of each component.
     */
    void setAction();
}
