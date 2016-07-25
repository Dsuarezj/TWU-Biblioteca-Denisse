package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {

    private static List<Item> totalBooks = new ArrayList();
    private static List<Item> totalMovies = new ArrayList();


    enum ItemType {
        BOOK, MOVIE
    }

    void displayItemList(List<Item> listOfItems) {
        System.out.println();
        int numberOfBooks = listOfItems.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfItems.get(i));
        }
    }

    void addItemsToTheASeccion(List<Item> items, ItemType section) {
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        for (Item item : items) {
            itemFromASection.add(item);
        }
    }

    List<Item> getTotalItems(ItemType section) {
        return selectTotalListThatAreIn(section);
    }

    List<Item> getItemsThatAreAvailable(ItemType section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        for (Item item : itemFromASection) {
            if (item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    List<Item> getItemsThatAreNotAvailable(ItemType section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        for (Item item : itemFromASection) {
            if (!item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    private List<Item> selectTotalListThatAreIn(ItemType section) {
        if (ItemType.MOVIE.equals(section)) {
            return totalMovies;
        } else {
            return totalBooks;
        }
    }

    void cleanUp() {
        totalBooks.clear();
        totalMovies.clear();
    }

}
