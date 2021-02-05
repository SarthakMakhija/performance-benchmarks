package org.learning.tech.reader;

import org.learning.tech.TicksReader;
import org.learning.tech.model.Ticks;
import org.learning.tech.validator.OptimizedAlphanumericValidator;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class TicksReaderMesoBenchmark {

    private TicksReader ticksReader;

    @Param({""})
    private String benchmarkFileRootPath;

    @Setup(Level.Trial)
    public void setUp() {
        String path = benchmarkFileRootPath + "src/jmh/resources/ticks-benchmark";
        ticksReader = new TicksReader(path);
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public void readAllTicks(Blackhole blackhole) {
        Ticks ticks = ticksReader.readAll();
        blackhole.consume(ticks);
    }

    @Benchmark
    @BenchmarkMode({Mode.Throughput, Mode.AverageTime})
    public void readCleanTicks(Blackhole blackhole) {
        Ticks ticks = ticksReader.readCleanUsing(OptimizedAlphanumericValidator.instance);
        blackhole.consume(ticks);
    }
}