package com.neusoft.core.config;

import com.neusoft.core.property.ScCloudProperties;
import com.neusoft.core.task.ScAsyncTaskExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * <p>异步线程池配置</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
@EnableAsync
public class AsyncTaskExecutorConfiguration implements AsyncConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTaskExecutorConfiguration.class);

    @Resource
    private ScCloudProperties scCloudProperties;

    @Resource
    private AsyncTaskExecutor asyncTaskExecutor;

    @Bean
    @ConditionalOnMissingBean(AsyncTaskExecutor.class)
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(scCloudProperties.getTask().getCorePoolSize());
        executor.setMaxPoolSize(scCloudProperties.getTask().getMaxPoolSize());
        executor.setKeepAliveSeconds(scCloudProperties.getTask().getKeepAliveSeconds());
        executor.setQueueCapacity(scCloudProperties.getTask().getQueueCapacity());
        executor.setThreadNamePrefix(scCloudProperties.getTask().getThreadNamePrefix());
        return executor;
    }

    @Override
    @Bean(name = "taskExecutor")
    public Executor getAsyncExecutor() {
        logger.debug("Creating Async Task Executor");
        return new ScAsyncTaskExecutor(asyncTaskExecutor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();

    }
}
