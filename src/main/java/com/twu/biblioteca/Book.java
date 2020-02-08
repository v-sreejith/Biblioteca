package com.twu.biblioteca;

import java.util.Objects;

//Job: Represent a book
public class Book {
    private final String name;
    private final String author;
    private final int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }
}
