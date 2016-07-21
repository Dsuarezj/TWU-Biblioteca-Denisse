package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    private ByteArrayOutputStream byteArrayOutputStream;
    private String bookName = "Book name test";
    private String bookAuthor = "Book author Test";
    private int bookYear = 1990;

    private boolean stateAvailable = true;

    Book book = new Book(bookName, bookAuthor, bookYear, stateAvailable);
    Book availableBook = new Book(bookName, bookAuthor, bookYear, true);
    Book unavailableBook = new Book(bookName, bookAuthor, bookYear, false);
    List<Book> allBooks = Arrays.asList(availableBook, unavailableBook);


    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void cleanUp() {
        biblioteca.cleanUp();
    }

    @Test
    public void testDisplayWelcomeText() {
        biblioteca.startBookNameList();
        assertEquals("The books aviable are:\n", byteArrayOutputStream.toString());
    }


    @Test
    public void testAddBookToTheBiblioteca() {
        List<Book> testBookList = Arrays.asList(book);
        biblioteca.addBooksToTheBiblioteca(testBookList);
        assertEquals(testBookList, biblioteca.getTotalBooks());
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Book> expectedOnlyAvailable = Arrays.asList(availableBook);
        biblioteca.addBooksToTheBiblioteca(allBooks);
        assertEquals(expectedOnlyAvailable, biblioteca.getBooksThatAreAvailable(true));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Book> expectedNotAvailable = Arrays.asList(unavailableBook);
        biblioteca.addBooksToTheBiblioteca(allBooks);
        assertEquals(expectedNotAvailable, biblioteca.getBooksThatAreAvailable(false));
    }


}
