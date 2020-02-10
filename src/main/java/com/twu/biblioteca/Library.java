package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    private final List<Book> books;
    private final List<Book> availableBooks;

    public Library() {
        this.books = initBooks();
        availableBooks = new ArrayList<>(books);
    }

    public Library(List<Book> books) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        return List.of(bookOne, bookTwo, bookThree);
    }

    public void checkout(int option) throws Exception {
        try {
            Book book = getAvailableBooks().get(option - 1);
            availableBooks.remove(book);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void receiveBook(Book book) throws Exception {
        if (books.contains(book) && !availableBooks.contains(book)) {
            availableBooks.add(book);
        } else throw new Exception();
    }
}
