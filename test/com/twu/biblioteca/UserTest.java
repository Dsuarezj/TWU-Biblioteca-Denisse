package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private User masterUser = new User("000-0000", new Password("master key"), "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private User firstUser = new User("000-0001", new Password("first key"), "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    public UserTest() throws Password.CannotPerformOperationException {
    }

    @Test
    public void testUserAreEqualWhenTheInformationIsTheSame() throws Password.CannotPerformOperationException {
        assertEquals(new User("000-0000", new Password("master key"), "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123"), masterUser);
    }

    @Test
    public void testUserAreNotEqualWhenTheIDIsDifferent() {
        assertNotEquals(masterUser, firstUser);
    }

}
