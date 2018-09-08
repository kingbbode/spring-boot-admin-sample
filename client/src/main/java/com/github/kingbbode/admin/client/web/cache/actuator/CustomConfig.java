package com.github.kingbbode.admin.client.web.cache.actuator;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class CustomConfig {

    @Bean
    @Profile("cache")
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public CacheTestEndPoint cacheTestEndPoint(CacheManager cacheManager) {
        return new CacheTestEndPoint(cacheManager);
    }
}
