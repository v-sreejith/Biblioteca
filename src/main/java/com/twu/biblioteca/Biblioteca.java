package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidItemException;

import java.util.List;

//Job: Manage library
public class Biblioteca {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String BOOK_CHECKOUT_SUCCESS = "Thank you! Enjoy the book";
    public static final String BOOK_CHECKOUT_FAILURE = "Sorry, that book is not available";
    public static final String BOOK_RETURN_SUCCESS = "Thank you for returning the book";
    public static final String BOOK_RETURN_FAILURE = "That is not a valid book to return.";

    Library<Book> bookLibrary;
    Library<Movie> movieLibrary;
    private UserCredential userCredential;
    private String checkoutMessage;
    private String returnMessage;

    public Biblioteca(Library<Book> bookLibrary, UserCredential userCredential, Library<Movie> movieLibrary) {
        this.bookLibrary = bookLibrary;
        this.userCredential = userCredential;
        this.movieLibrary = movieLibrary;
        returnMessage = BOOK_RETURN_FAILURE;
        checkoutMessage = BOOK_CHECKOUT_FAILURE;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getLibraryBooks() {
        return bookLibrary.getAvailableItems();
    }

    public List<Book> getIssuedBooks() {
        return bookLibrary.getIssuedItems();
    }

    public void checkoutLibraryBook(Book book) {
        try {
            bookLibrary.checkoutItems(book);
            checkoutMessage = BOOK_CHECKOUT_SUCCESS;
        } catch (InvalidItemException e) {
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
            bookLibrary.receiveItem(book);
            returnMessage = BOOK_RETURN_SUCCESS;
        } catch (InvalidItemException e) {
            returnMessage = BOOK_RETURN_FAILURE;
        }
    }

    public List<Movie> getLibraryMovies() {
        return movieLibrary.getAvailableItems();
    }

    public void checkoutLibraryMovie(Movie movie) {
        try {
            movieLibrary.checkoutItems(movie);
            checkoutMessage = BOOK_CHECKOUT_SUCCESS;
        } catch (InvalidItemException e) {
            checkoutMessage = BOOK_CHECKOUT_FAILURE;
        }
    }

    public boolean validateUser(int libraryNumber, String password) {
        String[] format = userCredential.credentials().split(",");
        return libraryNumber == Integer.parseInt(format[0])
                && password.equals(format[1]);
    }
}
