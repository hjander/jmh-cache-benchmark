package net.hendrikjander.example;

import org.openjdk.jmh.annotations.Setup;

import java.util.HashMap;

/**
 *
 * http://java-performance.info/introduction-jmh-profilers/
 *
 */


public class HashMapBenchmark extends AbstractBenchmark {

    @Setup
    @Override
    public void create(MapUnderTest state) {
        super.create(state);
        state.testedMap = new HashMap<>();
    }

}
