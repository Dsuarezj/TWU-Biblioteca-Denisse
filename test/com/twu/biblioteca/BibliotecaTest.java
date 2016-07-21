package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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
    public void testGetStateAvailableOfABook() {
        assertEquals(stateAvailable, book.isAvailable());
    }

    @Test
    public void AddBookToTheBiblioteca() {
        ArrayList testBookList = new ArrayList();
        testBookList.add(0, book);
        biblioteca.addBooksToTheBiblioteca(testBookList);
        assertEquals(testBookList, biblioteca.getTotalBooks());
    }


    @Test
    public void ReturnOnlyAvailableBooks() {
        Book availableBook = new Book(bookName, bookAuthor, bookYear, true);
        Book unavailableBook = new Book(bookName, bookAuthor, bookYear, false);

        biblioteca.addBooksToTheBiblioteca(Arrays.asList(availableBook, unavailableBook));

        assertEquals(Arrays.asList(availableBook), biblioteca.getBooksThatAreAvailable(true));
    }

    @Test
    public void ReturnOnlyNotAvailableBooks() {
        Book book1 = new Book("book1", bookAuthor, bookYear, true);
        Book book2 = new Book("book2", bookAuthor, bookYear, false);
        ArrayList testAllBooks = new ArrayList();
        testAllBooks.add(book1);
        testAllBooks.add(book2);
        ArrayList testAvailableBooks = new ArrayList();
        testAvailableBooks.add(book2);
        List<Book> resultAvailableBooks;

        biblioteca.addBooksToTheBiblioteca(testAllBooks);

        resultAvailableBooks = biblioteca.getBooksThatAreAvailable(false);

        assertEquals(testAvailableBooks, resultAvailableBooks);
    }


}
