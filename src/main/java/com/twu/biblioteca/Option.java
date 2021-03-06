package com.twu.biblioteca;

public enum Option {
    LIST_BOOKS("List All Books") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.printListOfBooks();
        }
    },
    LIST_MOVIES("List All Movies") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.printListOfMovies();
        }
    },
    CHECKOUT_BOOK("Checkout a Book") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.bookCheckout();
        }
    },
    RETURN_BOOK("Return a Book") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.returnBook();
        }
    },
    QUIT_APP("Quit App") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.quit();
        }
    },
    CHECKOUT_MOVIE("Checkout a Movie") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.movieCheckout();
        }
    },
    RETURN_MOVIE("Return a Movie") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.returnMovie();
        }
    },
    USER_DETAILS("Get User Details") {
        @Override
        public void executeOption(UserInterface executable) {
            executable.userDetails();
        }
    };
    public String value;

    Option(String value) {
        this.value = value;
    }

    public abstract void executeOption(UserInterface executable);
}
