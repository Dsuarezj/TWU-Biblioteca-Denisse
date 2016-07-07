package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        ArrayList<String> mainMenuItems = new ArrayList<>();

        menu.addOption(optionTest, mainMenuItems);
        assertEquals(option1,menu.getOption(0,mainMenuItems));
    }

    @Test
    public void ExitMenu() {


    }


    @Test
    public void BorrowABook() {
        Book book1 = new Book("Book1", "Author1", 1999, true);
        Book book2 = new Book("Book2", "Author1", 1888, true);
        ArrayList testAllBooks = new ArrayList();
        testAllBooks.add(book1);
        testAllBooks.add(book2);
        biblioteca.addBooksToTheBiblioteca(testAllBooks);

        ArrayList AvailableBooks;
        AvailableBooks = biblioteca.getAvailableBookList();

        ArrayList testIfIBorrowBook2 = new ArrayList();
        testIfIBorrowBook2.add(book1);


        menu.selectABookFromAList(1, AvailableBooks);

        AvailableBooks = biblioteca.getAvailableBookList();


        assertEquals(testIfIBorrowBook2, AvailableBooks);


    }

}
