package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Login {
    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);

    private List<User> allUsersRegistered = Arrays.asList(masterUser, firstUser);

    private User userLogin;
    private String loginInput;
    private boolean access;


    public boolean isRegistered(String testUser) {

        for (User user : allUsersRegistered) {
            if (testUser.equals(user.getId().toString())) {
                userLogin = user;
                return true;
            }
        }
        return false;
    }

    public boolean isLoginSuccess() {
        askForUserID();
        return access;
    }

    public boolean isPasswordCorrect(String password) {
        String userPassword = userLogin.getPassword();
        boolean isPasswordCorrect;
        isPasswordCorrect = userPassword.equals(password) ? true : false;
        return isPasswordCorrect;
    }

    public User getUser() {
        return userLogin;
    }

    private void askForUserID() {
        System.out.println("Ingress your user ID:");
        String userLoginInput = getLoginInput();
        boolean isUserCorrect = isRegistered(userLoginInput);
        if (isUserCorrect) {
            access = askPassword();
            return;
        }
        System.out.println("User Incorect");
    }

    private boolean askPassword() {
        System.out.println("Ingress your password:");
        String userPassword = getLoginInput();
        return isPasswordCorrect(userPassword);
    }

    private String getLoginInput() {
        readInput();
        return loginInput;
    }

    private void readInput() {
        Scanner input = new Scanner(System.in);
        loginInput = input.nextLine();
    }


}
