package com.twu.biblioteca.biblioteca;

import com.twu.biblioteca.items.Book;
import com.twu.biblioteca.items.Item;
import com.twu.biblioteca.items.Movie;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    private Biblioteca biblioteca = new Biblioteca();

    private Item book = new Book("1Q84", "Haruki Murakami", 2009, true);
    private Item movie = new Movie("Adventure time season 1", "Pendleton Ward", 2010, true);

    private Item availableItem = new Item("Available Item", "Some author", 1990, true);
    private Item unavailableItem = new Item("Un Available Item", "Another Author", 2000, false);

    private List<Item> allBooks = Arrays.asList(book, availableItem, unavailableItem);

    @After
    public void cleanUp() {
        biblioteca.cleanUp();
    }

    @Test
    public void testAddBookToTheBiblioteca() {
        List<Item> testItemList = Collections.singletonList(book);

        biblioteca.addItemsToASection(testItemList, Biblioteca.Section.BOOK);

        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.Section.BOOK));
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Item> expectedOnlyAvailable = Arrays.asList(book, availableItem);

        biblioteca.addItemsToASection(allBooks, Biblioteca.Section.BOOK);

        assertEquals(expectedOnlyAvailable, biblioteca.getItemsThatAreAvailable(Biblioteca.Section.BOOK));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Item> expectedNotAvailable = Arrays.asList(unavailableItem);

        biblioteca.addItemsToASection(allBooks, Biblioteca.Section.BOOK);

        assertEquals(expectedNotAvailable, biblioteca.getItemsThatAreNotAvailable(Biblioteca.Section.BOOK));
    }

    @Test
    public void testAddMovieToTheBiblioteca() {
        List<Item> testItemList = Arrays.asList(movie);

        biblioteca.addItemsToASection(testItemList, Biblioteca.Section.MOVIE);

        assertEquals(testItemList, biblioteca.getTotalItems(Biblioteca.Section.MOVIE));
    }

    @Test
    public void testAddMovieAndBookToTheBibliotecaAndOnlyGetMovieList() {
        List<Item> testBookList = Arrays.asList(book);
        List<Item> testMovieList = Arrays.asList(movie);

        biblioteca.addItemsToASection(testBookList, Biblioteca.Section.BOOK);
        biblioteca.addItemsToASection(testMovieList, Biblioteca.Section.MOVIE);

        assertEquals(testMovieList, biblioteca.getTotalItems(Biblioteca.Section.MOVIE));
    }

    @Test
    public void testDisplayAListOfItems() {
        ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));


        biblioteca.displayItemList(allBooks);

        String expectedMainMenu = "1. Item Name: 1Q84\n" +
                " Author: Haruki Murakami\n" +
                " Year : 2009\n" +
                "2. Item Name: Available Item\n" +
                " Author: Some author\n" +
                " Year : 1990\n" +
                "3. Item Name: Un Available Item\n" +
                " Author: Another Author\n" +
                " Year : 2000\n";

        assertEquals(expectedMainMenu, byteArrayOutputStream.toString());

    }
}
