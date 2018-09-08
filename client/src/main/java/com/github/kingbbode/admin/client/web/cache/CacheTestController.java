package com.github.kingbbode.admin.client.web.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("cache")
@Slf4j
@RequiredArgsConstructor
@RestController
public class CacheTestController {

    private final CacheTestService cacheTestService;

    @GetMapping("/cache")
    public ResponseEntity<String> cache() {
        int size = cacheTestService.get().getIds().size();
        log.info("[Cache][Request] find list size={}", size);
        return ResponseEntity.ok("OK");
    }
}
