package net.hendrikjander.example;

import net.openhft.chronicle.map.ChronicleMapBuilder;
import org.apache.commons.lang3.RandomStringUtils;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Setup;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jah on 1/18/16.
 */
public class ChronicleMapBenchmark extends AbstractBenchmark{

    @Override
    @Setup
    public void create(MapUnderTest state) {
        super.create(state);

        ChronicleMapBuilder<Integer, String> mapBuilder =
                ChronicleMapBuilder.of(Integer.class, String.class)
                        .entries(1_000)
                        .averageValue(RandomStringUtils.random(VALUE_SPACE));

        state.testedMap = mapBuilder.create();
    }
}
