package com.neusoft.core.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>系统配置</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@ConfigurationProperties(prefix = "sc.cloud")
public class ScCloudProperties {

    private boolean dev;

    private AsyncTaskProperties task = new AsyncTaskProperties();

    private SwaggerProperties swagger = new SwaggerProperties();

    public boolean getDev() {
        return dev;
    }

    public void setDev(boolean dev) {
        this.dev = dev;
    }

    public AsyncTaskProperties getTask() {
        return task;
    }

    public void setTask(AsyncTaskProperties task) {
        this.task = task;
    }

    public SwaggerProperties getSwagger() {
        return swagger;
    }

    public void setSwagger(SwaggerProperties swagger) {
        this.swagger = swagger;
    }


}
