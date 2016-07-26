package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private User masterUser = new User("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123");
    private User firstUser = new User("000-0001", "first key", "First User", "first@biblioteca.com", "Bangalore", "123-123-123");

    @Test
    public void testUserAreEqualWhenTheInformationIsTheSame() {
        assertEquals(new User("000-0000", "master key", "Maestro", "master@biblioteca.com", "Bangalore", "123-123-123"), masterUser);
    }

    @Test
    public void testUserAreNotEqualWhenTheIDIsDifferent() {
        assertNotEquals(masterUser, firstUser);
    }

}
