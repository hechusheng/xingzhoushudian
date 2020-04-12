package com.neusoft.job.config;

import com.neusoft.job.listener.ScSchedulerListener;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>quartz配置</p>
 * <p>创建日期：2018-03-07</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class QuartzConfig {

    public static final String SCHEDULER_NAME = "SC-JOB";

    public static final String QUARTZ_PROPERTIES_PATH = "/quartz.properties";

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_PROPERTIES_PATH));
        // 在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    public static class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements
            ApplicationContextAware {

        private transient AutowireCapableBeanFactory beanFactory;

        @Override
        public void setApplicationContext(final ApplicationContext context) {
            beanFactory = context.getAutowireCapableBeanFactory();
        }

        @Override
        protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
            final Object job = super.createJobInstance(bundle);
            beanFactory.autowireBean(job);
            return job;
        }
    }


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, @Qualifier("dataSource") DataSource dataSource, PlatformTransactionManager transactionManager) throws IOException, SchedulerException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setSchedulerName(SCHEDULER_NAME);
        factory.setAutoStartup(true);
        // 使job实例支持spring 容器管理
        factory.setOverwriteExistingJobs(true);
        factory.setJobFactory(jobFactory);
        // 延迟2s启动quartz
        factory.setStartupDelay(2);
        factory.setQuartzProperties(quartzProperties());

        //jdbc store
        factory.setDataSource(dataSource);
        factory.setTransactionManager(transactionManager);
        factory.setSchedulerListeners(new ScSchedulerListener());

        return factory;
    }

}
