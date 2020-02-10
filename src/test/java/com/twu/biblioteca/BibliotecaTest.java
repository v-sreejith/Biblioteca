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
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);

        assertThat(biblioteca.getLibraryBooks(), is(equalTo(books)));
    }

    @Test
    public void shouldCheckoutABookFromLibrary() {
        Library library = mock(Library.class);
        Biblioteca biblioteca = new Biblioteca(library);

        biblioteca.checkoutLibraryBook(1);

        verify(library, times(1)).checkout(1);
    }
}
