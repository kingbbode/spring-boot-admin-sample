package com.github.kingbbode.admin.client.web.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Profile("cache")
@RequiredArgsConstructor
@Service
@Slf4j
public class CacheTestService {

    public static final String CACHE_NAME = "test";
    private final TestEntityRepository testEntityRepository;

    @Cacheable(cacheNames = CACHE_NAME, key = "'test'")
    public TestEntityListDto get() {
        log.info("[Cache] cache refresh!!");

        return TestEntityListDto.builder()
                .data(testEntityRepository.findAll().stream()
                        .map(data -> TestEntityListDto.TestEntityDto.builder()
                                .id(data.getId())
                                .text(data.getText())
                                .build()
                        )
                        .collect(Collectors.toList())
                ).build();
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
