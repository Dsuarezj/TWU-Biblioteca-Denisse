package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<String> mainMenu = Arrays.asList("List of Books", "List of Movies", "Quit");
    Biblioteca biblioteca = new Biblioteca();
    public int userInput;

    public void displayWelcome() {
        String welcomeMessage = "Welcome to: " + biblioteca.bibliotecaName;
        System.out.println(welcomeMessage);
    }

    public void readUserInput() {
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
    }

    public int getUserInput() {
        readUserInput();
        return userInput;
    }

    public void displayMenu(List<String> menuItems) {
        System.out.println("++++++++++ Menu Option ++++++++++");
        buildAListOfItems(menuItems);
    }

    public void doSelectMainMenuOption() {
        while (userInput != mainMenu.size()) {
            BorrowReturnMenu borrowReturnMenu = new BorrowReturnMenu();

            switch (userInput) {
                case 1:
                    borrowReturnMenu.displayItemList("books");
                    return;
                case 2:
                    borrowReturnMenu.displayItemList("movies");
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readUserInput();
            }
        }

        System.out.printf("Come back again");
        System.exit(0);
    }

    public void callMainMenu() {
        displayMenu(getMainMenu());
        getUserInput();
        doSelectMainMenuOption();
    }


    public List<String> getMainMenu() {
        return mainMenu;
    }

    private void buildAListOfItems(List<String> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". " + items.get(i) + "\t");
        }
        System.out.println();
        System.out.println("Select the option number");

    }


}
