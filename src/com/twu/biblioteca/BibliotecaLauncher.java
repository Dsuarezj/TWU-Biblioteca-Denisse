package com.twu.biblioteca;

public class BibliotecaLauncher {

    public static void main(String[] args) {
        Menu menu = new Menu();
        BooksList book = new BooksList ();

        menu.displayWelcome();
        book.displayBooksName();

    }



}
