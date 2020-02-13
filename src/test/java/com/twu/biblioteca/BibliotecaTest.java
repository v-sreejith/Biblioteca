package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        assertThat(biblioteca.getWelcomeMessage(), is(equalTo(("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"))));
    }

    @Test
    public void shouldReturnListOfBooksInLibrary() {
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.getLibraryBooks();

        verify(library, times(1)).getAvailableItems();
    }

    @Test
    public void shouldReturnListOfIssuedBooksFromLibrary() {
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.getIssuedBooks();

        verify(library, times(1)).getIssuedItems();
    }

    @Test
    public void shouldCheckoutABookFromLibrary() throws Exception {
        Book book = mock(Book.class);
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.checkoutLibraryBook(book);

        verify(library, times(1)).checkoutItems(book);
    }

    @Test
    public void shouldReturnABookBackToLibrary() throws Exception {
        Book book = mock(Book.class);
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.returnLibraryBook(book);

        verify(library, times(1)).receiveItem(book);
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckout() {
        Book book = mock(Book.class);
        Library<Book> library = new Library<>(List.of(book));
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.checkoutLibraryBook(book);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Thank you! Enjoy the book")));
    }

    @Test
    public void shouldReturnFailureForWrongCheckout() {
        Book book = mock(Book.class);
        Book anotherBook = mock(Book.class);
        Library<Book> library = new Library<>(List.of(book));
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.checkoutLibraryBook(anotherBook);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Sorry, that book is not available")));
    }

    @Test
    public void shouldReturnSuccessMessageOnReturn() {
        Book book = mock(Book.class);
        Library<Book> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library, null, null);

        biblioteca.returnLibraryBook(book);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("Thank you for returning the book")));
    }

    @Test
    public void shouldReturnFailureForWrongReturn() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Library<Book> bookLibrary = new Library<>(List.of(bookOne, bookTwo));
        Library<Movie> movieLibrary = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(bookLibrary, null, movieLibrary);

        biblioteca.returnLibraryBook(bookTwo);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("That is not a valid book to return.")));
    }

    @Test
    public void shouldReturnAvailableMoviesFromLibrary() {
        Library<Movie> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(null, null, library);

        biblioteca.getLibraryMovies();

        verify(library, times(1)).getAvailableItems();
    }

    @Test
    public void shouldCheckoutAMovieFromLibrary() throws InvalidItemException {
        Movie movie = mock(Movie.class);
        Library<Movie> library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(null, null, library);

        biblioteca.checkoutLibraryMovie(movie);

        verify(library, times(1)).checkoutItems(movie);
    }

    @Test
    public void shouldValidateUserCredentials() {
        Library library = mock(Library.class);
        int libraryNumber = 12345;
        String password = "Hello";
        UserCredential credential = new UserCredential(libraryNumber, password);
        Biblioteca biblioteca = new Biblioteca(library, credential, null);

        assertTrue(biblioteca.validateUser(libraryNumber, password));
    }
}
