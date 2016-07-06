package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Menu {

        private int userInput;
        private int numberOfMenuItems;
        ArrayList<String> menuItems = new ArrayList<String>();


    void displayWelcome(){
        String welcomeMessage = "Welcome to the best biblioteca ever!";
        System.out.println(welcomeMessage);
    }

    public void addOption(String option) {
        menuItems.add(option);
    }

    public String getOption(int itemPosition) {
    return menuItems.get(itemPosition);
    }
}
