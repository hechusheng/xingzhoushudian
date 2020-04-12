package com.neusoft.security.core;

import com.neusoft.security.core.properties.SecurityProperties;
import com.neusoft.security.core.validate.ValidateCodeSecurityConfig;
import com.neusoft.security.core.validate.filter.ValidateCodeFilter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * <p>自动配置类</p>
 * <p>创建日期：2018-04-13</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
@ComponentScan(basePackages = "com.neusoft.security.core")
@EnableConfigurationProperties({SecurityProperties.class})
public class ScSecurityCoreAutoConfigure {

    @Bean
    public Filter validateCodeFilter() {
        return new ValidateCodeFilter();
    }

    @Bean
    public ValidateCodeSecurityConfig validateCodeSecurityConfig() {
        return new ValidateCodeSecurityConfig();
    }


}
