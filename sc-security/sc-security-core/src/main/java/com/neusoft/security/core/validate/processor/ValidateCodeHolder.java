package com.neusoft.security.core.validate.processor;


public class ValidateCodeHolder {

    private static ThreadLocal<String> deviceIdHolder = new ThreadLocal<>();

    public static ThreadLocal<String> getDeviceIdHolder() {
        return deviceIdHolder;
    }

}
