package com.neusoft.security.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisAtomicIntegerUtils {

    private static RedisTemplate redisTemplate;

    public static int increment(String key, long liveTime, TimeUnit timeUnit) {
        RedisAtomicInteger entityIdCounter = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
        int increment = entityIdCounter.incrementAndGet();
        //初始设置过期时间
        if (liveTime >= 0) {
            entityIdCounter.expire(liveTime, timeUnit);
        }

        return increment;
    }

    /**
     * 根据key获取value
     *
     * @param key key
     * @return value
     */
    public static Integer get(String key) {
        RedisAtomicInteger entityIdCounter = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
        try {
            return entityIdCounter.get();
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 根据key获取过期时间
     *
     * @param key
     * @return
     */
    public static Long getExpire(String key) {
        RedisAtomicInteger entityIdCounter = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
        return entityIdCounter.getExpire();
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisAtomicIntegerUtils.redisTemplate = redisTemplate;
    }
}
