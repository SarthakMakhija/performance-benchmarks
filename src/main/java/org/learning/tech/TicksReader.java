package org.learning.tech;

import org.learning.tech.exception.TicksReadFailedException;
import org.learning.tech.model.Tick;
import org.learning.tech.model.Ticks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicksReader {

    private final String fileName;

    public TicksReader(String fileName) {
        this.fileName = fileName;
    }

    public Ticks read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return new Ticks(ticksFrom(reader));
        } catch (IOException e) {
            throw new TicksReadFailedException(fileName, e);
        }
    }

    private List<Tick> ticksFrom(BufferedReader reader) throws IOException {
        List<Tick> ticks = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            ticks.add(new Tick(line));
            line = reader.readLine();
        }

        return ticks;
    }
}