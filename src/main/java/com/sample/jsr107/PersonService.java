package com.sample.jsr107;

import java.util.Date;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.cache.CacheManager;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.Duration;
import javax.cache.expiry.TouchedExpiryPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.stereotype.Component;

/**
 *
 * @author WS
 */

@Component
@CacheDefaults(cacheName = "personCache")
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    //create cache
    /*@Component
    public static class CachingSetup implements JCacheManagerCustomizer
    {
      @Override
      public void customize(CacheManager cacheManager)
      {
        cacheManager.createCache("people", new MutableConfiguration<>()
          .setExpiryPolicyFactory(TouchedExpiryPolicy.factoryOf(new Duration(SECONDS, 20)))
          .setStoreByValue(false)
          .setStatisticsEnabled(true));
      }
    }
    */

    @CacheResult
    public Person getPerson(int persId)
    {
        LOGGER.info("persId " + persId + " not found in cache. TimeStamp: {}", new Date());

        switch (persId)
        {
            case 12345:
                return new Person(persId, "James", "Bond");
            case 6789:
                return new Person(persId, "Spider", "Man");
            default:
                return new Person(persId,"Bat","Man");
        }
    }


}
