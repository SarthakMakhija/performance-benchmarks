package org.learning.tech.validator;

import org.openjdk.jmh.annotations.*;

public class OptimizedAlphanumericValidatorMicroBenchmark {

    @org.openjdk.jmh.annotations.State(Scope.Thread)
    public static class State {
        public String contentPassingAlphanumericValidation = "contentPassingAlphanumericValidation";
        public String contentFailingAlphanumericValidation = "content-Failing-Alphanumeric-Validation";
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean isValid(State state) {
        return OptimizedAlphanumericValidator.instance.isValid(state.contentPassingAlphanumericValidation);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean isNotValid(State state) {
        return OptimizedAlphanumericValidator.instance.isValid(state.contentFailingAlphanumericValidation);
    }
}