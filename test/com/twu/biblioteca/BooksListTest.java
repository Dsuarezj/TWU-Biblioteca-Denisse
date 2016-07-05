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
    public void displayFirstNameBooksTest() {
        allBookList.startBookNameList();
        assertEquals("The books aviable are:\n", byteArrayOutputStream.toString());
    }



}
