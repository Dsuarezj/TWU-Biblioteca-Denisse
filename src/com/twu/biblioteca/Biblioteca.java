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
        System.out.println("++++++++++ The following books are available: ++++++++++");
        System.out.println();
        int numberOfBooks = listOfBooks.size();
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println((i+1) + ". "+ listOfBooks.get(i));
        }
    }

    public ArrayList getAvailableBookList() {
        filterAvailableBooks();
        return listOfAvailableBooks;
    }

    public void filterAvailableBooks(){
        listOfAvailableBooks.clear();
        for (int i =0; i<getTotalBooks().size();i++){
            boolean bookStatusAvailable = getStatusOfABook(i);
            if (bookStatusAvailable){
                listOfAvailableBooks.add(listOfBooksTotal.get(i));
            }
        }
    }

    public boolean getStatusOfABook(int i) {
        book = (Book) listOfBooksTotal.get(i);
        boolean bookStatus = book.getStateAvailable();
        return bookStatus;
    }

    public ArrayList getNotAvailableBookList() {
        filterNotAvailableBooks();
        return listOfAvailableBooks;
    }

    private void filterNotAvailableBooks() {
        listOfAvailableBooks.clear();
        for (int i =0; i<getTotalBooks().size();i++){
            boolean bookStatusAvailable = getStatusOfABook(i);
            if (bookStatusAvailable == false){
                listOfAvailableBooks.add(listOfBooksTotal.get(i));
            }
        }

    }
}
