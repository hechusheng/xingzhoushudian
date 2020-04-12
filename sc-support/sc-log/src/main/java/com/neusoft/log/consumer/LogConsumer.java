package com.neusoft.log.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p></p>
 * <p>创建日期：2018-03-16</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class LogConsumer implements InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(LogConsumer.class);

    private DefaultMQPushConsumer consumer;

    @Value("${sc.cloud.log.rocket-mq.namesrv-addr}")
    private String namesrvAddr;

    @Value("${sc.cloud.log.rocket-mq.topic}")
    private String topic;

    @Value("${spring.application.name}")
    private String groupName;

    @Value("${sc.cloud.log.rocket-mq.batch-max-size}")
    private Integer batchMaxSize;

    @Resource
    private LogMessageListener logMessageListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            consumer = new DefaultMQPushConsumer(groupName);
            consumer.setNamesrvAddr(namesrvAddr);
            consumer.subscribe(topic, "*");
            consumer.registerMessageListener(logMessageListener);
            consumer.setConsumeMessageBatchMaxSize(batchMaxSize);
            consumer.start();

            logger.info("------日志信息处理器初始化完成------");

        } catch (Exception e) {
            logger.error("------日志信息处理器初始化失败------", e);
        }
    }


    @Override
    public void destroy() {
        if (consumer != null) {
            consumer.shutdown();
            logger.info("------日志信息处理器销毁化完成------");
        }
    }

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
