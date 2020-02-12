package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidRatingException;

import java.util.Objects;

public class Rating {
    private final int rating;

    Rating(int rating) throws InvalidRatingException {
        if (rating >= 0 && rating <= 10) {
            this.rating = rating;
        } else {
            throw new InvalidRatingException();
        }
    }

    String rating() {
        if (rating > 0) {
            return String.valueOf(rating);
        }
        return "Unrated";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating1 = (Rating) o;
        return rating == rating1.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating);
    }
}
