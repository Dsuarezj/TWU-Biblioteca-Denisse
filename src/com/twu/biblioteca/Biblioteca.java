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


    public void addBooksToTheBiblioteca(List<Book> books) {
        for (Book book : books) {
            totalBooks.add(book);
        }
    }

    public List<Book> getTotalBooks() {
        return totalBooks;
    }


    public void displayBookList(List<Book> listOfBooks) {
        System.out.println();
        int numberOfBooks = listOfBooks.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i + 1) + ". " + listOfBooks.get(i));
        }
    }

    public List<Book> getAvailableBookList() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : totalBooks) {
            if (book.getStateAvailable())
                availableBooks.add(book);
        }
        return availableBooks;
    }


    public List<Book> getNotAvailableBookList() {
        List<Book> notAvailableBooks = new ArrayList<>();
        for (Book book : totalBooks) {
            boolean bookStatusAvailable = book.getStateAvailable();
            if (bookStatusAvailable == false) {
                notAvailableBooks.add(book);
            }
        }
        return notAvailableBooks;
    }


    public void cleanUp() {
        listOfAvailableBooks.clear();
        totalBooks.clear();
    }
}
