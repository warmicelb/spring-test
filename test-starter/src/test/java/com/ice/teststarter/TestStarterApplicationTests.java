package com.ice.teststarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
class TestStarterApplicationTests {

    @Autowired
    private Jedis jedis;
    @Test
    void contextLoads() {
        jedis.set("test","111");
        String test = jedis.get("test");
        System.out.println(test);
    }

}
