package com.twu.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    String bibliotecaName = "Bangalore Public Library";
    static ArrayList listOfBooksTotal = new ArrayList();
    static ArrayList listOfAvailableBooks = new ArrayList();
    Book book;

    public void startBookNameList() {
        System.out.println("The books aviable are:");
    }


    public void addBooksToTheBiblioteca(ArrayList books) {
        for (int i = 0; i < books.size(); i++)
            listOfBooksTotal.add(books.get(i));
    }


    public ArrayList getTotalBooks() {
        return listOfBooksTotal;
    }


    public void displayBookList(ArrayList listOfBooks) {
        int numberOfBooks = listOfBooks.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(listOfBooks.get(i));
        }
    }

    public ArrayList getAvailableBookList() {

        for (int i =0; i<getTotalBooks().size();i++){
            boolean bookStatusAvaiable = getStatusOfABook(i);
            if (bookStatusAvaiable){
                listOfAvailableBooks.add(listOfBooksTotal.get(i));
            }
        }


        return listOfAvailableBooks;
    }


    public boolean getStatusOfABook(int i) {
        book = (Book) listOfBooksTotal.get(i);
        boolean bookStatus = book.getStateAvailable();
        return bookStatus;
    }
}
