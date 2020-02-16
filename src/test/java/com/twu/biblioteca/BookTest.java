package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class BookTest {

    @Test
    public void shouldEquateTwoBooks() {
        Book bookOne = new Book("ABC", "meee", 2000);
        Book bookTwo = new Book("ABC", "meee", 2000);

        assertThat(bookOne, is(equalTo(bookTwo)));
    }
}
