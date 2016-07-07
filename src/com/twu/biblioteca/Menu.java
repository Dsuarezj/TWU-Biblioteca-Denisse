package com.twu.biblioteca;

import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    int userInput;
    ArrayList<String> mainMenu = new ArrayList<>();
    ArrayList<String> borrowMenu = new ArrayList<>();
    String[] mainMenuOptions = {"List of Books", "Quit"};
    String[] borrowMenuOptions = {"Borrow a book", "Return a book", "Go back"};
    Biblioteca biblioteca = new Biblioteca();
    Book book;


    void displayWelcome() {
        String welcomeMessage = "Welcome to: " + biblioteca.bibliotecaName;
        System.out.println(welcomeMessage);
    }

    public void addOption(String[] options, ArrayList<String> menu) {
        for (int i = 0; i < options.length; i++)
            menu.add(options[i]);
    }

    public String getOption(int itemPosition, ArrayList<String> menu) {
        return menu.get(itemPosition);
    }

    public void readUserInput() {
        Scanner input = new Scanner(System.in);
        userInput = input.nextInt();
    }

    public int getUserInput() {
        readUserInput();
        return userInput;
    }

    public void displayMainMenu() {
        mainMenu.clear();
        addOption(mainMenuOptions, mainMenu);
        System.out.println("++++++++++ Menu Option ++++++++++");
        printAMenu(mainMenu);
        System.out.println();
        System.out.println("Select the option number");
    }

    private void printAMenu(ArrayList items) {
        for (int i = 0; i < items.size(); i++)
            System.out.print((i + 1) + ". " + items.get(i) + "\t");
    }


    public void doSelectMainMenuOption() {
        while (userInput != mainMenu.size()) {
            switch (userInput) {
                case 1:
                    doBookList();
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readUserInput();
            }
        }

        System.out.printf("Come back again");
        System.exit(0);
    }


    public void displayListBookMenu() {
        borrowMenu.clear();
        addOption(borrowMenuOptions, borrowMenu);
        System.out.println("++++++++++ What you want to do: ++++++++++");
        printAMenu(borrowMenu);
        System.out.println();
        System.out.println("Select the option number");
    }

    public void doBookListOption() {
        while (userInput != borrowMenu.size()) {
            switch (userInput) {
                case 1:
                    borrowBook();
                    callMainMenu();
                    return;
                case 2:
                    returnABook();
                    callMainMenu();
                    return;
                default:
                    System.out.printf("You chose wrong, try again. Select the option number \n");
                    readUserInput();
            }
        }
        callMainMenu();
    }

    private void callMainMenu() {
        displayMainMenu();
        getUserInput();
        doSelectMainMenuOption();
    }


    private void borrowBook() {
        System.out.println("Ingress the book ID that you want to borrow");
        ArrayList availableBookList = biblioteca.getAvailableBookList();
        int userBookSelection = getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > availableBookList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            book = (Book) availableBookList.get(userBookSelection);
            selectABookFromAList(userBookSelection, availableBookList);
            System.out.println("You borrow: " + book.getBookName() + ". Enjoy!");
//            biblioteca.displayBookList(biblioteca.getAvailableBookList());
        }
    }

    private void returnABook() {
        System.out.println("++++++++++ List of your borrow books ++++++++++ ");
        ArrayList notAvailableBookList = biblioteca.getNotAvailableBookList();
        biblioteca.displayBookList(notAvailableBookList);

        System.out.println("Ingress the book ID that you want to return");
        int userBookSelection = getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > notAvailableBookList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            book = (Book) notAvailableBookList.get(userBookSelection);
            selectABookFromAList(userBookSelection, notAvailableBookList);
            System.out.println("You return: " + book.getBookName() + ". Thanks!");
//            biblioteca.displayBookList(biblioteca.getAvailableBookList());
        }

    }

    void selectABookFromAList(int bookID, ArrayList listOfBooks) {
        book = (Book) listOfBooks.get(bookID);
        book.setStateAvailable(false);
        listOfBooks.clear();
    }


    private void doBookList() {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println("++++++++++ The following books are available: ++++++++++");
        biblioteca.displayBookList(biblioteca.getAvailableBookList());
        displayListBookMenu();
        getUserInput();
        doBookListOption();
    }
}
