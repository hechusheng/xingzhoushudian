package com.neusoft.security.core.filter;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 * <p>自定义安全配置类</p>
 * <p>创建日期：2018-04-20</p>
 * 
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScAbstractSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
}
