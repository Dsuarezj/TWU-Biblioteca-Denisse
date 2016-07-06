package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MenuTest {

    private ByteArrayOutputStream byteArrayOutputStream;
    private Menu menu = new Menu();


    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void displayWelcomeTestNotNull() {
        menu.displayWelcome();
        assertNotNull(byteArrayOutputStream.toString());
    }

    @Test
    public void displayWelcomeTest() {
        menu.displayWelcome();
        assertEquals("Welcome to the best biblioteca ever!\n", byteArrayOutputStream.toString());
    }

    @Test
    public void AddOptionToTheMenu() {
        String optionTest = "Option Test";
        int positionTest =0;
        menu.addOption(optionTest,positionTest);
        assertEquals(optionTest,menu.getOption(positionTest));
    }

}
