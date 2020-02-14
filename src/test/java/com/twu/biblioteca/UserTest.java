package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class UserTest {

    @Test
    public void shouldReturnUserCredential() {
        UserCredential credential = mock(UserCredential.class);
        User user = new User(credential);

        user.sendCredential();

        verify(credential, times(1)).credentials();
    }
}
