package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LibraryTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book bookOne = mock(Book.class);
        Book bookTwo = mock(Book.class);
        Book bookThree = mock(Book.class);
        List<Book> books = List.of(bookOne, bookTwo, bookThree);
        Library library = new Library(books);

        List<Book> actualBooks = library.getBooks();

        assertEquals(books, actualBooks);
    }
}