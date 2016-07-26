package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Menu {

    private List<String> mainMenu = Arrays.asList("List of Books", "List of Movies", "Quit");
    Biblioteca biblioteca = new Biblioteca();
    int userInput;

    void displayWelcome() {
        String bibliotecaName = "Bangalore Public Library";
        String welcomeMessage = "Welcome to: " + bibliotecaName;
        System.out.println(welcomeMessage);
    }

    void readInput() {
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
    }

    int getInput() {
        readInput();
        return userInput;
    }

    void displayMenu(List<String> menuItems) {
        System.out.println("++++++++++ Menu Option ++++++++++");
        displayAListOfItems(menuItems);
    }

    void selectMainMenuOption() {
        while (userInput != mainMenu.size()) {
            BorrowReturnMenu borrowReturnMenu = new BorrowReturnMenu();

            switch (userInput) {
                case 1:
                    borrowReturnMenu.displayItemList(Biblioteca.section.BOOK);
                    return;
                case 2:
                    borrowReturnMenu.displayItemList(Biblioteca.section.MOVIE);
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readInput();
            }
        }

        System.out.printf("Come back again");
        System.exit(0);
    }

    void callMainMenu() {
        displayMenu(getMainMenu());
        getInput();
        selectMainMenuOption();
    }


    List<String> getMainMenu() {
        return mainMenu;
    }

    private void displayAListOfItems(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". " + items.get(i) + "\t");
        }
        System.out.println();
        System.out.println("Select the option number");

    }
}
