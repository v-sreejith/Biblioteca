package com.twu.biblioteca;

public enum Option {
    One {
        @Override
        public void executeOption(UserInterface executable) {
            executable.printListOfBooks();
        }
    },
    Two {
        @Override
        public void executeOption(UserInterface executable) {
            executable.quit();
        }
    },
    Three {
        @Override
        public void executeOption(UserInterface executable) {
            executable.bookCheckout();
        }
    },
    Four {
        @Override
        public void executeOption(UserInterface executable) {
            executable.returnBook();
        }
    },
    Invalid {
        @Override
        public void executeOption(UserInterface executable) {
            executable.showInvalid();
        }
    },
    Back {
        @Override
        public void executeOption(UserInterface executable) {
            executable.goBack();
        }
    };

    public abstract void executeOption(UserInterface executable);
}
