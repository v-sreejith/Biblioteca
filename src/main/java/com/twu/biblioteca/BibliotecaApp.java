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
        System.out.format("%20s\t%30s\t%20s", "Titles", "Authors", "Year of Publication");
        System.out.println();
        for (Book book : books) {
            System.out.format("%20s\t%30s\t%20d", book.getName(), book.getAuthor(), book.getYear());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
