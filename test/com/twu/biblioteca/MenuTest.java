package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.apache.commons.lang.RandomStringUtils;


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
        String optionTest = RandomStringUtils.randomAlphanumeric(2);
        menu.addOption(optionTest);
        assertEquals(optionTest,menu.getOption(0));
    }

}
