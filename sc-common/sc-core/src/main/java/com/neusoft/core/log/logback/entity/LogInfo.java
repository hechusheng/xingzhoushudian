package com.neusoft.core.log.logback.entity;

import ch.qos.logback.classic.spi.ILoggingEvent;

import java.io.Serializable;


public class LogInfo implements Serializable {

    /**
     * 时间日期
     */
    private long eventTime;

    /**
     * 日志级别
     */
    private String levelStr;

    /**
     * 线程名称
     */
    private String threadName;

    /**
     * Logger名
     */
    private String loggerName;

    /**
     * 日志内容
     */
    private String message;

    private String contextName;

    public LogInfo() {

    }

    public LogInfo(ILoggingEvent event) {
        this.message = event.getMessage();
        this.threadName = event.getThreadName();
        this.eventTime = event.getTimeStamp();
        this.levelStr = event.getLevel().levelStr;
        this.loggerName = event.getLoggerName();
        this.contextName = event.getLoggerContextVO().getName();
    }

    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public long getEventTime() {
        return eventTime;
    }

    public void setEventTime(long eventTime) {
        this.eventTime = eventTime;
    }

    public String getLevelStr() {
        return levelStr;
    }

    public void setLevelStr(String levelStr) {
        this.levelStr = levelStr;
    }

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }
}
