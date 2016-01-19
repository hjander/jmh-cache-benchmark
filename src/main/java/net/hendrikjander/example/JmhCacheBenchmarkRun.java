package net.hendrikjander.example;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.openjdk.jmh.runner.options.VerboseMode;

import java.util.concurrent.TimeUnit;


/**
 * Created by jah on 1/17/16.
 */



public class JmhCacheBenchmarkRun {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()

                .include(".*Benchmark").exclude(HazelcastBenchmark.class.getName())

                .warmupBatchSize(1).warmupIterations(1).warmupTime(TimeValue.seconds(5))
                .measurementBatchSize(1).measurementIterations(5).measurementTime(TimeValue.seconds(10))

                .operationsPerInvocation(10)
                .timeUnit(TimeUnit.NANOSECONDS)
                .mode(Mode.Throughput)
                .forks(1)

                .verbosity(VerboseMode.EXTRA)
                .resultFormat(ResultFormatType.TEXT)
                //.jvmArgs("-XX:+PrintCompilation")

                .build();

        new Runner(opt).run();

    }


}
