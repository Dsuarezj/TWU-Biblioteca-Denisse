package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest {

    @Test
    public void testIfTestUserIsRegister() {
        String testUser = "test-user";
        Login login = new Login ();

        boolean isTestUserRegister = login.isUserRegister(testUser);

        assertEquals(true, isTestUserRegister);

    }




    @Test
    public void testUserPassIsCorrect() {
    }

}
