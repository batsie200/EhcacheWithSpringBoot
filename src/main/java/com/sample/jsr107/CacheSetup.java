package com.sample.jsr107;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

import javax.cache.CacheManager;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author WS
 */
//create cache
@Component
public class CacheSetup implements JCacheManagerCustomizer {
    @Override
    public void customize(CacheManager cacheManager) {
        cacheManager.createCache("personCache", new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 20)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true));
    }
}