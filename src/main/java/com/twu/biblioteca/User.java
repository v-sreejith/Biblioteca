package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class User {
    private UserCredential userCredential;
    private final String name;
    private final List<Book> issuedBooks;

    public User(UserCredential userCredential, String name) {
        this.userCredential = userCredential;
        this.name = name;
        issuedBooks = new ArrayList<>();
    }

    String sendCredential() {
        return userCredential.credentials();
    }

    void issueBook(Book book) {
        issuedBooks.add(book);
    }

    List<Book> issuedBooks() {
        return issuedBooks;
    }

    String userDetails() {
        return ""+name;
    }
}
