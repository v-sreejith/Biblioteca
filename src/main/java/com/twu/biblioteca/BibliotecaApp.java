package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp implements Executable{
    Library library;
    int option;
    Scanner scanner;
    static boolean exit;

    public void init() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public BibliotecaApp() {
        init();
    }

    public void start() {
        while (!exit) {
            printWelcomeMessage();
            printMenu(library.getOptions());
            getOption();
            executeOption();
        }
    }

    public void printWelcomeMessage() {
        System.out.flush();
        System.out.println(library.welcomeMessage());
    }

    public void printListOfBooks() {
        List<Book> books = library.getBooks();
        System.out.format("%-20s\t%-30s\t%-20s", "Titles", "Authors", "Year of Publication");
        System.out.println();
        for (Book book : books) {
            System.out.format("%-20s\t%-30s\t%-20d", book.getName(), book.getAuthor(), book.getYear());
            System.out.println();
        }
    }

    public void printMenu(List<String> options) {
        int i = 1;
        for (String option : options) {
            System.out.println(i+". "+option);
            i += 1;
        }
    }

    public void quit() {
        System.out.flush();
        exit = true;
    }

    @Override
    public void showInvalid() {
        System.out.println("Please select a valid option");
    }

    public void getOption() {
        option = scanner.nextInt();
    }

    public void executeOption() {
        switch (option) {
            case 1:
                library.option = Library.Option.One;
                library.option.executeOption();
                break;
            case 2:
                library.option = Library.Option.Two;
                library.option.executeOption();
                break;
            default:
                library.option = Library.Option.Invalid;
                library.option.executeOption();
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
