package com.game.snake;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    private Main main;

    @Before
    public void createMainObject() {
        main = new Main();
    }

    @Test
    public void main() {
        assertNotNull(main);
        Main.main(null);
    }
}