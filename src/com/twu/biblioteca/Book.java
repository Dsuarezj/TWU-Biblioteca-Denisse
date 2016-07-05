package com.twu.biblioteca;

import java.util.ArrayList;

public class Book {

    private ArrayList <String> bookName = new ArrayList<>();

    void addBookName (){
        bookName.add("Clockwork orange");
        bookName.add("Alice's Adventures in Wonderland");
    }

    public ArrayList <String> getNameOfBook (){
        this.addBookName();
        return bookName;
    }


    /*private String[] bookNameArray = {"Clockwork orange", "Alice's Adventures in Wonderland"};
    private String[] bookAuthor = {"Anthony Burgess", "Lewis Carroll"};
    private String[] bookYear = {"1962", "1865"};
*/
}

