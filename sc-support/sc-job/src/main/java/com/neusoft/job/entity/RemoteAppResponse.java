package com.neusoft.job.entity;

import java.io.Serializable;

/**
 * <p>定时任务应答结果</p>
 * <p>创建日期：2018-03-14</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class RemoteAppResponse<T> implements Serializable {

    /**
     * 返回编码
     */
    private int code;
    /**
     * 消息描述
     */
    private String msg;
    /**
     * 返回内容
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
