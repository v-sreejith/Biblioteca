package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class UserCredentialTest {

    @Test
    public void shouldEquateTwoSimilarCredentials() {
        UserCredential userCredentialOne = new UserCredential(123, "hii");
        UserCredential userCredentialTwo = new UserCredential(123, "hii");

        assertThat(userCredentialTwo, is(equalTo(userCredentialOne)));
    }
}