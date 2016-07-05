package com.twu.biblioteca;

public class BooksList {

    private boolean stateBorrow = true;
    private Book bookName = new Book();


    public void startBookNameList (){System.out.println("The books aviable are:");}

    public void displayBooksName() {
        this.startBookNameList();
        int numberOfBooks = bookName.getNameOfBook().size();
        for (int i = 0; i < numberOfBooks; i++) {
        System.out.println(bookName.getNameOfBook().get(i));
        }
    }
}
