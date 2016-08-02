package com.twu.biblioteca.items;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ItemTest {

    private Item item1 = new Item("Clockwork orange", "Anthony Burgess", 1962, true);
    private Item item2 = new Item("Alice's Adventures in Wonderland", "Lewis Carroll", 1865, true);

    @Test
    public void testItemAreEqualWhenTheInformationIsTheSame() {
        Item expectedItem = new Item("Clockwork orange", "Anthony Burgess", 1962, true);

        assertEquals(expectedItem, item1);
    }

    @Test
    public void testItemAreNotEqualWhenTheIDIsDifferent() {
        assertNotEquals(item1, item2);
    }
}
