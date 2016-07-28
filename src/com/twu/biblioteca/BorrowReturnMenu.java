package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

class BorrowReturnMenu {

    private Biblioteca biblioteca = new Biblioteca();
    private Menu menu = new Menu();
    private Item item;

    private List<String> borrowReturnMenu = Arrays.asList("Borrow", "Return", "Go back");

    public void displayItemList(Biblioteca.Section section) {
        System.out.println("++++++++++ The following items are available: ++++++++++");
        final List<Item> booksThatAreAvailable = biblioteca.getItemsThatAreAvailable(section);
        biblioteca.displayItemList(booksThatAreAvailable);
        menu.displayMenu(borrowReturnMenu);
        menu.getInput();
        selectAction(section);
    }

    private void selectAction(Biblioteca.Section section) {
        while (borrowReturnMenu.size() != menu.userInput) {
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
                    menu.readInput();
                    break;
            }
        }
        menu.callMainMenu();
    }

    private void borrowItem(Biblioteca.Section section) {
        List<Item> availableItemList = biblioteca.getItemsThatAreAvailable(section);
        if (isListEmpty(availableItemList)) return;
        changeAvailableStatus(availableItemList, "borrow", false);
    }

    private void returnAItem(Biblioteca.Section section) {
        System.out.println("++++++++++ List of your borrow item ++++++++++ ");
        List<Item> notAvailableItemList = biblioteca.getItemsThatAreNotAvailable(section);

        if (isListEmpty(notAvailableItemList)) return;

        biblioteca.displayItemList(notAvailableItemList);
        changeAvailableStatus(notAvailableItemList, "return", true);

    }

    private void changeAvailableStatus(List<Item> itemList, String action, boolean availableStatus) {
        System.out.println("Ingress the item ID that you want to " + action);
        int userBookSelection = menu.userInput - 1;

        if (userBookSelection < 0 || userBookSelection >= itemList.size()) {
            System.out.println("We can't process that!");
        } else {
            item = itemList.get(userBookSelection);
            setStateOfABook(userBookSelection, itemList, availableStatus);
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
