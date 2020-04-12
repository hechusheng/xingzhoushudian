package com.neusoft.core.property;

/**
 * <p>异步任务线程池</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class AsyncTaskProperties {

    private int corePoolSize = 50;

    private int maxPoolSize = 100;

    private int queueCapacity = 10000;

    private int keepAliveSeconds = 3000;

    private String threadNamePrefix = "sc-task-executor-";

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
}
