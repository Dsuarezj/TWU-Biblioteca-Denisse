package com.twu.biblioteca;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class PasswordTest {
    @Test
    public void testPasswordMatchesInput() throws Password.CannotPerformOperationException, Password.InvalidHashException {
        Password password = new Password("password");
        String expectedPassword = password.getHash();
        boolean status = password.verifyPassword("password", expectedPassword);
        Assert.assertThat(status, Is.is(true));

    }

    @Test
    public void shouldReturnFalseWhenPasswordsDoNotMatch() throws Password.CannotPerformOperationException, Password.InvalidHashException {
        Password password = new Password("password");
        String expectedPassword = password.getHash();
        boolean status = password.verifyPassword("no password", expectedPassword);
        Assert.assertThat(status, Is.is(false));

    }

}
