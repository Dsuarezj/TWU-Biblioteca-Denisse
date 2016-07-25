package com.twu.biblioteca;

class Item {

    private String name;
    private String author;
    private int publishYear;
    private boolean stateAvailable;


    Item(String name, String author, int publishYear, boolean stateAvailable) {
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.stateAvailable = stateAvailable;
    }

    String getName() {
        return name;
    }

    boolean isAvailable() {
        return stateAvailable;
    }

    void setItemStateAvailable(boolean state) {
        stateAvailable = state;
    }

    @Override
    public String toString() {
        return ("Item Name: " + this.name + "\n" +
                " Author: " + this.author + "\n" +
                " Year : " + this.publishYear) + "\n";
    }


}

