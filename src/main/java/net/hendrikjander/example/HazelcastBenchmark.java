package net.hendrikjander.example;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.apache.ignite.Ignition;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;

/**
 * Created by jah on 1/18/16.
 */
public class HazelcastBenchmark extends AbstractBenchmark {

    HazelcastInstance instance;

    @Setup
    @Override
    public void create(CacheBenchmark.MapUnderTest state) {
        super.create(state);

        Config cfg = new Config();
        instance = Hazelcast.newHazelcastInstance(cfg);

        state.testedMap = instance.getMap("benchmark");

    }

    @TearDown
    public void cleanup(){
        instance.shutdown();
    }
}
