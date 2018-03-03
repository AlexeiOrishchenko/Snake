package com.game.snake.view.gui.setting.component;

/**
 * @author Koliadin Nikita
 * @version 1.13
 */
public interface SettingComponent {

    /**
     * This method must implement the initialization of the component,
     * giving it a name and a position.
     *
     * This method should be called when all components are in
     * the initialization process.
     */
    void init();

    /**
     * This method should implement updating settings from each component.
     *
     * This method should be called when the Enter button is pressed.
     */
    void update();
}
