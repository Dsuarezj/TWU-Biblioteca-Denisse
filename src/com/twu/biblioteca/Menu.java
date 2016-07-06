package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {

        private int userInput;
        private int numberOfMenuItems;
        private String [] menuItems = new String[numberOfMenuItems];
        ArrayList listOfBookToIngress = new ArrayList();


    void displayWelcome(){
        String welcomeMessage = "Welcome to the best biblioteca ever!";
        System.out.println(welcomeMessage);
    }


    public void addOption(String optionTest, int positionTest) {

    }

    public String getOption(int positionTest) {
    return "Option Test";
    }
}
