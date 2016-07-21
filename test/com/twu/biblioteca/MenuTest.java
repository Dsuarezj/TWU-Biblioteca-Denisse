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
    private Biblioteca biblioteca = new Biblioteca();

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testWelcomeMessageIsNotNull() {
        menu.displayWelcome();
        assertNotNull(byteArrayOutputStream.toString());
    }

    @Test
    public void testDisplayWelcomeMessageWithBibliotecaName() {
        menu.displayWelcome();
        assertEquals("Welcome to: " + biblioteca.bibliotecaName + "\n", byteArrayOutputStream.toString());
    }

}
