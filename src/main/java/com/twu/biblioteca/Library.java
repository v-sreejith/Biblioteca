package com.twu.biblioteca;

import java.util.List;

//Job: Represent a Library
public class Library {
    private final List<Book> books;

    Library(List<Book> books) {
        this.books = books;
    }

    List<Book> getBooks() {
        return books;
    }
}
