package org.learning.tech;

import org.learning.tech.exception.TicksReadFailedException;
import org.learning.tech.model.Tick;
import org.learning.tech.model.Ticks;
import org.learning.tech.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class TicksReader {

    private final Path filePath;

    public TicksReader(String fileName) {
        this.filePath = Paths.get(fileName);
    }

    public Ticks readAll() {
        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            return new Ticks(ticksFrom(reader));
        } catch (IOException e) {
            throw new TicksReadFailedException(filePath.getFileName().toString(), e);
        }
    }

    public Ticks readCleanUsing(Validator validator) {
        return readAll().cleanUsing(validator);
    }

    private List<Tick> ticksFrom(BufferedReader reader) throws IOException {
        return reader.lines().map(Tick::new).collect(Collectors.toList());
    }
}