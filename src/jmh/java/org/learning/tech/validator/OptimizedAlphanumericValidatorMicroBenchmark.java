package org.learning.tech.validator;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
public class OptimizedAlphanumericValidatorMicroBenchmark {

    private List<String> contentPassingAlphanumericValidation;
    private List<String> contentFailingAlphanumericValidation;

    @Param({"10000"})
    private int totalContentItemsToBeValidated;

    @Param({"1000000"})
    private int totalBenchmarkIterations;

    @Setup(Level.Trial)
    public void setup() {
        contentPassingAlphanumericValidation = new ArrayList<>();
        contentFailingAlphanumericValidation = new ArrayList<>();
        for (int count = 1; count <= totalContentItemsToBeValidated; count++) {
            contentPassingAlphanumericValidation.add("contentPassingAlphanumericValidation" + count);
            contentFailingAlphanumericValidation.add("content-Failing-Alphanumeric-Validation" + count);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void isValid(Blackhole blackhole) {
        for (int count = 1; count <= totalBenchmarkIterations; count++) {
            boolean isValid = OptimizedAlphanumericValidator.instance.isValid(contentPassingAlphanumericValidation.get(count % totalContentItemsToBeValidated));
            blackhole.consume(isValid);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void isNotValid(Blackhole blackhole) {
        for (int count = 1; count <= totalBenchmarkIterations; count++) {
            boolean isValid = OptimizedAlphanumericValidator.instance.isValid(contentFailingAlphanumericValidation.get(count % totalContentItemsToBeValidated));
            blackhole.consume(isValid);
        }
    }
}