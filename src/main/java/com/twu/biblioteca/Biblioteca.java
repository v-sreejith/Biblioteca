package com.twu.biblioteca;

import java.util.List;

//Job: Manage library
public class Biblioteca {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String SUCCESS_CHECKOUT = "Thank you! Enjoy the book";
    public static final String FAIL_CHECKOUT = "Sorry, that book is not available";
    public static final String SUCCESS_RETURN = "Thank you for returning the book";
    public static final String FAIL_RETURN = "That is not a valid book to return.";

    Library library;
    private String checkoutMessage;
    private String returnMessage;

    public Biblioteca(Library library) {
        this.library = library;
        returnMessage = FAIL_RETURN;
        checkoutMessage = FAIL_CHECKOUT;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getLibraryBooks() {
        return library.getAvailableBooks();
    }

    public List<Book> getIssuedBooks() {
        return library.getIssuedBooks();
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

    public String getReturnMessage() {
        return returnMessage;
    }

    public void returnLibraryBook(Book book) {
        try {
            library.receiveBook(book);
            returnMessage = SUCCESS_RETURN;
        } catch (Exception e) {
            returnMessage = FAIL_RETURN;
        }
    }

    public List<Movie> getLibraryMovies() {
        return library.getAvailableMovies();
    }
}
