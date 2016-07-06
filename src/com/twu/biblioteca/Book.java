package com.twu.biblioteca;

import java.util.ArrayList;

public class Book {

    private String bookName;
    private String bookAuthor;
    private int bookYear;
    private boolean stateBorrow = true;


    public Book (String bookName, String bookAuthor, int bookYear) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookYear=bookYear;

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

    @Override
    public String toString() {
        return ("Book Name: "+this.getBookName()+ "\n"+
                " Author: "+ this.getBookAuthor() +"\n"+
                " Year : " + this.getBookYear())+ "\n";
    }




   /* void addBookName() {
        bookName.add("Clockwork orange");
        bookName.add("Alice's Adventures in Wonderland");
    }

    ArrayList<String> getBookNameList() {
        this.addBookName();
        return bookName;
    }


    void addBookAuthor() {
        bookAuthor.add("Anthony Burgess");
        bookAuthor.add("Lewis Carroll");
    }

    ArrayList<String> getBookAuthorList() {
        this.addBookAuthor();
        return bookAuthor;
    }

    void addBookYear() {
        bookYear.add("1962");
        bookYear.add("1865");
    }

    ArrayList<String> getBookYearList() {
        this.addBookYear();
        return bookYear;
    }
*/

}

