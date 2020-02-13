package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class InventoryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Inventory<Book> inventory = new Inventory<>(books);

        List<Book> actualBooks = inventory.getAvailableItems();

        assertEquals(books, actualBooks);
    }

    @Test
    public void shouldCheckoutABookAfterSelection() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Inventory<Book> inventory = new Inventory<>(books);

        inventory.checkoutItems(bookOne);

        assertFalse(inventory.getAvailableItems().contains(bookOne));
        assertTrue(inventory.getIssuedItems().contains(bookOne));
    }

    @Test
    public void shouldReceiveABookWhichWasIssued() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        Inventory<Book> inventory = new Inventory<Book>(List.of(bookOne, bookTwo, bookThree));

        inventory.checkoutItems(bookTwo);
        inventory.receiveItem(bookTwo);

        assertTrue(inventory.getAvailableItems().contains(bookTwo));
        assertFalse(inventory.getIssuedItems().contains(bookTwo));
    }

    @Test
    public void shouldReturnListOfMovies() {
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        Movie movieThree = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo, movieThree);
        Inventory<Movie> inventory = new Inventory<>(movies);

        List<Movie> actualMovies = inventory.getAvailableItems();

        assertEquals(movies, actualMovies);
    }

    @Test
    public void shouldCheckoutAMovieAfterSelection() throws InvalidItemException {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Inventory<Movie> inventory = new Inventory<>(movies);

        inventory.checkoutItems(movieOne);

        assertFalse(inventory.getAvailableItems().contains(movieOne));
    }

    @Test
    public void shouldThrowExceptionForWrongBookCheckout() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Inventory<Book> inventory = new Inventory<>(books);

        assertThrows(InvalidItemException.class,()-> inventory.checkoutItems(bookThree));
    }

    @Test
    public void shouldReceiveMovieIssued() throws InvalidItemException {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Inventory<Movie> inventory = new Inventory<>(movies);

        inventory.checkoutItems(movieOne);
        inventory.receiveItem(movieOne);

        assertTrue(inventory.getAvailableItems().contains(movieOne));
        assertFalse(inventory.getIssuedItems().contains(movieOne));
    }
}
