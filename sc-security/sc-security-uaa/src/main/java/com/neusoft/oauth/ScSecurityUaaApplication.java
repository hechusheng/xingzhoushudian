package com.neusoft.oauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>系统启动类</p>
 * <p>创建日期：2017-12-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.neusoft.oauth")
public class ScSecurityUaaApplication  {

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<?, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScSecurityUaaApplication.class, args);
    }
}
