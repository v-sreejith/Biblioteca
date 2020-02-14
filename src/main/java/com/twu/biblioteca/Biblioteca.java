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
    public static final String MOVIE_CHECKOUT_SUCCESS = "Thank you! Enjoy the movie";
    public static final String MOVIE_CHECKOUT_FAILURE = "Sorry, that movie is not available";
    public static final String MOVIE_RETURN_SUCCESS = "Thank you for returning the movie";
    public static final String MOVIE_RETURN_FAILURE = "That is not a valid movie to return.";
    public static final String LOGIN_SUCCESS = "Login Success!!";
    public static final String LOGIN_FAILURE = "Login Failed";

    private final Inventory<Book> bookInventory;
    private final Inventory<Movie> movieInventory;
    private final List<User> users;
    private User currentUser;
    private String loginMessage;
    private String checkoutMessage;
    private String returnMessage;

    public Biblioteca(Inventory<Book> bookInventory, List<User> users, Inventory<Movie> movieInventory) {
        this.bookInventory = bookInventory;
        this.users = users;
        this.movieInventory = movieInventory;
        returnMessage = BOOK_RETURN_FAILURE;
        checkoutMessage = BOOK_CHECKOUT_FAILURE;
        loginMessage = LOGIN_FAILURE;
    }

    public String getWelcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public List<Book> getLibraryBooks() {
        return bookInventory.getAvailableItems();
    }

    public List<Book> getIssuedBooks() {
        return bookInventory.getIssuedItems();
    }

    public List<Movie> getIssuedMovies() {
        return movieInventory.getIssuedItems();
    }

    public void checkoutLibraryBook(Book book) {
        try {
            bookInventory.checkout(book);
            checkoutMessage = BOOK_CHECKOUT_SUCCESS;
            if (currentUser != null) {
                currentUser.issueBook(book);
            }
        } catch (InvalidItemException e) {
            checkoutMessage = BOOK_CHECKOUT_FAILURE;
        }
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public String getCheckoutMessage() {
        return checkoutMessage;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void returnLibraryBook(Book book) {
        try {
            bookInventory.receive(book);
            returnMessage = BOOK_RETURN_SUCCESS;
        } catch (InvalidItemException e) {
            returnMessage = BOOK_RETURN_FAILURE;
        }
    }

    public List<Movie> getLibraryMovies() {
        return movieInventory.getAvailableItems();
    }

    public void checkoutLibraryMovie(Movie movie) {
        try {
            movieInventory.checkout(movie);
            checkoutMessage = MOVIE_CHECKOUT_SUCCESS;
            if (currentUser != null) {
                currentUser.issueMovie(movie);
            }
        } catch (InvalidItemException e) {
            checkoutMessage = MOVIE_CHECKOUT_FAILURE;
        }
    }

    public void returnLibraryMovie(Movie movie) {
        try {
            movieInventory.receive(movie);
            returnMessage = MOVIE_RETURN_SUCCESS;
            if (currentUser != null) {
                currentUser.returnMovie(movie);
            }
        } catch (InvalidItemException e) {
            returnMessage = MOVIE_RETURN_FAILURE;
        }
    }

    public void login(int libraryNumber, String password) {
        for (User user : users) {
            String[] format = user.sendCredential().split(",");
            if (libraryNumber == Integer.parseInt(format[0]) && password.equals(format[1])) {
                currentUser = user;
                loginMessage = LOGIN_SUCCESS;
                break;
            }
        }
    }

    public String currentUserDetails() {
        return currentUser.userDetails();
    }
}
