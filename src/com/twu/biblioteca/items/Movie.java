package com.twu.biblioteca.items;

public class Movie extends Item {

    public Movie(String name, String author, int publishYear, boolean stateAvailable) {
        super(name, author, publishYear, stateAvailable);
        this.type = Item.Type.BOOK;

    }
}
