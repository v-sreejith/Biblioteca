package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

class UserTest {

    @Test
    public void shouldReturnUserCredential() {
        UserCredential credential = mock(UserCredential.class);
        User user = new User(credential, "abc", "User");

        user.sendCredential();

        verify(credential, times(1)).credentials();
    }

    @Test
    public void shouldIssueABook() {
        UserCredential credential = mock(UserCredential.class);
        User user = new User(credential, "abc", "User");
        Book book = mock(Book.class);

        user.issueBook(book);

        assertThat(user.issuedBooks().get(0), is(equalTo(book)));
    }

    @Test
    public void shouldIssueAMovie() {
        UserCredential credential = mock(UserCredential.class);
        User user = new User(credential, "abc", "User");
        Movie movie = mock(Movie.class);

        user.issueMovie(movie);

        assertThat(user.issuedMovies().get(0), is(equalTo(movie)));
    }

    @Test
    public void shouldReturnAMovie() {
        UserCredential credential = mock(UserCredential.class);
        User user = new User(credential, "abc", "User");
        Movie movie = mock(Movie.class);

        user.issueMovie(movie);
        user.returnMovie(movie);

        assertThat(user.issuedMovies(), is(equalTo(new ArrayList<>())));
    }
}
