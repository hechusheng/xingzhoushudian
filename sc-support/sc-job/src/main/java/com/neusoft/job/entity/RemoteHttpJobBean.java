package com.neusoft.job.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * <p>任务参数实体类</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@ApiModel
public class RemoteHttpJobBean {

    /**
     * job名称
     */
    @NotNull(message = "任务名称不能为空")
    @ApiModelProperty(value = "任务名称",required = true)
    private String jobName;

    /**
     * cron表达式
     */
    @ApiModelProperty(value = "cron表达式",required = true)
    @NotNull(message = "cron表达式不能为空")
    private String cron;

    /**
     * job描述
     */
    @ApiModelProperty("job描述")
    private String description;

    /**
     * 是否同步
     */
    private boolean isSync = true;

    /**
     * 远程serviceId
     */
    @ApiModelProperty(value = "远程serviceId",required = true)
    @NotNull(message = "serviceId不能为空")
    private String serviceId;

    /**
     * 远程服务url
     */
    @ApiModelProperty(value = "远程服务url",required = true)
    @NotNull(message = "远程服务url不能为空")
    private String url;

    /**
     * 远程调用参数
     */
    @ApiModelProperty(value = "远程调用参数")
    private Map<String, String> params;

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
