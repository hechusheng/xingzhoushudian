package com.neusoft.security.core.maxfail;

import com.neusoft.security.core.constant.SecurityConstants;
import com.neusoft.security.core.listener.processor.AbstractAuthenticationFailureProcessor;
import com.neusoft.security.core.properties.MaxFailProperties;
import com.neusoft.security.core.properties.SecurityProperties;
import com.neusoft.security.core.util.RedisAtomicIntegerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;

import java.util.concurrent.TimeUnit;

/**
 * <p>用户登录失败次数记录处理器</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class MaxFailAuthenticationFailureProcessor extends AbstractAuthenticationFailureProcessor<AuthenticationFailureBadCredentialsEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MaxFailAuthenticationFailureProcessor.class);

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void process(AuthenticationFailureBadCredentialsEvent event) {
        String account = event.getAuthentication().getPrincipal().toString();
        MaxFailProperties maxFailProperties = securityProperties.getLogin().getMaxFail();
        //记录用户登录错误的次数
        String key = SecurityConstants.MAX_FAIL_TIMES + ":" + account;
        int increment = RedisAtomicIntegerUtils.increment(key, maxFailProperties.getInterval(), TimeUnit.MINUTES);


        logger.info("用户名为{}的用户登录用户名或密码错误，失败的次数达到{}次", account, increment);
    }




}
