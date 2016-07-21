package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    String bibliotecaName = "Bangalore Public Library";
    static List<Book> totalBooks = new ArrayList();
    static List<Book> listOfAvailableBooks = new ArrayList();

    public void startBookNameList() {
        System.out.println("The books aviable are:");
    }

    public void displayBookList(List<Book> listOfBooks) {
        System.out.println();
        int numberOfBooks = listOfBooks.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfBooks.get(i));
        }
    }

    public void addBooksToTheBiblioteca(List<Book> books) {
        for (Book book : books) {
            totalBooks.add(book);
        }
    }

    public List<Book> getTotalBooks() {
        return totalBooks;
    }


    public List<Book> getBooksThatAreAvailable(boolean askedState) {
        List<Book> askedBooks = new ArrayList<>();
        for (Book book : totalBooks) {
            if (askedState && book.isAvailable()) {
                askedBooks.add(book);
            }
            if (!askedState && !book.isAvailable()) {
                askedBooks.add(book);
            }
        }
        return askedBooks;
    }


    public void cleanUp() {
        listOfAvailableBooks.clear();
        totalBooks.clear();
    }

}
