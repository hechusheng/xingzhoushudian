package com.neusoft.support.sharding.config;

import com.neusoft.core.page.PageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>spring mvc配置</p>
 * <p>创建日期：2018-03-06</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new PageInterceptor());
        System.out.println("===========   分页拦截器注册完毕   ===========");
        System.out.println("===========   拦截器注册完毕   ===========");
    }

}
