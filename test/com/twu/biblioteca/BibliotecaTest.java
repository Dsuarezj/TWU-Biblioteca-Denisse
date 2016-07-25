package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    private String bookName = "Book name test";
    private String bookAuthor = "Book author Test";
    private int bookYear = 1990;

    private boolean stateAvailable = true;

    private Item book = new Item(bookName, bookAuthor, bookYear, stateAvailable);
    private Item movie = new Item("Adventure time season 1", "Pendleton Ward", 2010, true);

    private Item availableItem = new Item("Available Item", bookAuthor, bookYear, true);
    private Item unavailableItem = new Item("Un Available Item", bookAuthor, bookYear, false);

    private List<Item> allBooks = Arrays.asList(book, availableItem, unavailableItem);


    @Before
    public void setUp() {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void cleanUp() {
        biblioteca.cleanUp();
    }

    @Test
    public void testAddBookToTheBiblioteca() {
        List<Item> testItemList = Collections.singletonList(book);
        biblioteca.addItemsToTheASeccion(testItemList, Biblioteca.ItemType.BOOK);
        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.ItemType.BOOK));
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Item> expectedOnlyAvailable = Arrays.asList(book, availableItem);
        biblioteca.addItemsToTheASeccion(allBooks, Biblioteca.ItemType.BOOK);
        assertEquals(expectedOnlyAvailable, biblioteca.getItemsThatAreAvailable(Biblioteca.ItemType.BOOK));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Item> expectedNotAvailable = Arrays.asList(unavailableItem);
        biblioteca.addItemsToTheASeccion(allBooks, Biblioteca.ItemType.BOOK);
        assertEquals(expectedNotAvailable, biblioteca.getItemsThatAreNotAvailable(Biblioteca.ItemType.BOOK));
    }

    @Test
    public void testAddMovieToTheBiblioteca() {
        List<Item> testItemList = Arrays.asList(movie);
        biblioteca.addItemsToTheASeccion(testItemList, Biblioteca.ItemType.MOVIE);
        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.ItemType.MOVIE));
    }

    @Test
    public void testAddMovieAndBookToTheBibliotecaAndOnlyGetMovieList() {
        List<Item> testBookList = Arrays.asList(book);
        List<Item> testMovieList = Arrays.asList(movie);
        biblioteca.addItemsToTheASeccion(testBookList, Biblioteca.ItemType.BOOK);
        biblioteca.addItemsToTheASeccion(testMovieList, Biblioteca.ItemType.MOVIE);
        assertEquals(testMovieList, biblioteca.getTotalItems(Biblioteca.ItemType.MOVIE));
    }

}
