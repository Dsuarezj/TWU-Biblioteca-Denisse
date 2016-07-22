package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Login {

    private List<String> allUsersRegistered = Arrays.asList("000-0000", "000-0001");

    public boolean isUserRegister(String testUser) {
        if (allUsersRegistered.contains(testUser)){
            return true;
        }
        return false;
    }

}
