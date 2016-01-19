package net.hendrikjander.example;

import org.openjdk.jmh.annotations.*;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by jah on 1/17/16.
 */

public interface CacheBenchmark {

    @State(Scope.Benchmark)
    class MapUnderTest{
        public volatile Map<Integer, String> testedMap;
    }

    void create(MapUnderTest state);


    void measureInsertPerformance(MapUnderTest state);

    void measureGetPerformance(MapUnderTest state);

}
