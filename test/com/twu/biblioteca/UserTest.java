package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {
    List<String> masterUserInformation = Arrays.asList("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    List<String> firstUserInformation = Arrays.asList("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    User masterUser = new User(masterUserInformation);
    User firstUser = new User(firstUserInformation);
    @Test
    public void testUserAreEqualWhenTheInformationIsTheSame() {
        assertEquals(masterUser, new User(masterUserInformation));
    }

    @Test
    public void testUserAreNotEqualWhenTheIDIsDifferent() {
        assertNotEquals(masterUser, firstUser);
    }

    @Test
    public void testGetPasswordUsingUserID() {

    }
}
