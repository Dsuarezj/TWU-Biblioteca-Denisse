package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    final String bibliotecaName = "Bangalore Public Library";
    static List<Item> totalBooks = new ArrayList();
    static List<Item> totalMovies = new ArrayList();

    static List<Item> listOfAvailableMovies = new ArrayList();
    static List<Item> listOfAvailableBooks = new ArrayList();

    public void startBookNameList() {
        System.out.println("The following articles are aviable:");
    }

    public enum ItemType {
        BOOK, MOVIE
    }

    public void displayItemList(List<Item> listOfItems) {
        System.out.println();
        int numberOfBooks = listOfItems.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfItems.get(i));
        }
    }

    public void addItemsToTheASeccion(List<Item> items, ItemType section) {
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        for (Item item : items) {
            itemFromASection.add(item);
        }
    }

    public List<Item> getTotalItems(ItemType section) {
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        return itemFromASection;
    }

    public List<Item> getItemsThatAreAvailable(ItemType section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListThatAreIn(section);
        for (Item item : itemFromASection) {
            if (item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }

    public List<Item> getItemsThatAreNotAvailable(ItemType section) {
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

    public void cleanUp() {
        listOfAvailableBooks.clear();
        totalBooks.clear();
        listOfAvailableMovies.clear();
        totalMovies.clear();
    }

}
