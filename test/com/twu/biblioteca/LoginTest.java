package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    Login login = new Login ();

    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");
    List<String> nonUserInformation = Arrays.asList("000-xxxx", "non key", "Non User", "non@biblioteca.com", "Bangalore", "123-123-123");

    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);

    @Test
    public void testIfMasterUserTryToAccessReturnTrue() {
        boolean isMasterUserRegistered = login.isRegistered(masterUser.getId());
        assertEquals(true, isMasterUserRegistered);
    }

    @Test
    public void testIfANonRegisteredUserTryToAccessReturnFalse() {
        String nonUser = "non-user";
        boolean isNonRegisteredUser = login.isRegistered(nonUser);
        assertEquals(false, isNonRegisteredUser);
    }

    @Test
    public void testIfAnotherRegisterUserTryToAccessReturnTrue() {
        boolean isARegisteredUser = login.isRegistered(firstUser.getId());
        assertEquals(true, isARegisteredUser);
    }

    @Test
    public void testIfMasterUserPassIsCorrect() {
    }


}
