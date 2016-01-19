package net.hendrikjander.example;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jah on 1/17/16.
 */


public class ConcurrentHashMapBenchmark extends AbstractBenchmark {

    @Override
    @Setup(Level.Trial)
    public void create(MapUnderTest state) {
        super.create(state);
        state.testedMap = new ConcurrentHashMap<>();
    }

}