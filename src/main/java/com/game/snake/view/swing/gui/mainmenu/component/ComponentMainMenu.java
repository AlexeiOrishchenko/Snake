package com.game.snake.view.swing.gui.mainmenu.component;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public interface ComponentMainMenu {

    /**
     * This method must implement the initialization of the component.
     * It should load resources, set the size of the component, set the opaque,
     * give it coordinates on the panel and add it to the container.
     * Implementing this method, you need to consider all these factors.
     */
    void init();

    /**
     * This method must implement the action of the component.
     * It can be implemented by any listener or adapter.
     */
    void setAction();
}
