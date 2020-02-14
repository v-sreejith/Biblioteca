package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private UserCredential userCredential;
    private final String name;
    private final List<Book> issuedBooks;
    private final List<Movie> issuedMovies;

    public User(UserCredential userCredential, String name) {
        this.userCredential = userCredential;
        this.name = name;
        issuedBooks = new ArrayList<>();
        issuedMovies = new ArrayList<>();
    }

    String sendCredential() {
        return userCredential.credentials();
    }

    void issueBook(Book book) {
        issuedBooks.add(book);
    }

    void issueMovie(Movie movie) {
        issuedMovies.add(movie);
    }

    List<Book> issuedBooks() {
        return issuedBooks;
    }

    List<Movie> issuedMovies() {
        return issuedMovies;
    }

    String userDetails() {
        return ""+name;
    }
}
