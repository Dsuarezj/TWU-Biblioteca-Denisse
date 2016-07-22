package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    Login login = new Login ();

    @Test
    public void testIfMasterUserTryToAccessReturnTrue() {
        String masterUser = "000-0000";
        boolean isMasterUser = login.isUserRegister(masterUser);
        assertEquals(true, isMasterUser);

    }

    @Test
    public void testIfANonRegisteredUserTryToAccessReturnFalse() {
        String nonUser = "non-user";
        boolean isNonRegisteredUser = login.isUserRegister(nonUser);
        assertEquals(false, isNonRegisteredUser);
    }

    @Test
    public void testIfAnotherRegisterUserTryToAccessReturnTrue() {
        String anotherRegisteredUser = "000-0001";
        boolean isARegisteredUser = login.isUserRegister(anotherRegisteredUser);
        assertEquals(true, isARegisteredUser);
    }

    @Test
    public void testIfMasterUserPassIsCorrect() {
    }


}
