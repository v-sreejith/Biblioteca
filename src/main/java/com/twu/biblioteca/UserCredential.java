package com.twu.biblioteca;

import java.util.Objects;

public class UserCredential {
    LibraryNumber libraryNumber;
    String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredential that = (UserCredential) o;
        return libraryNumber == that.libraryNumber &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryNumber, password);
    }
}
