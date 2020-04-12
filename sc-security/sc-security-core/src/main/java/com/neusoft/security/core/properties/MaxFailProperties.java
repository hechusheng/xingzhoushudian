package com.neusoft.security.core.properties;

public class MaxFailProperties {

    private boolean enabled;

    private Long interval;

    private Long timesBeforeLock;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public Long getTimesBeforeLock() {
        return timesBeforeLock;
    }

    public void setTimesBeforeLock(Long timesBeforeLock) {
        this.timesBeforeLock = timesBeforeLock;
    }
}
