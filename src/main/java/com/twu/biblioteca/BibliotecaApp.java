package com.twu.biblioteca;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {
    Library library;
    int option;
    Scanner scanner;
    boolean exit;

    public void init() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void start() {
        init();
        while (!exit) {
            printWelcomeMessage();
            printMenu();
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

    public void printMenu() {
        System.out.println("Enter an option");
        System.out.println("1. View All Books");
        System.out.println("2. Quit App");
    }

    public void quit() {
        System.out.flush();
        exit = true;
    }

    public void getOption() {
        option = scanner.nextInt();
    }

    public void executeOption() {
        switch (option) {
            case 1:
                printListOfBooks();
                break;
            case 2:
                quit();
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
