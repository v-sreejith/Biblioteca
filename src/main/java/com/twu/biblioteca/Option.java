package com.twu.biblioteca;

public enum Option {
    One {
        @Override
        public void executeOption(Executable executable) {
            executable.printListOfBooks();
        }
    },
    Two {
        @Override
        public void executeOption(Executable executable) {
            executable.quit();
        }
    },
    Invalid {
        @Override
        public void executeOption(Executable executable) {
            executable.showInvalid();
        }
    },
    Back {
        @Override
        public void executeOption(Executable executable) {
            executable.goBack();
        }
    };

    public abstract void executeOption(Executable executable);
}
