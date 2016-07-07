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
    private Biblioteca biblioteca = new Biblioteca();

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void DisplayWelcomeTestNotNull() {
        menu.displayWelcome();
        assertNotNull(byteArrayOutputStream.toString());
    }

    @Test
    public void DisplayWelcomeTest() {
        menu.displayWelcome();
        assertEquals("Welcome to: " + biblioteca.bibliotecaName + "\n", byteArrayOutputStream.toString());
    }

    @Test
    public void AddOptionToTheMenu() {

        String option1 = RandomStringUtils.randomAlphanumeric(2);
        String [] optionTest = {option1, RandomStringUtils.randomAlphanumeric(2)};
        menu.addOption(optionTest);
        assertEquals(option1,menu.getOption(0));
    }

    @Test
    public void ExitMenu() {


    }


}
