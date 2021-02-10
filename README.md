# Performance benchmarks
This is a sample project to demonstrate micro and meso benchmarks.  

# Project Definition
It is a fictional project which considers that a concept called as ```Tick``` is being read from a file.
Each tick contains a ```signature``` which is some ```alphanumeric``` content. So, an input file will contain line delimited alphanumeric content which
will be used to create an instance of Tick.

The idea is to provide two features -
* Return all ticks present in a file
* Return only clean ticks present in a file

A ```clean``` tick is the one which passes an alphanumeric validation applied on its signature.

# Points to ignore
* All the ticks are loaded in memory
* ```OptimizedAlphanumericValidator``` & ```UnoptimizedAlphanumericValidator``` are created for demonstration purpose. There is no need
of ```Validator``` hierarchy in the project

# Types of benchmarks
This project has micro and meso benchmarks. Micro-benchmarks are typically used to evaluate 2 different algorithms for an approach. This project
contains micro benchmarks for ```Validator``` classes.

A meso-benchmark lies within a micro and a macro benchmark. 
This is a very simple project which reads ticks from a file and returns them. Let's assume it as a small part of a big project. 
So, reading from a file, creating an instance of Tick and validating it becomes a meso-benchmark.

# Benchmark calculation
Assume that we have to read 60million ticks in 15 minutes. (Keep parallelization | collection of all ticks in memory aside).

That means we have to read 60 * 1000_000 ticks in 900 seconds, which is 60 * 1000_000 / 900 = 66_666.6666 ticks per second.

Effectively, 
* our throughput requirement is: ```66,666.6666 ticks in one second```
* our (average) response time requirement is: ```0.0000150 seconds for one tick```

# Output (of latest run)
Present in results.txt 

# Plugin for JMH
This project uses ```JMH``` with ```me.champeau.gradle.jmh``` as the gradle plugin for running benchmarks.

# How to run
```TicksReaderMesoBenchmark``` reads a benchmark file from ```src/jmh/resources/ticks-benchmark``` location. It needs the root project path
which is prepended to ```src/jmh/resources/ticks-benchmark```.

```./gradlew jmh -PbenchmarkFileRootPath=/projects/performance-benchmarks/```

assuming this project is placed under ```/projects/performance-benchmarks/``` 