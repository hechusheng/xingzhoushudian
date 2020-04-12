package com.neusoft.common.log.logback.entity;

import java.io.Serializable;

public class LogEntity implements Serializable {


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

    private String applicationName;

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
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
