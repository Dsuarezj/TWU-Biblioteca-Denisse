package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Login {
    private List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    private User masterUser = new User(masterUserInformation);
    private User firstUser = new User(firstUserInformation);

    private List<User> allUsersRegistered = Arrays.asList(masterUser, firstUser);

    private User userLogin;
    private String loginInput;
    private boolean access;


    boolean isLoginSuccess() {
        askForUserID();
        return access;
    }

    boolean isRegistered(String testUser) {

        for (User user : allUsersRegistered) {
            if (testUser.equals(user.getId())) {
                userLogin = user;
                return true;
            }
        }
        return false;
    }

    boolean isPasswordCorrect(String password) {
        String userPassword = userLogin.getPassword();
        boolean isPasswordCorrect;
        isPasswordCorrect = userPassword.equals(password);
        return isPasswordCorrect;
    }

    User getUser() {
        return userLogin;
    }

    private void askForUserID() {
        System.out.println("Input your user ID:");
        String userLoginInput = getLoginInput();
        boolean isUserCorrect = isRegistered(userLoginInput);
        if (isUserCorrect) {
            access = askPassword();
        } else System.out.println("User Incorect");
    }

    private boolean askPassword() {
        System.out.println("Input your password:");
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
