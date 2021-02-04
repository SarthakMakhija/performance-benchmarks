package org.learning.tech.exception;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicksReadFailedExceptionUnitTest {

    @Test
    void shouldReturnExceptionMessage() {
        TicksReadFailedException exception = new TicksReadFailedException("ticks-file", new IOException("test-IOException"));
        assertEquals("Tick read failed from ticks-file", exception.getMessage());
    }
}