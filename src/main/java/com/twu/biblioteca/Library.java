package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

//Job: Represent a Library
public class Library {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private final List<Book> books;

    Library() {
        this.books = initBooks();
    }

    Library(List<Book> books) {
        this.books = books;
    }

    String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    List<Book> getBooks() {
        return books;
    }

    private List<Book> initBooks() {
        Book bookOne = new Book("Wings of Fire", "A P J Abdul Kalam", 2001);
        Book bookTwo = new Book("Kite Runner", "Khaled Hosseini", 2003);
        Book bookThree = new Book("Hunger Games", "Suzzane", 2009);
        return List.of(bookOne, bookTwo, bookThree);
    }
}
