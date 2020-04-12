package com.neusoft.oauth.config;

import com.neusoft.oauth.security.ScAuthenticationFailureHandler;
import com.neusoft.oauth.security.ScAuthenticationSuccessHandler;
import com.neusoft.security.client.authorize.ScAuthorizeConfigManager;
import com.neusoft.security.core.constant.SecurityConstants;
import com.neusoft.security.core.filter.ScAbstractSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>资源服务器配置类</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private List<ScAbstractSecurityConfigurerAdapter> scAbstractSecurityConfigurerAdapters;

    @Resource
    private ScAuthenticationSuccessHandler scAuthenticationSuccessHandler;

    @Resource
    private ScAuthenticationFailureHandler scAuthenticationFailureHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private ScAuthorizeConfigManager scAuthorizeConfigManager;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                //关闭sesiion
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        if (!CollectionUtils.isEmpty(scAbstractSecurityConfigurerAdapters)) {
            for (ScAbstractSecurityConfigurerAdapter adapter : scAbstractSecurityConfigurerAdapters) {
                http.apply(adapter);
            }
        }

        http
                .formLogin()
                .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
                .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
                .successHandler(scAuthenticationSuccessHandler)
                .failureHandler(scAuthenticationFailureHandler);

        scAuthorizeConfigManager.config(http.authorizeRequests());

        http
                .authorizeRequests()
                .mvcMatchers(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);

    }


}
