package com.neusoft.core.config;

import com.neusoft.core.exception.ScExceptionHandle;
import com.neusoft.core.page.PageAdvices;
import com.neusoft.core.property.ScCloudProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>core自动配置</p>
 * <p>创建日期：2018-04-04</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
@ComponentScan("com.neusoft.core")
@EnableConfigurationProperties({ScCloudProperties.class})
@Import({AsyncTaskExecutorConfiguration.class,
        JacksonConfig.class,
        SwaggerConfiguration.class,
        ValidatorConfiguration.class
})
public class CoreAutoConfigure {

    /**
     * 分页拦截器
     *
     * @return
     */
    @Bean
    public PageAdvices pageAdvices() {
        return new PageAdvices();
    }

    /**
     * 异常处理器
     *
     * @return
     */
    @Bean
    public ScExceptionHandle scExceptionHandle() {
        return new ScExceptionHandle();
    }

}
