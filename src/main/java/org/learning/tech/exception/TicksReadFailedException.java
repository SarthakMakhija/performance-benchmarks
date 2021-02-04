package org.learning.tech.exception;

import java.io.IOException;

public class TicksReadFailedException extends RuntimeException {

    public TicksReadFailedException(String fileName, IOException e) {
        super(String.format("Tick read failed from %s", fileName), e);
    }
}
