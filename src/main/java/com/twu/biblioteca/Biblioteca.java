package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidBookException;

import java.util.List;

//Job: Manage library
public class Biblioteca {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String BOOK_CHECKOUT_SUCCESS = "Thank you! Enjoy the book";
    public static final String BOOK_CHECKOUT_FAILURE = "Sorry, that book is not available";
    public static final String BOOK_RETURN_SUCCESS = "Thank you for returning the book";
    public static final String BOOK_RETURN_FAILURE = "That is not a valid book to return.";

    Library library;
    private String checkoutMessage;
    private String returnMessage;

    public Biblioteca(Library library) {
        this.library = library;
        returnMessage = BOOK_RETURN_FAILURE;
        checkoutMessage = BOOK_CHECKOUT_FAILURE;
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

    public void checkoutLibraryBook(Book book) {
        try {
            library.checkoutBook(book);
            checkoutMessage = BOOK_CHECKOUT_SUCCESS;
        } catch (InvalidBookException e) {
            checkoutMessage = BOOK_CHECKOUT_FAILURE;
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
            returnMessage = BOOK_RETURN_SUCCESS;
        } catch (InvalidBookException e) {
            returnMessage = BOOK_RETURN_FAILURE;
        }
    }

    public List<Movie> getLibraryMovies() {
        return library.getAvailableMovies();
    }

    public void checkoutLibraryMovie(Movie movie) {
        library.checkoutMovie(movie);
    }
}
