package com.twu.biblioteca;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Login {
    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);
    private User userLogin;
    private String loginInput;


    private List<User> allUsersRegistered = Arrays.asList(masterUser, firstUser);

    public boolean isRegistered(String testUser) {

       for (User user : allUsersRegistered){
           if (testUser == user.getId().toString()) {
               userLogin = user;
               return true;
           }
       }
        return false;
    }

    public void askForUserId() {
        System.out.println("Ingress your user ID:");
        getLoginInput();
    }

    private void readInput() {
        Scanner input = new Scanner(System.in);
        loginInput = input.nextLine();
    }

    private String getLoginInput() {
        readInput();
        return loginInput;
    }


    public User getUser() {
        return userLogin;
    }

    public boolean isPasswordCorrect(String password) {
        String userPassword = userLogin.getPassword();
        boolean isPasswordCorrect;
        isPasswordCorrect = userPassword == password ? true : false;
        return isPasswordCorrect;
    }
}
