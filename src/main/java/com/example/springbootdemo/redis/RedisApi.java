package com.example.springbootdemo.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.net.URL;

@Component
@Slf4j
public class RedisApi {

    private static ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    @Resource
    public void setReactiveRedisTemplate(ReactiveRedisTemplate<String, Object> reactiveRedisTemplate) {
        RedisApi.reactiveRedisTemplate = reactiveRedisTemplate;
        ReactiveRedisConnectionFactory redisConnectionFactory = reactiveRedisTemplate.getConnectionFactory();
    }

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
//    @Resource(name="redisTemplate")
//    private ListOperations<String, Object> listOps;

    public static void addLink(String userId, URL url) {
//        listOps.leftPush(userId, url.toExternalForm());
        // or use template directly
        reactiveRedisTemplate.opsForList().leftPush(userId, url.toExternalForm());
    }
}
