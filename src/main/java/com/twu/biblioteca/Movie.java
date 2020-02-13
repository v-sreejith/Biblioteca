package com.twu.biblioteca;

import java.util.Objects;

public class Movie extends LibraryItem{
    public final String name;
    public final int year;
    public final String director;
    public final Rating rating;

    public Movie(String name, int year, String director, Rating rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String formattedDetails() {
        return name+","+year+","+director+","+rating.rating();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return year == movie.year &&
                rating == movie.rating &&
                Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, director, rating);
    }
}
