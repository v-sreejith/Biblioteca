package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    public static final String SUCCESS_RETURN = "Thank you for returning the book";
    public static final String FAIL_RETURN = "That is not a valid book to return.";

    private final List<Book> books;
    private final List<Book> availableBooks;
    private String returnMessage;

    public Library() {
        this.books = initBooks();
        availableBooks = new ArrayList<>(books);
    }

    public Library(List<Book> books) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
    }

    public String returnMessage() {
        return returnMessage;
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

    public void checkout(int option) throws Exception{
        try {
            Book book = getAvailableBooks().get(option - 1);
            availableBooks.remove(book);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void receiveBook(Book book) {
        if (books.contains(book) && !availableBooks.contains(book)) {
            availableBooks.add(book);
            returnMessage = SUCCESS_RETURN;
        } else returnMessage = FAIL_RETURN;
    }
}
