package com.twu.biblioteca;

import java.util.List;

//Job: Manage library
public class Biblioteca {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    Library library;

    public Biblioteca(Library library) {
        this.library = library;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getLibraryBooks() {
        return library.getAvailableBooks();
    }

    public void checkoutLibraryBook(int option) {
        library.checkout(option);
    }
}
