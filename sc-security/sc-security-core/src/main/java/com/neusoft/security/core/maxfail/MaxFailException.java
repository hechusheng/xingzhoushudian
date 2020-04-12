package com.neusoft.security.core.maxfail;

import org.springframework.security.core.AuthenticationException;

public class MaxFailException extends AuthenticationException {

    private Long times;

    private Long interval;


    public MaxFailException(String msg, Throwable t) {
        super(msg, t);
    }

    public MaxFailException(String msg) {
        super(msg);
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public MaxFailException(String msg, Long times) {
        super(msg);
        this.times = times;
    }
}
