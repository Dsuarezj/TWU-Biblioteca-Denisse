package com.twu.biblioteca;

public class Book {

    private String bookName;
    private String bookAuthor;
    private int bookYear;
    private boolean stateAvailable;


    public Book(String bookName, String bookAuthor, int bookYear, boolean stateAvailable) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.stateAvailable = stateAvailable;
    }

    public String getBookName() {
        return bookName;
    }

    public boolean isAvailable() {
        return stateAvailable;
    }

    public void setBookStateAvailable(boolean state) {
        stateAvailable = state;
    }

    @Override
    public String toString() {
        return ("Book Name: " + this.bookName + "\n" +
                " Author: " + this.bookAuthor + "\n" +
                " Year : " + this.bookYear) + "\n";
    }


}

