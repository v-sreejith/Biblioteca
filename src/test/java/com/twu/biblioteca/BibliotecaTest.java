package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        assertThat(biblioteca.getWelcomeMessage(), is(equalTo(("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"))));
    }

    @Test
    public void shouldReturnListOfBooksInLibrary() {
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.getLibraryBooks();

        verify(inventory, times(1)).getAvailableItems();
    }

    @Test
    public void shouldReturnListOfIssuedBooksFromLibrary() {
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.getIssuedBooks();

        verify(inventory, times(1)).getIssuedItems();
    }

    @Test
    public void shouldCheckoutABookFromLibrary() throws Exception {
        Book book = mock(Book.class);
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.checkoutLibraryBook(book);

        verify(inventory, times(1)).checkout(book);
    }

    @Test
    public void shouldReturnABookBackToLibrary() throws Exception {
        Book book = mock(Book.class);
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.returnLibraryBook(book);

        verify(inventory, times(1)).receive(book);
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckout() {
        Book book = mock(Book.class);
        Inventory<Book> inventory = new Inventory<>(List.of(book));
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.checkoutLibraryBook(book);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Thank you! Enjoy the book")));
    }

    @Test
    public void shouldReturnFailureForWrongCheckout() {
        Book book = mock(Book.class);
        Book anotherBook = mock(Book.class);
        Inventory<Book> inventory = new Inventory<>(List.of(book));
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.checkoutLibraryBook(anotherBook);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Sorry, that book is not available")));
    }

    @Test
    public void shouldReturnSuccessMessageOnReturn() {
        Book book = mock(Book.class);
        Inventory<Book> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(inventory, null, null);

        biblioteca.returnLibraryBook(book);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("Thank you for returning the book")));
    }

    @Test
    public void shouldReturnFailureForWrongReturn() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Inventory<Book> bookInventory = new Inventory<>(List.of(bookOne, bookTwo));
        Inventory<Movie> movieInventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(bookInventory, null, movieInventory);

        biblioteca.returnLibraryBook(bookTwo);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("That is not a valid book to return.")));
    }

    @Test
    public void shouldReturnAvailableMoviesFromLibrary() {
        Inventory<Movie> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(null, null, inventory);

        biblioteca.getLibraryMovies();

        verify(inventory, times(1)).getAvailableItems();
    }

    @Test
    public void shouldCheckoutAMovieFromLibrary() throws InvalidItemException {
        Movie movie = mock(Movie.class);
        Inventory<Movie> inventory = mock(Inventory.class);
        Biblioteca biblioteca = new Biblioteca(null, null, inventory);

        biblioteca.checkoutLibraryMovie(movie);

        verify(inventory, times(1)).checkout(movie);
    }

    @Test
    public void shouldGetCurrentUserDetails() {
        Inventory<Book> inventory = mock(Inventory.class);
        UserCredential credential = new UserCredential(1234, "abcd");
        User user = new User(credential, "");
        Biblioteca biblioteca = new Biblioteca(inventory, List.of(user), null);

        biblioteca.login(1234, "abcd");
        String currentUserDetails = biblioteca.currentUserDetails();

        assertThat(currentUserDetails, is(equalTo(user.userDetails())));
    }

    @Test
    public void shouldIssueABookToCurrentUser() {
        Book book = mock(Book.class);
        Inventory<Book> inventory = new Inventory<>(List.of(book));
        UserCredential credential = new UserCredential(1234, "abcd");
        User user = new User(credential, "");
        Biblioteca biblioteca = new Biblioteca(inventory, List.of(user), null);

        biblioteca.login(1234, "abcd");
        biblioteca.checkoutLibraryBook(book);

        assertThat(user.issuedBooks().get(0), is(equalTo(book)));
    }

    @Test
    public void shouldIssueAMovieToCurrentUser() {
        Movie movie = mock(Movie.class);
        Inventory<Movie> inventory = new Inventory<>(List.of(movie));
        UserCredential credential = new UserCredential(1234, "abcd");
        User user = new User(credential, "");
        Biblioteca biblioteca = new Biblioteca(null, List.of(user), inventory);

        biblioteca.login(1234, "abcd");
        biblioteca.checkoutLibraryMovie(movie);

        assertThat(user.issuedMovies().get(0), is(equalTo(movie)));
    }
}
