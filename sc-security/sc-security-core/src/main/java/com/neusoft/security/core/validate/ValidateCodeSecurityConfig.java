package com.neusoft.security.core.validate;

import com.neusoft.security.core.filter.ScAbstractSecurityConfigurerAdapter;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.Filter;

/**
 * <p>校验码相关安全配置</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
@Order(2)
public class ValidateCodeSecurityConfig extends ScAbstractSecurityConfigurerAdapter {

    @Resource
    private Filter validateCodeFilter;

    /**
     * Configure.
     *
     * @param http the http
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(validateCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }

}
