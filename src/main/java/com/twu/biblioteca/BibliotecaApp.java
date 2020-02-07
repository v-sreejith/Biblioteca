package com.twu.biblioteca;

public class BibliotecaApp {

    public void start() {
        Biblioteca biblioteca = new Biblioteca();
        System.out.println(biblioteca.welcomeMessage());
    }

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.start();
    }
}
