package org.learning.tech;

import org.junit.jupiter.api.Test;
import org.learning.tech.exception.TicksReadFailedException;
import org.learning.tech.model.Tick;
import org.learning.tech.model.Ticks;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicksReaderUnitTest {

    @Test
    void shouldReadTicks() {
        String path = "src/test/resources/ticks-file";
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        Ticks ticks = ticksReader.read();

        assertEquals(3, ticks.size());
        assertEquals(List.of("signature1", "signature2", "signature3"),
                ticks.stream().map(Tick::signature).collect(Collectors.toList())
        );
    }

    @Test
    void shouldThrowAnExceptionGivenFileDoesNotExist() {
        String path = "src/test/resources/ticks-file-non-existing";
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        assertThrows(TicksReadFailedException.class, ticksReader::read);
    }
}