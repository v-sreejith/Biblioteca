package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MovieTest {

    @Test
    public void shouldEquateTwoSimilarMovies() {
        Movie movieOne = new Movie("ABC", 1999,"tom" , 1);
        Movie movieTwo = new Movie("ABC", 1999,"tom" , 1);

        assertThat(movieOne, is(equalTo(movieTwo)));
    }
}
