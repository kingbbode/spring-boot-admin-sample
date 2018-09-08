package com.github.kingbbode.admin.client.web.lock;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LockTestController {
    @GetMapping("/lock")
    public ResponseEntity<String> logging() {

        return ResponseEntity.ok("OK");
    }
}
