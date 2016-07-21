package com.twu.biblioteca;

import java.util.List;

public class BookMenu {
    Menu menu = new Menu();
    Biblioteca biblioteca = new Biblioteca();
    Book book;

    public void doBookListOption() {
        while (menu.userInput != menu.getBooksMenu().size()) {
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
        final List<Book> booksThatAreAvailable = biblioteca.getBooksThatAreAvailable(true);
        biblioteca.displayBookList(booksThatAreAvailable);
        menu.displayMenu(menu.getBooksMenu());
        menu.getUserInput();
        doBookListOption();
    }


    private void borrowBook() {
        List<Book> availableBookList = biblioteca.getBooksThatAreAvailable(true);
        if (availableBookList.size() == 0) {
            System.out.println("There are not books available. Come back later!");
            return;
        }

        System.out.println("Ingress the book ID that you want to borrow");
        int userBookSelection = menu.getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > availableBookList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            book = availableBookList.get(userBookSelection);
            setStateOfABook(userBookSelection, availableBookList, false);
            System.out.println("You borrow: " + book.getBookName() + ". Enjoy!");
        }
    }

    private void returnABook() {
        System.out.println("++++++++++ List of your borrow books ++++++++++ ");
        List<Book> notAvailableBookList = biblioteca.getBooksThatAreAvailable(false);
        if (notAvailableBookList.size() == 0) {
            System.out.println("You don't have any borrow books!");
            return;
        }
        biblioteca.displayBookList(notAvailableBookList);
        System.out.println("Ingress the book ID that you want to return");
        int userBookSelection = menu.getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > notAvailableBookList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            book = notAvailableBookList.get(userBookSelection);
            setStateOfABook(userBookSelection, notAvailableBookList, true);
            System.out.println("You return: " + book.getBookName() + ". Thanks!");
//            biblioteca.displayBookList(biblioteca.getBooksThatAreAvailable());
        }

    }

        private void setStateOfABook(int bookID, List<Book> listOfBooks, boolean state) {
            book = listOfBooks.get(bookID);
            book.setBookStateAvailable(state);
            listOfBooks.clear();
        }


}
