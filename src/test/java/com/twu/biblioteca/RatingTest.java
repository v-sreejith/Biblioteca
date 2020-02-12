package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidRatingException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class RatingTest {

    @Test
    public void shouldEquateTwoSimilarRatings() throws InvalidRatingException {
        Rating ratingOne = new Rating(5);
        Rating ratingTwo = new Rating(5);

        assertThat(ratingTwo, is(equalTo(ratingOne)));
    }

    @Test
    public void shouldReturnInvalidRatingExceptionForInvalidRating() {

        assertThrows(InvalidRatingException.class, () -> new Rating(100));
    }

    @Test
    public void shouldReturnRatingAsUnratedIfRatingIs0() throws InvalidRatingException {
        Rating rating = new Rating(0);

        assertThat(rating.rating(), is(equalTo("Unrated")));
    }
}
