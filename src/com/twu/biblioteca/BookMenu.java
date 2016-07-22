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
        if (isListEmpty(availableBookList)) return;
        selectBookToChangeState(availableBookList, "return" ,false);
    }

    private void returnABook() {
        System.out.println("++++++++++ List of your borrow books ++++++++++ ");
        List<Book> notAvailableBookList = biblioteca.getBooksThatAreAvailable(false);

        if (isListEmpty(notAvailableBookList)) return;

        biblioteca.displayBookList(notAvailableBookList);
        selectBookToChangeState(notAvailableBookList, "borrow" ,true);

    }

    private void selectBookToChangeState(List<Book> BookList, String action,boolean newState) {
        System.out.println("Ingress the book ID that you want to " + action);
        int userBookSelection = menu.getUserInput() - 1;

        if (userBookSelection < 0 || userBookSelection > BookList.size()) {
            System.out.println("We can't process that!");
            return;
        } else {
            book = BookList.get(userBookSelection);
            setStateOfABook(userBookSelection, BookList, newState);
            System.out.println("You " + action + ": " + book.getBookName());
        }
    }

    private boolean isListEmpty(List<Book> notAvailableBookList) {
        if (notAvailableBookList.size() == 0) {
            System.out.println("There list is empty! Come back later!");
            return true;
        }
        return false;
    }

    private void setStateOfABook(int bookID, List<Book> listOfBooks, boolean state) {
            book = listOfBooks.get(bookID);
            book.setBookStateAvailable(state);
            listOfBooks.clear();
        }


}
