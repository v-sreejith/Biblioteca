package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LibraryTest {

    @Test
    public void shouldGreetCustomerWithWelcomeMessage() {
        Library library = new Library();
        String expectedMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        String actualMessage = library.welcomeMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void shouldReturnListOfBooks() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library library = new Library(books);

        List<Book> actualBooks = library.getAvailableBooks();

        assertEquals(books, actualBooks);
    }

    @Test
    public void shouldCheckoutABookAfterSelection() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library library = new Library(books);

        library.checkout(1);

        assertFalse(library.getAvailableBooks().contains(bookOne));
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckout() {
        Book book = mock(Book.class);
        Library library = new Library(Collections.singletonList(book));

        library.checkout(1);

        assertEquals("Thank you! Enjoy the book", library.checkoutMessage());
    }

    @Test
    public void shouldReturnFailureForWrongCheckout() {
        Library library = new Library();

        library.checkout(4);

        assertEquals("Sorry, that book is not available", library.checkoutMessage());
    }

    @Test
    public void shouldReceiveABookWhichWasIssued() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        Library library = new Library(List.of(bookOne, bookTwo, bookThree));

        library.checkout(2);
        library.receiveBook(bookTwo);

        assertTrue(library.getAvailableBooks().contains(bookTwo));
    }
}
