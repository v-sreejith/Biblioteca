package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {

    @Test
    public void shouldGreetCustomerWithWelcomeMessage() {
        Biblioteca biblioteca = new Biblioteca();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualMessage = biblioteca.welcomeMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}