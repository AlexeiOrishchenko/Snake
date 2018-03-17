package com.game.snake.view.swing.gui.setting.component;

/**
 * @author Koliadin Nikita
 * @version 1.15
 */
public interface ComponentSetting {

    /**
     * This method must implement the initialization of the component.
     * It should load resources, set the size of the component, set the opaque,
     * give it coordinates on the panel and add it to the container.
     * Implementing this method, you need to consider all these factors.
     *
     * This method must be called when you want to initialize a component,
     * or form components.
     */
    void init();

    /**
     * Этот метод должен быть вызван после инициализации компонента или компонентов
     * и после того, как пользователь приймет все изменения которые он сделал.
     *
     * This method must be called for all components when the button is pressed
     */
    void update();
}
