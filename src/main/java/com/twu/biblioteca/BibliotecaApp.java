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
        printWelcomeMessage();
        while (!exit) {
            printMenu(library.getOptions());
        }
    }

    public void printWelcomeMessage() {
        System.out.println(library.welcomeMessage());
    }

    public void printListOfBooks() {
        do {
            List<Book> books = library.getBooks();
            System.out.format("\n%-20s\t%-30s\t%-20s\n", "Titles", "Authors", "Year of Publication");
            System.out.println();
            for (Book book : books) {
                System.out.format("%-20s\t%-30s\t%-20d", book.getName(), book.getAuthor(), book.getYear());
                System.out.println();
            }
        }
        while (!returnToMenu());

    }

    public void printMenu(List<String> options) {
        int i = 1;
        System.out.println("\nSelect an option\n");
        for (String option : options) {
            System.out.println(i+". "+option);
            i += 1;
        }
        executeOption();
    }

    public void quit() {
        exit = true;
    }

    public void goBack() {
        printMenu(library.getOptions());
    }

    private boolean returnToMenu() {
        System.out.println("\nPress 0 to return to menu");
        getOption();
        if (option == 0) {
            library.option = Library.Option.Back;
            library.option.executeOption();
            return true;
        }
        else {
            library.option = Library.Option.Invalid;
            library.option.executeOption();
            return false;
        }
    }

    @Override
    public void showInvalid() {
        System.out.println("\nPlease select a valid option\n");
    }

    public void getOption() {
        option = scanner.nextInt();
    }

    public void executeOption() {
        getOption();
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
