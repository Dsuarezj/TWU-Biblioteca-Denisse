package com.twu.biblioteca;

import java.lang.reflect.Array;

public class Menu {

        private int userInput;
        private int numberOfMenuItems;
        private String [] menuItems = new String[numberOfMenuItems];


    void displayWelcome(){
        String welcomeMessage = "Welcome to the best biblioteca ever!";
        System.out.println(welcomeMessage);
    }

}
