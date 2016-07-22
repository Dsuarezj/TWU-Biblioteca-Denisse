package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    String bibliotecaName = "Bangalore Public Library";
    static List<Item> totalBooks = new ArrayList();
    static List<Item> totalMovies = new ArrayList();
    static List<Item> listOfAvailableItems = new ArrayList();

    public void startBookNameList() {
        System.out.println("The following articles are aviable:");
    }

    public void displayItemList(List<Item> listOfItems) {
        System.out.println();
        int numberOfBooks = listOfItems.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfItems.get(i));
        }
    }

    public void addItemsToTheASeccion(List<Item> items, String seccion) {
        for (Item item : items) {
            totalBooks.add(item);
        }
    }

    public List<Item> getTotalItems() {
        return totalBooks;
    }


    public List<Item> getItemsThatAreAvailable(boolean askedState) {
        List<Item> askedItems = new ArrayList<>();
        for (Item item : totalBooks) {
            if (askedState && item.isAvailable()) {
                askedItems.add(item);
            }
            if (!askedState && !item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }


    public void cleanUp() {
        listOfAvailableItems.clear();
        totalBooks.clear();
    }

}
