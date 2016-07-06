package com.twu.biblioteca;

import java.util.ArrayList;

public class BooksList {
    private String bibliotecaName = "Bangalore Public Library";

    private Book book1 = new Book("Clockwork orange", "Anthony Burgess", 1962);
    private Book book2 = new Book("Alice's Adventures in Wonderland","Lewis Carroll", 1865);
    ArrayList listOfBookToIngress = new ArrayList();
    ArrayList listOfBooksAvailable = new ArrayList();


    public void startBookNameList (){System.out.println("The books aviable are:");}

    public ArrayList ingressBooksTheBiblioteca(){
        listOfBookToIngress.add (book1);
        listOfBookToIngress.add(book2);
        return listOfBookToIngress;
    }

    public void addBooksToTheBiblioteca(ArrayList books){
        for (int i=0; i< books.size(); i++)
        listOfBooksAvailable.add (books.get(i));
    }

    public void displayBookList (){
        addBooksToTheBiblioteca(ingressBooksTheBiblioteca());
        int booksAvailable = listOfBooksAvailable.size();

        for (int i = 0; i<booksAvailable; i++ ){
            System.out.println(listOfBooksAvailable.get(i));
        }
    }

    public ArrayList getABooksAvailable() {
        return listOfBooksAvailable;
    }







   /* public void displayBooksName() {
        startBookNameList();
        int numberOfBooks = bookName.getBookNameList().size();
        for (int i = 0; i < numberOfBooks; i++) {
        System.out.println(bookName.getBookNameList().get(i));
        }
    }

    public void displayBookListComplete (){
        startBookNameList();
        int numberOfBooks = bookName.getBookNameList().size();
        for (int i = 1; i <= numberOfBooks; i++) {
            System.out.print(i + "\t");
            System.out.print(bookName.getBookNameList().get(i) + "\t");
            System.out.print(bookName.getBookAuthorList().get(i) + "\t");
            System.out.print(bookName.getBookYearList().get(i) + "\t");
            System.out.println();
        }
    }*/
}
