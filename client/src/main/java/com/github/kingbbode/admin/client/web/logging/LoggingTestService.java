package com.github.kingbbode.admin.client.web.logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Profile("logging")
@Service
@Slf4j
public class LoggingTestService {

    @Scheduled(fixedDelay = 2_000)
    public void print() {
        System.out.println("*************************************");
        log.info("[INFO][INFO][INFO][INFO][INFO]");
        log.error("[ERROR][ERROR][ERROR][ERROR][ERROR]");
        log.warn("[WARN][WARN][WARN][WARN][WARN]");
        log.debug("[DEBUG][DEBUG][DEBUG][DEBUG][DEBUG]");
        System.out.println("*************************************");

    }
}
