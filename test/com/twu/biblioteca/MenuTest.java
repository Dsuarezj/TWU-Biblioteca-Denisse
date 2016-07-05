package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

public class MenuTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private Menu welcome = new Menu();


    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void displayWelcomeTestNotNull() {
        welcome.displayWelcome();
        assertNotNull(byteArrayOutputStream.toString());
    }

    @Test
    public void displayWelcomeTest() {
        welcome.displayWelcome();
        assertEquals("Welcome to the best biblioteca ever!\n", byteArrayOutputStream.toString());
    }


}
