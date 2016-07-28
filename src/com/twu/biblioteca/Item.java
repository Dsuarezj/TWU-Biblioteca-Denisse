package com.twu.biblioteca;

import org.apache.commons.lang.builder.HashCodeBuilder;

class Item {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Item item = (Item) o;

        if (publishYear != item.publishYear) return false;
        if (stateAvailable != item.stateAvailable) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return author != null ? author.equals(item.author) : item.author == null;

    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(name)
                .append(author)
                .append(publishYear)
                .append(stateAvailable)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ("Item Name: " + this.name + "\n" +
                " Author: " + this.author + "\n" +
                " Year : " + this.publishYear) + "\n";
    }


}

