package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private Login login = new Login();

    private List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    private User masterUserTest = new User("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private User firstUser = new User("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    @Before
    public void setUp() {
        ByteArrayOutputStream byteArrayOutputStream;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testIfMasterUserTryToAccessReturnTrue() {
        boolean isMasterUserRegistered = login.isRegistered("000-0000");
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
        boolean isPasswordCorrect = login.isPasswordCorrect(masterUserInformation.get(1));
        assertEquals(true, isPasswordCorrect);
    }


    @Test
    public void testShouldReturnFalseIfMasterUserLoginUsingWrongPass() {
        login.isRegistered(masterUserTest.getId());
        boolean isPasswordCorrect = login.isPasswordCorrect("wrong pass");
        assertEquals(false, isPasswordCorrect);
    }

}
