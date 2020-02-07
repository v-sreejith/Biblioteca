package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void shouldGreetCustomerWithWelcomeMessage() {
        Library library = new Library();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualMessage = library.welcomeMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}