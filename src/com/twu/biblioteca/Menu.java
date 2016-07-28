package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Menu {

    public int userInput;
    private List<String> mainMenu = Arrays.asList("List of Books", "List of Movies", "Quit");

    public void displayWelcome() {
        String bibliotecaName = "Bangalore Public Library";
        String welcomeMessage = "Welcome to: " + bibliotecaName;
        System.out.println(welcomeMessage);
    }

    public void readInput() {
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
    }

    public int getInput() {
        readInput();
        return userInput;
    }

    public void displayMenu(List<String> menuItems) {
        System.out.println("++++++++++ Menu Option ++++++++++");
        displayAListOfItems(menuItems);
    }

    public void selectMainMenuOption() {
        while (userInput != mainMenu.size()) {
            BorrowReturnMenu borrowReturnMenu = new BorrowReturnMenu();

            switch (userInput) {
                case 1:
                    borrowReturnMenu.displayItemList(Biblioteca.Section.BOOK);
                    return;
                case 2:
                    borrowReturnMenu.displayItemList(Biblioteca.Section.MOVIE);
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readInput();
            }
        }

        System.out.printf("Come back again");
        System.exit(0);
    }

    public void callMainMenu() {
        displayMenu(getMainMenu());
        getInput();
        selectMainMenuOption();
    }


    public List<String> getMainMenu() {
        return mainMenu;
    }

    private void displayAListOfItems(List<String> items) {
        for (String item : items) {
            int itemIndex = items.indexOf(item) + 1;
            System.out.print(itemIndex + ". " + item + "\t");
        }
        System.out.println();
        System.out.println("Select the option number");

    }
}
