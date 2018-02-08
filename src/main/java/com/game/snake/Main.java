package com.game.snake;

import com.game.snake.gui.MainMenuGUI;

/**
 * @author Koliadin Nikita
 * @version 1.9
 *
 * This class has examples how we can start our game
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*
        Thread thread = new Thread(new MainGUI());
        thread.start();
        */

//        /*
//        ExecutorService executorMainGUI = Executors.newSingleThreadExecutor();
//        executorMainGUI.execute(new MainGUI());
//        executorMainGUI.execute(new MainGUI());
//        executorMainGUI.shutdown();
//        */

        /*
        Executors.newSingleThreadExecutor().execute(new MainGUI());
        */

//        Setting.setExitGUIJLabelList(new ArrayList<JLabel>(Arrays.asList(new JLabel("1"), new JLabel("2"))));
        new MainMenuGUI().run();
    }
}
