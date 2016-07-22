package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BibliotecaLauncher {

    static List<Item> listOfBooksToIngress = new ArrayList<>();
    static List<Item> listOfMoviesToIngress = new ArrayList<>();


    public static void main(String[] args) {

        Menu menu = new Menu();
        Login login = new Login();


        prepareBiblioteca();

        menu.displayWelcome();
        menu.displayMenu(menu.getMainMenu());
        menu.getInput();
        menu.doSelectMainMenuOption();


    }

    private static void prepareBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        addListBooks();
        addListMovies();
        biblioteca.addItemsToTheASeccion(listOfBooksToIngress, Biblioteca.ItemType.BOOK);
        biblioteca.addItemsToTheASeccion(listOfMoviesToIngress, Biblioteca.ItemType.MOVIE);
    }

    public static List<Item> addListBooks() {
        Item item1 = new Item("Clockwork orange", "Anthony Burgess", 1962, true);
        Item item2 = new Item("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, true);
        listOfBooksToIngress = Arrays.asList(item1, item2);
        return listOfBooksToIngress;
    }

    public static List<Item> addListMovies() {
        Item movie1 = new Item("Adventure time season 1", "Pendleton Ward", 2010, true);
        Item movie2 = new Item("V for Vendetta", "James McTeigue", 2006, true);
        listOfMoviesToIngress = Arrays.asList(movie1, movie2);
        return listOfMoviesToIngress;
    }


}
