package org.learning.tech;

import org.junit.jupiter.api.Test;
import org.learning.tech.model.Tick;
import org.learning.tech.model.Ticks;
import org.learning.tech.validator.OptimizedAlphanumericValidator;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicksReaderIntegrationTest {

    @Test
    void shouldReadAllTicks() {
        String path = "src/test/resources/ticks-file";
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        Ticks ticks = ticksReader.readAll();

        assertEquals(3, ticks.size());
        assertEquals(List.of("signature1", "signature2", "signature3"),
                ticks.stream().map(Tick::signature).collect(Collectors.toList())
        );
    }

    @Test
    void shouldReadCleanTicks() {
        String path = "src/test/resources/ticks-unclean-file";
        String absolutePath = new File(path).getAbsolutePath();

        TicksReader ticksReader = new TicksReader(absolutePath);
        Ticks ticks = ticksReader.readCleanUsing(OptimizedAlphanumericValidator.instance);

        assertEquals(2, ticks.size());
        assertEquals(List.of("signature1", "signature2"),
                ticks.stream().map(Tick::signature).collect(Collectors.toList())
        );
    }
}