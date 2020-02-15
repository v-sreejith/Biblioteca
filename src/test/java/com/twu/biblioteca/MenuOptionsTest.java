package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MenuOptionsTest {

    @Test
    public void shouldReturnGeneralOptionsForUser() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        MenuOptions menuOptions = new MenuOptions(biblioteca);

        when(biblioteca.getCurrentUser()).thenReturn(null);

        List<Option> options = new ArrayList<>();
        options.add(Option.LIST_BOOKS);
        options.add(Option.LIST_MOVIES);
        options.add(Option.QUIT_APP);
        assertThat(menuOptions.getOptions(), is(equalTo(options)));
    }

    @Test
    public void shouldReturnUserOptionsForUser() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        MenuOptions menuOptions = new MenuOptions(biblioteca);
        User user = mock(User.class);

        when(biblioteca.getCurrentUser()).thenReturn(user);
        when(biblioteca.getCurrentUser().privilege()).thenReturn("User");

        List<Option> options = new ArrayList<>();
        options.add(Option.LIST_BOOKS);
        options.add(Option.LIST_MOVIES);
        options.add(Option.CHECKOUT_BOOK);
        options.add(Option.RETURN_BOOK);
        options.add(Option.CHECKOUT_MOVIE);
        options.add(Option.RETURN_MOVIE);
        options.add(Option.QUIT_APP);
        assertThat(menuOptions.getOptions(), is(equalTo(options)));
    }
}
