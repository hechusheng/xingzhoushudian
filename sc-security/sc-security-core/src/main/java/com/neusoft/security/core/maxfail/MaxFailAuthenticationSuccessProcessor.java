package com.neusoft.security.core.maxfail;

import com.neusoft.security.core.constant.SecurityConstants;
import com.neusoft.security.core.listener.processor.AbstractAuthenticationSuccessProcessor;
import com.neusoft.security.core.validate.ValidateCodeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.util.AntPathMatcher;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <p>用户登录失败次数记录成功清理处理器</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class MaxFailAuthenticationSuccessProcessor extends AbstractAuthenticationSuccessProcessor<AuthenticationSuccessEvent> {

    private static final Logger logger = LoggerFactory.getLogger(MaxFailAuthenticationSuccessProcessor.class);

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public void process(AuthenticationSuccessEvent event) {
        String account = event.getAuthentication().getPrincipal().toString();
        //如果用户登录成功，删除已经保存的登录失败次数
        String key = SecurityConstants.MAX_FAIL_TIMES + ":" + account;
        redisTemplate.expire(key, -1, TimeUnit.MILLISECONDS);
        logger.info("用户名为{}的登录次数已清空", account);
    }



}
