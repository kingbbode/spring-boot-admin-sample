package com.github.kingbbode.admin.client.web.cache.actuator;

import com.github.kingbbode.admin.client.web.cache.TestEntityListDto;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.cache.CacheManager;

import java.util.Optional;

import static com.github.kingbbode.admin.client.web.cache.CacheTestService.CACHE_NAME;

@Endpoint(id = "cache-detail")
public class CacheTestEndPoint {
    private final CacheManager cacheManager;

    public CacheTestEndPoint(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }


    @ReadOperation
    public TestEntityListDto cache() {
        return Optional.ofNullable(this.cacheManager.getCache(CACHE_NAME))
                .map(cache -> cache.get(CACHE_NAME, TestEntityListDto.class))
                .orElse(TestEntityListDto.EMPTY);
    }
}
