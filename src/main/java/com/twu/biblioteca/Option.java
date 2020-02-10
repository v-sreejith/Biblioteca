package com.twu.biblioteca;

public enum Option {
    One("List All Books") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.printListOfBooks();
        }
    },
    Two("Quit App") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.quit();
        }
    },
    Three("Checkout a Book") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.bookCheckout();
        }
    },
    Four("Return a Book") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.returnBook();
        }
    };
    public String value;

    Option(String value) {
        this.value = value;
    }

    public abstract void executeOption(UserInterface executable);
}
