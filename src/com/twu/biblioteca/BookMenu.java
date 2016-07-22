package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BookMenu {
    Menu menu = new Menu();
    Biblioteca biblioteca = new Biblioteca();
    Item item;

    private List<String> booksMenu = Arrays.asList("Borrow a book", "Return a book", "Go back");

    public void doBookListOption() {
        while (menu.userInput != booksMenu.size()) {
            switch (menu.userInput) {
                case 1:
                    borrowBook();
                    menu.callMainMenu();
                    return;
                case 2:
                    returnABook();
                    menu.callMainMenu();
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    menu.readUserInput();
            }
        }
        menu.callMainMenu();
    }

    public void doBookList() {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("++++++++++ The following books are available: ++++++++++");
        final List<Item> booksThatAreAvailable = biblioteca.getItemsThatAreAvailable(true);
        biblioteca.displayItemList(booksThatAreAvailable);
        menu.displayMenu(booksMenu);
        menu.getUserInput();
        doBookListOption();
    }


    private void borrowBook() {
        List<Item> availableItemList = biblioteca.getItemsThatAreAvailable(true);
        if (isListEmpty(availableItemList)) return;
        selectBookToChangeState(availableItemList, "return" ,false);
    }

    private void returnABook() {
        System.out.println("++++++++++ List of your borrow books ++++++++++ ");
        List<Item> notAvailableItemList = biblioteca.getItemsThatAreAvailable(false);

        if (isListEmpty(notAvailableItemList)) return;

        biblioteca.displayItemList(notAvailableItemList);
        selectBookToChangeState(notAvailableItemList, "borrow" ,true);

    }

    private void selectBookToChangeState(List<Item> itemList, String action, boolean newState) {
        System.out.println("Ingress the book ID that you want to " + action);
        int userBookSelection = menu.getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > itemList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            item = itemList.get(userBookSelection);
            setStateOfABook(userBookSelection, itemList, newState);
            System.out.println("You " + action + ": " + item.getName());
        }
    }

    private boolean isListEmpty(List<Item> notAvailableItemList) {
        if (notAvailableItemList.size() == 0) {
            System.out.println("The list is empty! Come back later!");
            return true;
        }
        return false;
    }

    private void setStateOfABook(int bookID, List<Item> listOfItems, boolean state) {
            item = listOfItems.get(bookID);
            item.setItemStateAvailable(state);
            listOfItems.clear();
        }


}
