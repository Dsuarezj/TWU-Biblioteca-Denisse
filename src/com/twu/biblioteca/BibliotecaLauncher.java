package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaLauncher {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Login login = new Login();

        prepareBiblioteca();

        if (login.isLoginSuccess()) {
            System.out.println("Your personal information is: \n" + login.getUser());
            menu.displayWelcome();
            menu.displayMenu(menu.getMainMenu());
            menu.getInput();
            menu.selectMainMenuOption();
        }

        System.out.println("You Login information is not correct");
    }

    private static void prepareBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.addItemsToASection(addListBooks(), Biblioteca.Section.BOOK);
        biblioteca.addItemsToASection(addListMovies(), Biblioteca.Section.MOVIE);
    }

    private static List<Item> addListBooks() {
        Item item1 = new Item("Clockwork orange", "Anthony Burgess", 1962, true);
        Item item2 = new Item("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, true);
        List<Item> totalListOfBibliotecaBooks = Arrays.asList(item1, item2);
        return totalListOfBibliotecaBooks;
    }

    private static List<Item> addListMovies() {
        Item movie1 = new Item("Adventure time season 1", "Pendleton Ward", 2010, true);
        Item movie2 = new Item("V for Vendetta", "James McTeigue", 2006, true);
        List<Item> totalListOfBibliotecaMovies = Arrays.asList(movie1, movie2);
        return totalListOfBibliotecaMovies;
    }

}
