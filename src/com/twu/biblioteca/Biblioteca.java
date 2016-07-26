package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    private static List<Item> totalBooks = new ArrayList();
    private static List<Item> totalMovies = new ArrayList();

    protected enum section {
        BOOK, MOVIE
    }

    public void addItemsToASection(List<Item> items, section section) {
        List<Item> itemListOfASection = selectTotalListFrom(section);
        for (Item item : items) {
            itemListOfASection.add(item);
        }
    }

    public void displayItemList(List<Item> listOfItems) {
        System.out.println();
        int numberOfBooks = listOfItems.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfItems.get(i));
        }
    }

    public List<Item> getTotalItems(section section) {
        return selectTotalListFrom(section);
    }

    public List<Item> getItemsThatAreAvailable(section section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListFrom(section);
        for (Item item : itemFromASection) {
            if (item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    public List<Item> getItemsThatAreNotAvailable(section section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListFrom(section);
        for (Item item : itemFromASection) {
            if (!item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    private List<Item> selectTotalListFrom(section section) {
        if (Biblioteca.section.MOVIE.equals(section)) {
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
