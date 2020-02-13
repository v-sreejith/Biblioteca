package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LibraryNumberTest {

    @Test
    public void shouldReturnNumberInFormat() {
        int[] codeOne = {1, 2, 3};
        int[] codeTwo = {4, 5, 6, 7};
        LibraryNumber libraryNumber = new LibraryNumber(codeOne, codeTwo);
        String expectedNumber = "123-4567";

        assertThat(libraryNumber.number(), is(equalTo(expectedNumber)));
    }
}
