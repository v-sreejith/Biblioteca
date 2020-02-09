package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public static final String SUCCESS_CHECKOUT = "Thank you! Enjoy the book";
    public static final String FAIL_CHECKOUT = "Sorry, that book is not available";
    public static final String SUCCESS_RETURN = "Thank you for returning the book";

    private final List<Book> books;
    private final List<Book> availableBooks;
    private final List<String> options;
    private String checkoutMessage;
    private String returnMessage;

    public Library() {
        this.books = initBooks();
        availableBooks = new ArrayList<>(books);
        options = initOptions();
    }

    public Library(List<Book> books) {
        this.books = books;
        availableBooks = new ArrayList<>(books);
        options = initOptions();
    }

    public String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    public String checkoutMessage() {
        return checkoutMessage;
    }

    public String returnMessage() {
        return returnMessage;
    }


    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public List<String> getOptions() {
        return options;
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        return List.of(bookOne, bookTwo, bookThree);
    }

    private List<String> initOptions() {
        String optionOne = "List All Books";
        String optionTwo = "Quit App";
        String optionThree = "Checkout a Book";
        String optionFour = "Return a Book";
        return List.of(optionOne, optionTwo, optionThree, optionFour);
    }

    public Book checkout(int option) {
        try {
            Book book = getAvailableBooks().get(option - 1);
            availableBooks.remove(book);
            checkoutMessage = SUCCESS_CHECKOUT;
            return book;
        } catch (Exception e) {
            checkoutMessage = FAIL_CHECKOUT;
        }
        return null;
    }

    public void receiveBook(Book book) {
        if (books.contains(book) && !availableBooks.contains(book)) {
            availableBooks.add(book);
            returnMessage = SUCCESS_RETURN;
        }
    }
}
