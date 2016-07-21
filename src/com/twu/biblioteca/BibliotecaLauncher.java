package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLauncher {

    static List<Book> listOfBookToIngress = new ArrayList<>();


    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        Biblioteca biblioteca = new Biblioteca();

        addListBooks();
        biblioteca.addBooksToTheBiblioteca(listOfBookToIngress);
        mainMenu.displayWelcome();
        mainMenu.displayMenu(mainMenu.getMainMenu());
        mainMenu.getUserInput();
        mainMenu.doSelectMainMenuOption();


    }

    public static List<Book> addListBooks() {
        Book book1 = new Book("Clockwork orange", "Anthony Burgess", 1962, true);
        Book book2 = new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, true);
        listOfBookToIngress.add(book1);
        listOfBookToIngress.add(book2);
        return listOfBookToIngress;
    }


}
