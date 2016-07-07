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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookStateAvailable(boolean state) {
        if (state) stateAvailable = true;
        else stateAvailable = false;
    }

    @Override
    public String toString() {
        return ("Book Name: " + this.getBookName() + "\n" +
                " Author: " + this.getBookAuthor() + "\n" +
                " Year : " + this.getBookYear()) + "\n";
    }


    public boolean getStateAvailable() {
        return stateAvailable;
    }
}

