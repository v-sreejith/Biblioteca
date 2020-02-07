package com.twu.biblioteca;

public class BibliotecaApp {

    public void start() {
        Library library = new Library();
        System.out.println(library.welcomeMessage());
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
