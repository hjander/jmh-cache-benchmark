package net.hendrikjander.example;

import org.infinispan.manager.DefaultCacheManager;
import org.openjdk.jmh.annotations.Setup;

/**
 * Created by jah on 1/17/16.
 */
public class InfinispanBenchmark extends AbstractBenchmark{

    @Setup
    @Override
    public void create(CacheBenchmark.MapUnderTest state) {
        super.create(state);
        state.testedMap = new DefaultCacheManager().getCache();
    }

}
