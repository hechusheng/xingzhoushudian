package com.neusoft.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>验证码属性</p>
 * <p>创建日期：2018-04-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ImageProperties {

    /**
     * 是否开启验证码
     */
    private Boolean enabled;

    /**
     * 高度
     */
    private Integer height;

    /**
     * 宽度
     */
    private Integer width;

    /**
     * 验证码长度
     */
    private Integer count;

    /**
     * 验证码超时时间
     */
    private Integer expireIn;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }
}
