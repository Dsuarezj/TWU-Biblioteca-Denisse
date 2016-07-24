package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;


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

    @Test
    public void testDisplayMainMenu() {
        List<String> mainMenuItems = Arrays.asList("List of Books", "List of Movies", "Quit");

        menu.displayMenu(mainMenuItems);
        String expectedMainMenu = "++++++++++ Menu Option ++++++++++\n" +
                "1. List of Books\t2. List of Movies\t3. Quit\t\n" +
                "Select the option number\n";

        assertEquals(expectedMainMenu, byteArrayOutputStream.toString());
    }

    @Test
    public void testDisplaySubMenu() {

        List<String> mainMenuItems = Arrays.asList("Borrow a book", "Return a book", "Go back");

        menu.displayMenu(mainMenuItems);
        String expectedMainMenu = "++++++++++ Menu Option ++++++++++\n" +
                "1. Borrow a book\t2. Return a book\t3. Go back\t\n" +
                "Select the option number\n";

        assertEquals(expectedMainMenu, byteArrayOutputStream.toString());
    }


}
