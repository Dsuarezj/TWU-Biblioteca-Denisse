package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    Login login = new Login ();

    @Test
    public void testIfARegisteredUserTryToAccess() {
        String registeredUser = "test-user";
        boolean isTestUserRegister = login.isUserRegister(registeredUser);
        assertEquals(true, isTestUserRegister);

    }

    @Test
    public void testIfANonRegisteredUserTryToAccess() {
        String nonUser = "non-user";
        boolean isNonUserRegistered = login.isUserRegister(nonUser);
        assertEquals(false, isNonUserRegistered);
    }

    @Test
    public void testUserPassIsCorrect() {
    }

}
