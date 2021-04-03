package com.itlab.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StopWatch;

@SpringBootTest
class RedisTests {

    private Logger LOGGER = LoggerFactory.getLogger(RedisTests.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private TestService testService;

    @Test
    public void redis() {
//        testService.createStressTest(String.valueOf(1));
        LOGGER.info("Start!!!");
        StopWatch stopWatch = new StopWatch();
        LOGGER.info("Redis Start!!!");
        stopWatch.start("Redis");
        for (int i = 0 ; i < 1_000_000 ; i++) {
            redisTemplate.opsForValue().set(String.valueOf(i), String.valueOf(i));
        }
        LOGGER.info("Redis End!!!");
        stopWatch.stop();

        LOGGER.info("MariaDB Start!!!");
        stopWatch.start("MariaDB");
        for (int i = 0 ; i < 1_000_000 ; i++) {
            testService.createStressTest(String.valueOf(i));
        }
        LOGGER.info("MariaDB End!!!");
        stopWatch.stop();

        LOGGER.info(stopWatch.prettyPrint());
    }

}
