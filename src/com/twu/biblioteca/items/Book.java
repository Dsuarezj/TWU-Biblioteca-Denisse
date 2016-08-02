package com.twu.biblioteca.items;

public class Book extends Item {

    public Book(String name, String author, int publishYear, boolean stateAvailable) {
        super(name, author, publishYear, stateAvailable);
        this.type = Type.BOOK;

    }

}
