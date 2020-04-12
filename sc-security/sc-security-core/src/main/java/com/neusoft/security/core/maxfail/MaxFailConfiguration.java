package com.neusoft.security.core.maxfail;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>用户登录失败次数记录配置类</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
@ConditionalOnProperty(prefix = "sc.security.login.max-fail", value = "enabled", havingValue = "true")
public class MaxFailConfiguration {

    @Bean
    public MaxFailAuthenticationSuccessProcessor maxFailAuthenticationSuccessProcessor() {
        return new MaxFailAuthenticationSuccessProcessor();
    }

    @Bean
    public MaxFailAuthenticationFailureProcessor maxFailAuthenticationFailureProcessor() {
        return new MaxFailAuthenticationFailureProcessor();
    }

    @Bean
    public MaxFailFilter maxFailFilter() {
        return new MaxFailFilter();
    }


    @Bean
    public MaxFailSecurityConfigureAdapter maxFailSecurityConfigureAdapter() {
        return new MaxFailSecurityConfigureAdapter();
    }

}
