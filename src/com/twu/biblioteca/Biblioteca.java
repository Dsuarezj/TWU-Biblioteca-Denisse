package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    private static List<Item> totalBooks = new ArrayList<>();
    private static List<Item> totalMovies = new ArrayList<>();

    protected enum Section {
            BOOK, MOVIE
    }

    public void addItemsToASection(List<Item> items, Section section) {
        List<Item> itemListOfASection = selectTotalListFrom(section);
        for (Item item : items) {
            itemListOfASection.add(item);
        }
    }

    public void displayItemList(List<Item> listOfItems) {
        for (Item item : listOfItems) {
            int itemIndex = listOfItems.indexOf(item) + 1;
            System.out.print(itemIndex + ". " + item );
        }

    }

    public List<Item> getTotalItems(Section section) {
        return selectTotalListFrom(section);
    }

    public List<Item> getItemsThatAreAvailable(Section section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListFrom(section);
        for (Item item : itemFromASection) {
            if (item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    public List<Item> getItemsThatAreNotAvailable(Section section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListFrom(section);
        for (Item item : itemFromASection) {
            if (!item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    private List<Item> selectTotalListFrom(Section section) {
        if (Section.MOVIE.equals(section)) {
            return totalMovies;
        } else {
            return totalBooks;
        }
    }

    public void cleanUp() {
        totalBooks.clear();
        totalMovies.clear();
    }

}
