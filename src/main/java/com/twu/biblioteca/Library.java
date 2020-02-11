package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    private final List<Book> books;
    private final List<Book> availableBooks;
    private final List<Book> issuedBooks;
    private final List<Movie> movies;
    private final List<Movie> availableMovies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
        issuedBooks = new ArrayList<>();
        this.movies = movies;
        availableMovies = new ArrayList<>(movies);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void checkoutBook(int option) throws Exception {
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
        return availableMovies;
    }

    public void checkoutMovie(Movie movie) {
        availableMovies.remove(movie);
    }
}
