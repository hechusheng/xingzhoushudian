package com.neusoft.log.consumer;

import com.neusoft.log.entity.LogEntity;
import com.neusoft.log.service.LogService;
import com.neusoft.util.JsonUtils;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>日志消息处理器</p>
 * <p>创建日期：2018-03-16</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
public class LogMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(LogMessageListener.class);

    @Resource
    private LogService logService;


    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        List<LogEntity> logEntities = new ArrayList<>(msgs.size());
        for (MessageExt messageExt : msgs) {
            byte[] bytes = messageExt.getBody();
            String body = new String(bytes);
            try {
                LogEntity logInfo = JsonUtils.fromJson(body, LogEntity.class);
                logEntities.add(logInfo);
            } catch (Exception e) {
                logger.error("日志参数格式转换错误，日志的参数为{}", body, e);
            }

        }
        logService.saveLogInfo(logEntities);

        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}

