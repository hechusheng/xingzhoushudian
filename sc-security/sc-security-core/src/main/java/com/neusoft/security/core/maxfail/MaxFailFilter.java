package com.neusoft.security.core.maxfail;

import com.neusoft.security.core.constant.SecurityConstants;
import com.neusoft.security.core.properties.MaxFailProperties;
import com.neusoft.security.core.properties.SecurityProperties;
import com.neusoft.security.core.util.RedisAtomicIntegerUtils;
import com.neusoft.security.core.validate.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class MaxFailFilter extends OncePerRequestFilter implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(MaxFailFilter.class);

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 存放所有需要校验验证码的url
     */
    private Set<String> urlMap = new HashSet<>();

    /**
     * 验证请求url与配置的url是否匹配的工具类
     */
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    private static final String GET = "get";

    /**
     * 验证码校验失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        boolean flag = true;
        if (should(request)) {
            String username = ServletRequestUtils.getStringParameter(request, "username");
            if (StringUtils.isNotEmpty(username)) {
                MaxFailProperties maxFailProperties = securityProperties.getLogin().getMaxFail();
                String key = SecurityConstants.MAX_FAIL_TIMES + ":" + username;
                Integer count = RedisAtomicIntegerUtils.get(key);
                if (count != null && count >= maxFailProperties.getTimesBeforeLock()) {
                    Long time = RedisAtomicIntegerUtils.getExpire(key);
                    MaxFailException maxFailException = new MaxFailException("登录错误已达最大次数，请" + time + "分钟后重试", time);
                    logger.info("用户{}登录次数已达最大次数，允许登录剩余时间为{}分钟", username, time);
                    flag = false;
                    authenticationFailureHandler.onAuthenticationFailure(request, response, maxFailException);
                }
            }
        }
        if (flag) {
            filterChain.doFilter(request, response);
        }
    }

    /**
     * 初始化要拦截的url配置信息
     *
     * @throws ServletException the servlet exception
     */
    @Override
    public void afterPropertiesSet() throws ServletException {

        super.afterPropertiesSet();
        urlMap.add(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM);
    }

    /**
     * 获取校验码的类型，如果当前请求不需要校验，则返回null
     */
    private boolean should(HttpServletRequest request) {
        ValidateCodeType result = null;
        if (!StringUtils.equalsIgnoreCase(request.getMethod(), GET)) {
            for (String url : urlMap) {
                if (pathMatcher.match(url, request.getRequestURI())) {
                    return true;
                }
            }
        }
        return false;
    }

}
