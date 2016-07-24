package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    Login login = new Login ();
    private ByteArrayOutputStream byteArrayOutputStream;

    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");
    List<String> nonUserInformation = Arrays.asList("000-xxxx", "non key", "Non User", "non@biblioteca.com", "Bangalore", "123-123-123");

    User masterUserTest = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testIfMasterUserTryToAccessReturnTrue() {
        boolean isMasterUserRegistered = login.isRegistered(masterUserTest.getId());
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
    public void testReturnMasterUserObjectUsingMasterId() {
        login.isRegistered(masterUserTest.getId());
        User requestUser = login.getUser();
        assertEquals(masterUserTest, requestUser);
    }

    @Test
    public void testShouldReturnTrueIfMasterUserLoginUsingMasterPass() {
        login.isRegistered(masterUserTest.getId());
        boolean isPasswordCorrect =  login.checkPassword(masterUserInformation.get(1));
        assertEquals(true, isPasswordCorrect);
    }


}
