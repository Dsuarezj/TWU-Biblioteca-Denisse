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

    Item item = new Item(bookName, bookAuthor, bookYear, stateAvailable);
    Item availableItem = new Item(bookName, bookAuthor, bookYear, true);
    Item unavailableItem = new Item(bookName, bookAuthor, bookYear, false);
    List<Item> allItems = Arrays.asList(availableItem, unavailableItem);


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
        List<Item> testItemList = Arrays.asList(item);
        biblioteca.addItemsToTheASeccion(testItemList , "books");
        assertEquals(testItemList, biblioteca.getTotalItems());
    }


    @Test
    public void testReturnAvailableBooks() {
        List<Item> expectedOnlyAvailable = Arrays.asList(availableItem);
        biblioteca.addItemsToTheASeccion(allItems, "books");
        assertEquals(expectedOnlyAvailable, biblioteca.getItemsThatAreAvailable(true));
    }

    @Test
    public void testReturnNotAvailableBooks() {
        List<Item> expectedNotAvailable = Arrays.asList(unavailableItem);
        biblioteca.addItemsToTheASeccion(allItems, "books");
        assertEquals(expectedNotAvailable, biblioteca.getItemsThatAreAvailable(false));
    }


}
