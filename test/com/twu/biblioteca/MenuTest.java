package com.twu.biblioteca;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class MenuTest {

    @Test
    public void displayWelcomeTestNotNull() {
        Menu welcome = new Menu();
        assertNotNull(welcome.displayWelcome());
    }
    @Test
    public void displayWelcomeTestNotEmpty() {
        Menu welcome = new Menu();
        assertNotSame("",welcome.displayWelcome());
    }
}
