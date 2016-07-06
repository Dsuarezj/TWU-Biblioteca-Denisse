package com.twu.biblioteca;

public class BibliotecaLauncher {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayWelcome();
        BooksList totalList = new BooksList();
        totalList.displayBookList();

    }



}
