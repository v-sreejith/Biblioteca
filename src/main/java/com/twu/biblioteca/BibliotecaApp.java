package com.twu.biblioteca;

import java.util.List;

public class BibliotecaApp {
    Library library;

    public void init() {
        library = new Library();
    }

    public void start() {
        init();
        printWelcomeMessage();
        printListOfBooks();
    }

    public void printWelcomeMessage() {
        System.out.println(library.welcomeMessage());
    }

    public void printListOfBooks() {
        List<Book> books = library.getBooks();
        for (Book book : books) {
            System.out.println(book.getName());
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
