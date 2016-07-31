package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Login {

    private User masterUser = new User("000-0000", new Password("master key"), "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private User firstUser = new User("000-0001", new Password("first key"), "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    private List<User> allUsersRegistered = Arrays.asList(masterUser, firstUser);

    private User userLogin;
    private String loginInput;
    private boolean access;

    Login() throws Password.CannotPerformOperationException {
    }


    public boolean isLoginSuccess() throws Password.CannotPerformOperationException, Password.InvalidHashException {
        askForUserID();
        return access;
    }

    public boolean isRegistered(String testUser) {
        for (User user : allUsersRegistered) {
            if (testUser.equals(user.getId())) {
                userLogin = user;
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordCorrect(String password) throws Password.InvalidHashException, Password.CannotPerformOperationException {
        Password expectedPassword = userLogin.getPassword();
        return  expectedPassword.verifyPassword(password,expectedPassword.getHash());
    }

    public User getUser() {
        return userLogin;
    }

    private void askForUserID() throws Password.InvalidHashException, Password.CannotPerformOperationException {
        System.out.println("Input your user ID:");
        String userLoginInput = getLoginInput();
        boolean isUserCorrect = isRegistered(userLoginInput);
        if (isUserCorrect) {
            access = askPassword();
        } else System.out.println("User Incorect");
    }

    private boolean askPassword() throws Password.CannotPerformOperationException, Password.InvalidHashException {
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
