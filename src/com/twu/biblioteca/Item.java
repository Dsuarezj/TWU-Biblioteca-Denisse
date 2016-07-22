package com.twu.biblioteca;

public class Item {

    private String name;
    private String author;
    private int publishYear;
    private boolean stateAvailable;


    public Item(String name, String author, int publishYear, boolean stateAvailable) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.stateAvailable = stateAvailable;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return stateAvailable;
    }

    public void setItemStateAvailable(boolean state) {
        stateAvailable = state;
    }

    @Override
    public String toString() {
        return ("Item Name: " + this.name + "\n" +
                " Author: " + this.author + "\n" +
                " Year : " + this.publishYear) + "\n";
    }


}

