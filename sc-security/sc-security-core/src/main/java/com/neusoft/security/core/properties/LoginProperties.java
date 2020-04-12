package com.neusoft.security.core.properties;


public class LoginProperties {

    private MaxFailProperties maxFail = new MaxFailProperties();

    public MaxFailProperties getMaxFail() {
        return maxFail;
    }

    public void setMaxFail(MaxFailProperties maxFail) {
        this.maxFail = maxFail;
    }
}
