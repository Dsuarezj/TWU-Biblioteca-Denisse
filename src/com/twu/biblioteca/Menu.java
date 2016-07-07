package com.twu.biblioteca;

import java.nio.channels.Pipe;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    int userInput;
    private int numberOfMenuItems;
    ArrayList<String> menuItems = new ArrayList<String>();
    String[] options = {"List of Books", "Quit"};
    Biblioteca biblioteca = new Biblioteca();

    void displayWelcome() {
        String welcomeMessage = "Welcome to: " + biblioteca.bibliotecaName;
        System.out.println(welcomeMessage);
    }

    public void addOption(String[] option) {
        for (int i = 0; i < option.length; i++)
            menuItems.add(option[i]);
    }

    public String getOption(int itemPosition) {
        return menuItems.get(itemPosition);
    }

    public void displayMenu() {
        addOption(options);
        System.out.println("++++++++++ Menu Option ++++++++++");

        for (int i = 0; i < options.length; i++)
            System.out.println((i + 1) + ". " + menuItems.get(i));

        System.out.println("Select the option number");
    }

    public void readUserInput() {
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
    }

    public int getUserInput() {
        readUserInput();
        return userInput;
    }

    public void doActionMenu() {
        while (userInput != menuItems.size())
        {
            switch (userInput){
                case 1:
                    Biblioteca biblioteca = new Biblioteca();
                    biblioteca.displayBookList(biblioteca.getAvailableBookList());
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readUserInput();
            }
        }

        System.out.printf("Come back again");
        System.exit(0);
    }


   /* public void selectOptionMenu (int userInput){
        switch (userInput){
            case 1:
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.displayBookList();
                return;
            default:
                System.out.printf("You chose wrong, try again. Select the option number \n");
                readUserInput();
        }
    }*/

}
