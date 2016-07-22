package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BorrowReturnMenu {
    Menu menu = new Menu();
    Biblioteca biblioteca = new Biblioteca();
    Item item;

    private List<String> borrowReturnMenu = Arrays.asList("Borrow", "Return", "Go back");

    public void doItemListOption(String section) {
        while (menu.userInput != borrowReturnMenu.size()) {
            switch (menu.userInput) {
                case 1:
                    borrowItem(section);
                    menu.callMainMenu();
                    return;
                case 2:
                    returnAItem(section);
                    menu.callMainMenu();
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    menu.readUserInput();
            }
        }
        menu.callMainMenu();
    }

    public void displayItemList(String section) {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("++++++++++ The following "+ section + "are available: ++++++++++");
        final List<Item> booksThatAreAvailable = biblioteca.getItemsThatAreAvailable(true, section);
        biblioteca.displayItemList(booksThatAreAvailable);
        menu.displayMenu(borrowReturnMenu);
        menu.getUserInput();
        doItemListOption(section);
    }


    private void borrowItem(String section) {
        List<Item> availableItemList = biblioteca.getItemsThatAreAvailable(true, section);
        if (isListEmpty(availableItemList)) return;
        selectItemToChangeState(availableItemList, "borrow" ,false);
    }

    private void returnAItem(String section) {
        System.out.println("++++++++++ List of your borrow " + section + " ++++++++++ ");
        List<Item> notAvailableItemList = biblioteca.getItemsThatAreAvailable(false, section);

        if (isListEmpty(notAvailableItemList)) return;

        biblioteca.displayItemList(notAvailableItemList);
        selectItemToChangeState(notAvailableItemList, "return" ,true);

    }

    private void selectItemToChangeState(List<Item> itemList, String action, boolean newState) {
        System.out.println("Ingress the item ID that you want to " + action);
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
