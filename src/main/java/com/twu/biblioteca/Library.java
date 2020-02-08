package com.twu.biblioteca;

import java.util.List;

//Job: Represent a Library
public class Library {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

    private final List<Book> books;
    private final List<String> options;

    Library() {
        this.books = initBooks();
        options = initOptions();
    }

    Library(List<Book> books) {
        this.books = books;
        options = initOptions();
    }

    String welcomeMessage() {
        return WELCOME_MESSAGE;
    }

    List<Book> getBooks() {
        return books;
    }

    List<String> getOptions() {
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
        return List.of(optionOne, optionTwo);
    }

    enum Option {
        One {
            @Override
            void executeOption() {
                executable.printListOfBooks();
            }
        },
        Two {
            @Override
            void executeOption() {
                executable.quit();
            }
        },
        Invalid {
            @Override
            void executeOption() {
                executable.showInvalid();
            }
        },
        Back {
            @Override
            void executeOption() {
                executable.goBack();
            }
        };
        Executable executable = new BibliotecaApp();

        abstract void executeOption();
    }
}
