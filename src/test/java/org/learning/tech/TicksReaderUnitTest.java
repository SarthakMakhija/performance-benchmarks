package org.learning.tech;

import org.junit.jupiter.api.Test;
import org.learning.tech.exception.TicksReadFailedException;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicksReaderUnitTest {

    @Test
    void shouldThrowAnExceptionGivenFileDoesNotExist() {
        String path = "src/test/resources/ticks-file-non-existing";
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        assertThrows(TicksReadFailedException.class, ticksReader::readAll);
    }

    @Test
    void shouldThrowAnExceptionWithAMessageContainingFileNameGivenFileDoesNotExist() {
        String fileName = "ticks-file-non-existing";
        String path = "src/test/resources/" + fileName;
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        TicksReadFailedException thrown = assertThrows(TicksReadFailedException.class, ticksReader::readAll);
        assertTrue(thrown.getMessage().contains(fileName));
    }
}