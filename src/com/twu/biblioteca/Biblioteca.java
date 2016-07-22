package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    String bibliotecaName = "Bangalore Public Library";
    static List<Item> totalBooks = new ArrayList();
    static List<Item> totalMovies = new ArrayList();

    static List<Item> listOfAvailableMovies = new ArrayList();
    static List<Item> listOfAvailableBooks = new ArrayList();

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

    public void addItemsToTheASeccion(List<Item> items, String section) {
        List<Item> itemFromASection = selectTotalListAccordingTheSection(section);
        for (Item item : items) {
            itemFromASection.add(item);
        }
    }

    public List<Item> getTotalItems(String section) {
        List<Item> itemFromASection = selectTotalListAccordingTheSection(section);
        return itemFromASection;
    }


    public List<Item> getItemsThatAreAvailable(boolean askedState, String section) {
        List<Item> askedItems = new ArrayList<>();
        List<Item> itemFromASection = selectTotalListAccordingTheSection(section);
        for (Item item : itemFromASection) {
            if (askedState && item.isAvailable()) {
                askedItems.add(item);
            }
            if (!askedState && !item.isAvailable()) {
                askedItems.add(item);
            }
        }
        return askedItems;
    }


    private List<Item> selectTotalListAccordingTheSection(String section) {
        if (section == "books"){
            return totalBooks;
        }
        else if (section == "movies"){
            return totalMovies;
        }
        return  null;
    }



    public void cleanUp() {
        listOfAvailableBooks.clear();
        totalBooks.clear();
        listOfAvailableMovies.clear();
        totalMovies.clear();
    }

}
