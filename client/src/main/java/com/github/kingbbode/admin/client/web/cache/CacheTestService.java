package com.github.kingbbode.admin.client.web.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("cache")
@RequiredArgsConstructor
@Service
@Slf4j
public class CacheTestService {

    private final TestEntityRepository testEntityRepository;

    @Cacheable("test")
    public List<TestEntity> get() {
        log.info("[Cache] cache refresh!!");
        return testEntityRepository.findAll();
    }

    @Scheduled(fixedDelay = 4_000)
    public void addOrClear() {
        if(testEntityRepository.findAll().size() > 10) {
            log.info("[Cache] data clear!");
            testEntityRepository.deleteAll();
            return;
        }
        log.info("[Cache] data add!");
        testEntityRepository.save(new TestEntity());
    }
}
