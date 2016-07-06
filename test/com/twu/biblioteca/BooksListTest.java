package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;


public class BooksListTest {

    private BooksList allBookList = new BooksList();
    private ByteArrayOutputStream byteArrayOutputStream;

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
        String bookName = "Book name test";
        String bookAuthor = "Book author Test";
        int bookYear = 1990;

        Book book = new Book(bookName, bookAuthor, bookYear);

        assertEquals(bookName, book.getBookName());
        assertEquals(bookAuthor, book.getBookAuthor());
        assertEquals(bookYear, book.getBookYear());
    }


    
    /* @Test
    public void verifySizeOfNameAndAuthorArray (){
        assertEquals(bookList.getBookNameList().size(),bookList.getBookAuthorList().size());
    }

    @Test
    public void verifySizeOfNameAndYearArray (){
        assertEquals(bookList.getBookNameList().size(), bookList.getBookYearList().size());
    }*/

}
