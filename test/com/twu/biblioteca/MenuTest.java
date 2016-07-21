package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    public void testWelcomeMessageDisplayBibliotecaName() {
        menu.displayWelcome();
        assertEquals("Welcome to: " + biblioteca.bibliotecaName + "\n", byteArrayOutputStream.toString());
    }

    @Test
    public void testBookListAfterBorrowABook() {
        Book book1 = new Book("Book1", "Author1", 1999, true);
        Book book2 = new Book("Book2", "Author1", 1888, true);
        ArrayList testAllBooks = new ArrayList();
        testAllBooks.add(book1);
        testAllBooks.add(book2);
        biblioteca.addBooksToTheBiblioteca(testAllBooks);

        List<Book> AvailableBooks;
        AvailableBooks = biblioteca.getBooksThatAreAvailable(true);
        assertEquals(2, AvailableBooks.size());

//        ArrayList testIfIBorrowBook2 = new ArrayList();
//        testIfIBorrowBook2.add(book1);

        menu.setStateOfABook(1, AvailableBooks, false);

        AvailableBooks = biblioteca.getBooksThatAreAvailable(true);

        assertEquals(1, AvailableBooks.size());
        assertEquals("Book1", AvailableBooks.get(0).getBookName());
//        assertEquals(testIfIBorrowBook2, AvailableBooks);


    }

}
