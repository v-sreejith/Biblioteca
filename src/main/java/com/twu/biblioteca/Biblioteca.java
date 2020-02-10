package com.twu.biblioteca;

import java.util.List;

//Job: Manage library
public class Biblioteca {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String SUCCESS_CHECKOUT = "Thank you! Enjoy the book";
    public static final String FAIL_CHECKOUT = "Sorry, that book is not available";

    Library library;
    private String checkoutMessage;

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
        try {
            library.checkout(option);
            checkoutMessage = SUCCESS_CHECKOUT;
        } catch (Exception e) {
            checkoutMessage = FAIL_CHECKOUT;
        }
    }

    public String getCheckoutMessage() {
        return checkoutMessage;
    }

    public void returnLibraryBook(Book book) {
        library.receiveBook(book);
    }
}
