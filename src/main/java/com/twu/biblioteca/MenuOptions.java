package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOptions {
    Biblioteca biblioteca;
    List<Option> options;

    public MenuOptions(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        options = new ArrayList<>();
    }

    private List<Option> generalOptions() {
        return List.of(Option.LIST_BOOKS,
                Option.LIST_MOVIES,
                Option.QUIT_APP);
    }

    private List<Option> userOptions() {
        return List.of(Option.LIST_BOOKS,
                Option.LIST_MOVIES,
                Option.CHECKOUT_BOOK,
                Option.RETURN_BOOK,
                Option.CHECKOUT_MOVIE,
                Option.RETURN_MOVIE,
                Option.USER_DETAILS,
                Option.QUIT_APP);
    }

    private void findPrivilegeOptions() {
        if (biblioteca.getCurrentUser() == null) {
            options = generalOptions();
            return;
        }
        if (biblioteca.getCurrentUser().privilege().equals("User")) {
            options = userOptions();
        }
    }

    public List<Option> getOptions() {
        findPrivilegeOptions();
        return options;
    }
}
