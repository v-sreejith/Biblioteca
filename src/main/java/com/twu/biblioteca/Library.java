package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidBookException;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    private final List<Book> books;
    private final List<Book> availableBooks;
    private final List<Book> issuedBooks;
    private final List<Movie> movies;
    private final List<Movie> availableMovies;
    private final List<Movie> issuedMovies;

    public Library(List<Book> books, List<Movie> movies) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
        this.issuedMovies = new ArrayList<>();
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

    public void checkoutBook(Book book) throws InvalidBookException {
        if (availableBooks.contains(book)) {
            availableBooks.remove(book);
            issuedBooks.add(book);
        } else throw new InvalidBookException();
    }

    public void receiveBook(Book book) throws InvalidBookException {
        if (books.contains(book) && !availableBooks.contains(book)) {
            issuedBooks.remove(book);
            availableBooks.add(book);
        } else throw new InvalidBookException();
    }

    public List<Movie> getAvailableMovies() {
        return availableMovies;
    }

    public void checkoutMovie(Movie movie) {
        if (availableMovies.contains(movie)) {
            availableMovies.remove(movie);
            issuedMovies.add(movie);
        }
    }
}
