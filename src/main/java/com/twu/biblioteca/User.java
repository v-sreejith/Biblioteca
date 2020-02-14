package com.twu.biblioteca;

public class User {
    private UserCredential userCredential;

    public User(UserCredential userCredential) {
        this.userCredential = userCredential;
    }

    String sendCredential() {
        return userCredential.credentials();
    }

    String userDetails() {
        return "";
    }
}
