package net.hendrikjander.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.ThreadLocalRandom;


/**
 * Created by jah on 1/17/16.
 */


@State(Scope.Benchmark)
public abstract class AbstractBenchmark implements CacheBenchmark{


    final protected static int VALUE_SPACE = 5000;

    protected static Integer[] keys;
    protected static String[] values;
    protected static ThreadLocalRandom random = ThreadLocalRandom.current();


    @Override
    public void create(MapUnderTest state){
        prepare();
    }

    @Benchmark
    @Override
    public void measureInsertPerformance(MapUnderTest state) {
        state.testedMap.put(keys[random.nextInt(VALUE_SPACE)], values[random.nextInt(VALUE_SPACE)]);
    }

    @Benchmark
    @Override
    public void measureGetPerformance(MapUnderTest state) {
        state.testedMap.get(random.nextInt(VALUE_SPACE));
    }



    public void prepare() {

        keys = new Integer[VALUE_SPACE];
        values = new String[VALUE_SPACE];

        for (int k = 0; k < keys.length; k++) {
            keys[k] = k;
            values[k] = RandomStringUtils.randomAscii(500);
        }
    }

}
