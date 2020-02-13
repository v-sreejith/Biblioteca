package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LibraryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library<Book> library = new Library<>(books);

        List<Book> actualBooks = library.getAvailableItems();

        assertEquals(books, actualBooks);
    }

    @Test
    public void shouldCheckoutABookAfterSelection() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library<Book> library = new Library<>(books);

        library.checkoutItems(bookOne);

        assertFalse(library.getAvailableItems().contains(bookOne));
        assertTrue(library.getIssuedItems().contains(bookOne));
    }

    @Test
    public void shouldReceiveABookWhichWasIssued() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        Library<Book> library = new Library<Book>(List.of(bookOne, bookTwo, bookThree));

        library.checkoutItems(bookTwo);
        library.receiveItem(bookTwo);

        assertTrue(library.getAvailableItems().contains(bookTwo));
        assertFalse(library.getIssuedItems().contains(bookTwo));
    }

    @Test
    public void shouldReturnListOfMovies() {
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        Movie movieThree = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo, movieThree);
        Library<Movie> library = new Library<>(movies);

        List<Movie> actualMovies = library.getAvailableItems();

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
        Library<Movie> library = new Library<>(movies);

        library.checkoutItems(movieOne);

        assertFalse(library.getAvailableItems().contains(movieOne));
    }

    @Test
    public void shouldThrowExceptionForWrongBookCheckout() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Library<Book> library = new Library<>(books);

        assertThrows(InvalidItemException.class,()->library.checkoutItems(bookThree));
    }

    @Test
    public void shouldReceiveMovieIssued() throws InvalidItemException {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Library<Movie> library = new Library<>(movies);

        library.checkoutItems(movieOne);
        library.receiveItem(movieOne);

        assertTrue(library.getAvailableItems().contains(movieOne));
        assertFalse(library.getIssuedItems().contains(movieOne));
    }
}
