package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;


public class BooksListTest {

    private BooksList allBookList = new BooksList();
    private ByteArrayOutputStream byteArrayOutputStream;
    private String bookName = "Book name test";
    private String bookAuthor = "Book author Test";
    private int bookYear = 1990;
    Book book = new Book(bookName, bookAuthor, bookYear);


    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

    }

    @Test
    public void DisplayWelcomeText() {
        allBookList.startBookNameList();
        assertEquals("The books aviable are:\n", byteArrayOutputStream.toString());
    }

    @Test
    public void GetBookInformation() {

        assertEquals(bookName, book.getBookName());
        assertEquals(bookAuthor, book.getBookAuthor());
        assertEquals(bookYear, book.getBookYear());
    }

    @Test
    public void AddBookToTheBiblioteca() {
        ArrayList testBookList = new ArrayList();
        testBookList.add(0,book);
        allBookList.addBooksToTheBiblioteca(testBookList);
        assertEquals(testBookList,allBookList.getABooksAvailable());
    }




}
