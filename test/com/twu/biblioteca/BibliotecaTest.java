package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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

    @Test
    public void DisplayWelcomeText() {
        biblioteca.startBookNameList();
        assertEquals("The books aviable are:\n", byteArrayOutputStream.toString());
    }

    @Test
    public void GetBookInformation() {
        assertEquals(bookName, book.getBookName());
        assertEquals(bookAuthor, book.getBookAuthor());
        assertEquals(bookYear, book.getBookYear());
        assertEquals(stateAvailable, book.getStateAvailable());
    }

    @Test
    public void AddBookToTheBiblioteca() {
        ArrayList testBookList = new ArrayList();
        testBookList.add(0, book);
        biblioteca.addBooksToTheBiblioteca(testBookList);
        assertEquals(testBookList, biblioteca.getTotalBooks());
    }

    @Test
    public void GetBookStatusFromBiblioteca() {
        Book book1 = new Book(bookName, bookAuthor, bookYear, true);
        ArrayList testAllBooks = new ArrayList();
        testAllBooks.add(book1);

        biblioteca.addBooksToTheBiblioteca(testAllBooks);
        boolean statusOfABook= biblioteca.getStatusOfABook(0);

        assertEquals(true, statusOfABook);

    }

    @Test
    public void ReturnOnlyAvailableBooks() {
        Book book1 = new Book(bookName, bookAuthor, bookYear, true);
        Book book2 = new Book(bookName, bookAuthor, bookYear, false);
        ArrayList testAllBooks = new ArrayList();
        testAllBooks.add(book1);
        testAllBooks.add(book2);
        ArrayList testAvailableBooks = new ArrayList();
        testAvailableBooks.add(book1);
        ArrayList resultAvailableBooks;

        biblioteca.addBooksToTheBiblioteca(testAllBooks);

        resultAvailableBooks = biblioteca.getAvailableBookList();

        assertEquals(testAvailableBooks, resultAvailableBooks);

    }



    @Test
    public void shouldReturnAllAvailableBooks() {

        //Arrange:
        //Crear los libros
        //Crear un array con los libros
        //Crear biblioteca

        //Llamar al metodo
//        arrayallBookList.getAllAvailableBookList();

//        Assert
//
    }
}
