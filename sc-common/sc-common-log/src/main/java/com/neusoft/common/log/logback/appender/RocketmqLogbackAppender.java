package com.neusoft.common.log.logback.appender;

import ch.qos.logback.classic.net.LoggingEventPreSerializationTransformer;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neusoft.common.log.logback.entity.LogEntity;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.logappender.common.ProducerInstance;

public class RocketmqLogbackAppender extends AppenderBase<ILoggingEvent> {
    /**
     * Message tag define
     */
    private String tag;

    /**
     * Whitch topic to send log messages
     */
    private String topic;

    /**
     * RocketMQ nameserver address
     */
    private String nameServerAddress;

    /**
     * Log producer group
     */
    private String producerGroup;

    /**
     * Log producer send instance
     */
    private MQProducer producer;

    private Gson gson = new GsonBuilder().create();

    private String applicationName;

    private PreSerializationTransformer<ILoggingEvent> pst = new LoggingEventPreSerializationTransformer();

    /**
     * Info,error,warn,callback method implementation
     */
    @Override
    protected void append(ILoggingEvent event) {
        if (!isStarted()) {
            return;
        }

        //设置日志内容
        LogEntity logEntity = new LogEntity();
        logEntity.setEventTime(event.getTimeStamp());
        logEntity.setApplicationName(applicationName);
        logEntity.setLevelStr(event.getLevel().levelStr);
        logEntity.setMessage(event.getMessage());
        logEntity.setThreadName(event.getThreadName());
        logEntity.setLoggerName(event.getLoggerName());

        String logStr = gson.toJson(logEntity);
        try {
            Message msg = new Message(topic, tag, logStr.getBytes());
            msg.getProperties().put(ProducerInstance.APPENDER_TYPE, ProducerInstance.LOGBACK_APPENDER);

            //Send message and do not wait for the ack from the message broker.
            producer.sendOneway(msg);
        } catch (Exception e) {
            addError("Could not send message in RocketmqLogbackAppender [" + name + "]. Message is : " + logStr, e);
        }
    }

    /**
     * Options are activated and become effective only after calling this method.
     */
    @Override
    public void start() {

        try {
            producer = ProducerInstance.getProducerInstance().getInstance(nameServerAddress, producerGroup);
        } catch (Exception e) {
            addError("Starting RocketmqLogbackAppender [" + this.getName()
                    + "] nameServerAddress:" + nameServerAddress + " group:" + producerGroup + " " + e.getMessage());
        }
        if (producer != null) {
            super.start();
        }
    }

    /**
     * When system exit,this method will be called to close resources
     */
    @Override
    public synchronized void stop() {
        // The synchronized modifier avoids concurrent append and close operations
        if (!this.started) {
            return;
        }

        this.started = false;

        try {
            ProducerInstance.getProducerInstance().removeAndClose(this.nameServerAddress, this.producerGroup);
        } catch (Exception e) {
            addError("Closeing RocketmqLogbackAppender [" + this.getName()
                    + "] nameServerAddress:" + nameServerAddress + " group:" + producerGroup + " " + e.getMessage());
        }

        // Help garbage collection
        producer = null;
    }

    protected boolean checkEntryConditions() {
        String fail = null;

        if (this.topic == null) {
            fail = "No topic";
        }

        if (fail != null) {
            addError(fail + " for RocketmqLogbackAppender named [" + name + "].");
            return false;
        } else {
            return true;
        }
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setNameServerAddress(String nameServerAddress) {
        this.nameServerAddress = nameServerAddress;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
