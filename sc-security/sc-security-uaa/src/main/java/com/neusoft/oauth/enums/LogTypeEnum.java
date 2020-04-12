package com.neusoft.oauth.enums;

/**
 * <p>日志类型枚举类</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public enum LogTypeEnum {

    /**
     * 操作日志
     */
    OPERATION_LOG("10", "操作日志"),

    /**
     * 登录日志
     */
    LOGIN_LOG("20", "登录日志"),

    /**
     * 异常日志
     */
    EXCEPTION_LOG("30", "异常日志");

    /**
     * The Type.
     */
    String type;
    /**
     * The Name.
     */
    String name;

    LogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

}
