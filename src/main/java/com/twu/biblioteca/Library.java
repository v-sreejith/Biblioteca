package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    private final List<Book> books;
    private final List<Book> availableBooks;
    private final List<Book> issuedBooks;
    private final List<Movie> movies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
        issuedBooks = new ArrayList<>();
        this.movies = movies;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void checkout(int option) throws Exception {
        try {
            Book book = getAvailableBooks().get(option - 1);
            availableBooks.remove(book);
            issuedBooks.add(book);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void receiveBook(Book book) throws Exception {
        if (books.contains(book) && !availableBooks.contains(book)) {
            issuedBooks.remove(book);
            availableBooks.add(book);
        } else throw new Exception();
    }

    public List<Movie> getAvailableMovies() {
        return movies;
    }
}
