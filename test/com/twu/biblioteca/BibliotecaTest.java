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

    private Item book = new Item("1Q84", "Haruki Murakami", 2009, true);
    private Item movie = new Item("Adventure time season 1", "Pendleton Ward", 2010, true);

    private Item availableItem = new Item("Available Item", "Some author", 1990, true);
    private Item unavailableItem = new Item("Un Available Item", "Another Author", 2000, false);

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

        biblioteca.addItemsToASection(testItemList, Biblioteca.section.BOOK);

        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.section.BOOK));
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Item> expectedOnlyAvailable = Arrays.asList(book, availableItem);

        biblioteca.addItemsToASection(allBooks, Biblioteca.section.BOOK);

        assertEquals(expectedOnlyAvailable, biblioteca.getItemsThatAreAvailable(Biblioteca.section.BOOK));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Item> expectedNotAvailable = Arrays.asList(unavailableItem);

        biblioteca.addItemsToASection(allBooks, Biblioteca.section.BOOK);

        assertEquals(expectedNotAvailable, biblioteca.getItemsThatAreNotAvailable(Biblioteca.section.BOOK));
    }

    @Test
    public void testAddMovieToTheBiblioteca() {
        List<Item> testItemList = Arrays.asList(movie);

        biblioteca.addItemsToASection(testItemList, Biblioteca.section.MOVIE);

        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.section.MOVIE));
    }

    @Test
    public void testAddMovieAndBookToTheBibliotecaAndOnlyGetMovieList() {
        List<Item> testBookList = Arrays.asList(book);
        List<Item> testMovieList = Arrays.asList(movie);

        biblioteca.addItemsToASection(testBookList, Biblioteca.section.BOOK);
        biblioteca.addItemsToASection(testMovieList, Biblioteca.section.MOVIE);

        assertEquals(testMovieList, biblioteca.getTotalItems(Biblioteca.section.MOVIE));
    }

}
