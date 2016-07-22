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

    Item book = new Item(bookName, bookAuthor, bookYear, stateAvailable);
    Item movie = new Item("Adventure time season 1", "Pendleton Ward", 2010, true);

    Item availableItem = new Item("Available Item", bookAuthor, bookYear, true);
    Item unavailableItem = new Item("Un Available Item", bookAuthor, bookYear, false);

    List<Item> allBooks = Arrays.asList(book, availableItem, unavailableItem);


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
        assertEquals("The following articles are aviable:\n", byteArrayOutputStream.toString());
    }


    @Test
    public void testAddBookToTheBiblioteca() {
        List<Item> testItemList = Arrays.asList(book);
        biblioteca.addItemsToTheASeccion(testItemList , "books");
        assertEquals(testItemList, biblioteca.getTotalItems("books"));
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Item> expectedOnlyAvailable = Arrays.asList(availableItem);
        biblioteca.addItemsToTheASeccion(allBooks, "books");
        assertEquals(expectedOnlyAvailable, biblioteca.getItemsThatAreAvailable(true , "books"));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Item> expectedNotAvailable = Arrays.asList(unavailableItem);
        biblioteca.addItemsToTheASeccion(allBooks, "books");
        assertEquals(expectedNotAvailable, biblioteca.getItemsThatAreAvailable(false, "books"));
    }

    @Test
    public void testAddMovieToTheBiblioteca() {
        List<Item> testItemList = Arrays.asList(movie);
        biblioteca.addItemsToTheASeccion(testItemList , "movies");
        assertEquals(testItemList, biblioteca.getTotalItems("movies"));
    }
    @Test
    public void testAddMovieAndBookToTheBibliotecaAndOnlyGetMovieList() {
        List<Item> testBookList = Arrays.asList(book);
        List<Item> testMovieList = Arrays.asList(movie);
        biblioteca.addItemsToTheASeccion(testBookList , "books");
        biblioteca.addItemsToTheASeccion(testMovieList , "movies");
        assertEquals(testMovieList, biblioteca.getTotalItems("movies"));
    }

}
