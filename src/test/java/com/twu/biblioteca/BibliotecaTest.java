package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class BibliotecaTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        assertThat(biblioteca.getWelcomeMessage(), is(equalTo(("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!"))));
    }

    @Test
    public void shouldReturnListOfBooksInLibrary() {
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.getLibraryBooks();

        verify(library, times(1)).getAvailableBooks();
    }

    @Test
    public void shouldReturnListOfIssuedBooksFromLibrary() {
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.getIssuedBooks();

        verify(library, times(1)).getIssuedBooks();
    }

    @Test
    public void shouldCheckoutABookFromLibrary() throws Exception {
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.checkoutLibraryBook(1);

        verify(library, times(1)).checkout(1);
    }

    @Test
    public void shouldReturnABookBackToLibrary() throws Exception {
        Book book = mock(Book.class);
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.returnLibraryBook(book);

        verify(library, times(1)).receiveBook(book);
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckout() {
        Book book = mock(Book.class);
        Library library = new Library(List.of(book));
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.checkoutLibraryBook(1);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Thank you! Enjoy the book")));
    }

    @Test
    public void shouldReturnFailureForWrongCheckout() {
        Book book = mock(Book.class);
        Library library = new Library(List.of(book));
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.checkoutLibraryBook(10);

        assertThat(biblioteca.getCheckoutMessage(), is(equalTo("Sorry, that book is not available")));
    }

    @Test
    public void shouldReturnSuccessMessageOnReturn() {
        Book book = mock(Book.class);
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.returnLibraryBook(book);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("Thank you for returning the book")));
    }

    @Test
    public void shouldReturnFailureForWrongReturn() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Library library = new Library(List.of(bookOne));
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.returnLibraryBook(bookTwo);

        assertThat(biblioteca.getReturnMessage(), is(equalTo("That is not a valid book to return.")));
    }
}
