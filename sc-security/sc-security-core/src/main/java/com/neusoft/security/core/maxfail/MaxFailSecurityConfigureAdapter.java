package com.neusoft.security.core.maxfail;

import com.neusoft.security.core.filter.ScAbstractSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * <p>security拦截器配置类</p>
 * <p>创建日期：2018-04-20</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Order(Integer.MIN_VALUE)
public class MaxFailSecurityConfigureAdapter extends ScAbstractSecurityConfigurerAdapter {

    @Autowired
    private MaxFailFilter maxFailFilter;

    /**
     * Configure.
     *
     * @param http the http
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.addFilterBefore(maxFailFilter, AbstractPreAuthenticatedProcessingFilter.class);
    }

}
