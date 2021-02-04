package org.learning.tech.model;

import org.junit.jupiter.api.Test;
import org.learning.tech.validator.OptimizedAlphanumericValidator;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TicksUnitTest {

    @Test
    void shouldReturnCleanedTicksWithSameSizeAsOriginalTicks() {
        Ticks ticks = new Ticks(
                List.of(new Tick("alphanumericSignature"))
        );
        Ticks cleaned = ticks.cleanUsing(OptimizedAlphanumericValidator.instance);
        assertEquals(1, cleaned.size());
    }

    @Test
    void shouldReturnCleanedTicksSignatureSameAsOriginalTicks() {
        Ticks ticks = new Ticks(
                List.of(new Tick("alphanumericSignature"))
        );
        Ticks cleaned = ticks.cleanUsing(OptimizedAlphanumericValidator.instance);
        List<String> signatures = cleaned.stream().map(Tick::signature).collect(Collectors.toList());

        assertEquals(List.of("alphanumericSignature"), signatures);
    }

    @Test
    void shouldReturnCleanedTicksWithSizeOneLessThanOriginalSize() {
        Ticks ticks = new Ticks(
                List.of(
                        new Tick("alphanumericSignature"),
                        new Tick("non-AlphanumericSignature")
                )
        );
        Ticks cleaned = ticks.cleanUsing(OptimizedAlphanumericValidator.instance);
        assertEquals(1, cleaned.size());
    }

    @Test
    void shouldReturnCleanedTicksSignature() {
        Ticks ticks = new Ticks(
                List.of(
                        new Tick("alphanumericSignature"),
                        new Tick("non-AlphanumericSignature")
                )
        );
        Ticks cleaned = ticks.cleanUsing(OptimizedAlphanumericValidator.instance);
        List<String> signatures = cleaned.stream().map(Tick::signature).collect(Collectors.toList());

        assertEquals(List.of("alphanumericSignature"), signatures);
    }
}