package com.twu.biblioteca;

import java.util.List;

//Job: Represent a Library
public class Library {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private final List<Book> books;

    Library() {
        this.books = initBooks();
    }

    Library(List<Book> books) {
        this.books = books;
    }

    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    List<Book> getBooks() {
        return books;
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire");
        Book bookTwo = new Book("Kite Runner");
        Book bookThree = new Book("Hunger Games");
        return List.of(bookOne, bookTwo, bookThree);
    }
}
