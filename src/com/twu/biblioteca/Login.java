package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Login {
    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");
    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);

    public String loginInput;


    private List<String> allUsersRegistered = Arrays.asList(masterUser.getId(), firstUser.getId());

    public boolean isRegistered(String testUser) {
        if (allUsersRegistered.contains(testUser)){
            return true;
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




}
