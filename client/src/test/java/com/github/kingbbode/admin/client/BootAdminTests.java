package com.github.kingbbode.admin.client;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BootAdminTests {

    @Autowired
    private RestTemplate restTemplate;

    @RepeatedTest(40)
    void 캐시_데이터_요청() throws Exception {
        Thread.sleep(2_000);
        System.out.println(restTemplate.getForEntity("http://localhost:8989/cache", String.class));
    }
}
