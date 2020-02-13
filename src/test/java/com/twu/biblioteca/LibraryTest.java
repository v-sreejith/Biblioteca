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
        Library library = new Library(books, List.of(mock(Movie.class)));

        List<Book> actualBooks = library.getAvailableBooks();

        assertEquals(books, actualBooks);
    }

    @Test
    public void shouldCheckoutABookAfterSelection() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library library = new Library(books, List.of(mock(Movie.class)));

        library.checkoutBook(bookOne);

        assertFalse(library.getAvailableBooks().contains(bookOne));
        assertTrue(library.getIssuedBooks().contains(bookOne));
    }

    @Test
    public void shouldReceiveABookWhichWasIssued() throws Exception {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        Library library = new Library(List.of(bookOne, bookTwo, bookThree), List.of(mock(Movie.class)));

        library.checkoutBook(bookTwo);
        library.receiveBook(bookTwo);

        assertTrue(library.getAvailableBooks().contains(bookTwo));
        assertFalse(library.getIssuedBooks().contains(bookTwo));
    }

    @Test
    public void shouldReturnListOfMovies() {
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        Movie movieThree = mock(Movie.class);
        Book book = mock(Book.class);
        List<Movie> movies = List.of(movieOne, movieTwo, movieThree);
        Library library = new Library(List.of(book), movies);

        List<Movie> actualMovies = library.getAvailableMovies();

        assertEquals(movies, actualMovies);
    }

    @Test
    public void shouldCheckoutAMovieAfterSelection() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Library library = new Library(books, movies);

        library.checkoutMovie(movieOne);

        assertFalse(library.getAvailableMovies().contains(movieOne));
    }

    @Test
    public void shouldThrowExceptionForWrongBookCheckout() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Library library = new Library(books, movies);

        assertThrows(InvalidBookException.class,()->library.checkoutBook(bookThree));
    }

    @Test
    public void shouldReceiveMovieIssued() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo);
        Movie movieOne = mock(Movie.class);
        Movie movieTwo = mock(Movie.class);
        List<Movie> movies = List.of(movieOne, movieTwo);
        Library library = new Library(books, movies);

        library.checkoutMovie(movieOne);
        library.receiveMovie(movieOne);

        assertTrue(library.getAvailableMovies().contains(movieOne));
        assertFalse(library.getIssuedMovies().contains(movieOne));
    }
}
