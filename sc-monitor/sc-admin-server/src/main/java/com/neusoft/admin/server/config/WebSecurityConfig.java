package com.neusoft.admin.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略css.jq.img等文件
        web.ignoring().antMatchers("/**.html", "/**.css", "/img/**", "/**.js", "/third-party/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable() //HTTP with Disable CSRF
                .authorizeRequests() //Authorize Request Configuration
                .antMatchers("/login",
                        "/api/**",
                        "/**/heapdump",
                        "/**/loggers",
                        "/**/liquibase",
                        "/**/logfile",
                        "/**/flyway",
                        "/**/auditevents",
                        "/**/jolokia").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/**").hasRole("USER")
                .antMatchers("/**").authenticated()
                .and() //Login Form configuration for all others
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/login").permitAll()
                .defaultSuccessUrl("/")
                .and() //Logout Form configuration
                .logout()
                .deleteCookies("remove")
                .logoutSuccessUrl("/login.html").permitAll()
                .and()
                .httpBasic();
    }
}
