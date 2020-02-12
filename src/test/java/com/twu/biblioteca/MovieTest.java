package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

class MovieTest {

    @Test
    public void shouldEquateTwoSimilarMovies() {
        Rating rating = mock(Rating.class);
        Movie movieOne = new Movie("ABC", 1999, "tom", rating);
        Movie movieTwo = new Movie("ABC", 1999, "tom", rating);

        assertThat(movieOne, is(equalTo(movieTwo)));
    }
}
