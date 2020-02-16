package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private UserCredential userCredential;
    private final String name;
    private final String email;
    private final long phoneNumber;
    private final String privilege;
    private final List<Book> issuedBooks;
    private final List<Movie> issuedMovies;

    public User(UserCredential userCredential, String name, String email,long phoneNumber, String privilege) {
        this.userCredential = userCredential;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.privilege = privilege;
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
        return name+","+email+","+phoneNumber;
    }

    public void returnMovie(Movie movie) {
        issuedMovies.remove(movie);
    }

    public void returnBook(Book book) {
        issuedBooks.remove(book);
    }

    public String privilege() {
        return privilege;
    }
}
