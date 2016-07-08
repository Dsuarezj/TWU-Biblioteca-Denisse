package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaLauncher {

    private static Book book1 = new Book("Clockwork orange", "Anthony Burgess", 1962, true);
    private static Book book2 = new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, true);
    static List listOfBookToIngress = new ArrayList();


    public static void main(String[] args) {

        Menu menu = new Menu();
        Biblioteca biblioteca = new Biblioteca();

        addListBooks();
        biblioteca.addBooksToTheBiblioteca(listOfBookToIngress);
        menu.displayWelcome();
        menu.displayMainMenu();
        menu.getUserInput();
        menu.doSelectMainMenuOption();


    }

    public static List<Book> addListBooks() {
        listOfBookToIngress.add(book1);
        listOfBookToIngress.add(book2);
        return listOfBookToIngress;
    }


}
