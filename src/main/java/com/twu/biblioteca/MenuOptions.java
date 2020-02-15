package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class MenuOptions {
    Biblioteca biblioteca;
    List<Option> options;

    public MenuOptions(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        options = new ArrayList<>();
        initOptions();
    }

    private void initOptions() {
        options.add(Option.LIST_BOOKS);
        options.add(Option.LIST_MOVIES);
    }

    private void initUserOptions() {
        options.add(Option.CHECKOUT_BOOK);
        options.add(Option.RETURN_BOOK);
        options.add(Option.CHECKOUT_MOVIE);
        options.add(Option.RETURN_MOVIE);
    }

    private void findPrivilegeOptions() {
        if (biblioteca.getCurrentUser() == null) {
            return;
        }
        initUserOptions();
    }

    public List<Option> getOptions() {
        findPrivilegeOptions();
        options.add(Option.QUIT_APP);
        return options;
    }
}
