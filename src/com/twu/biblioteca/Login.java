package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Login {
    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");
    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);

    public int loginInput;


    private List<String> allUsersRegistered = Arrays.asList(masterUser.getId(), firstUser.getId());

    public boolean isRegistered(String testUser) {
        if (allUsersRegistered.contains(testUser)){
            return true;
        }
        return false;
    }

}
