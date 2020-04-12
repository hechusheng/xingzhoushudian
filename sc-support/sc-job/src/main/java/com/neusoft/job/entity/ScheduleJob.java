package com.neusoft.job.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;
import java.util.Map;

/**
 * <p>任务信息实体类.</p>
 * <p>创建日期：2016-12-22</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScheduleJob {


    private String id;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组
     */
    @JsonIgnore
    private String jobGroup;

    /**
     * 任务状态,1:运行,2:暂停
     */
    private String status;

    /**
     * 任务运行时间表达式
     */
    private String cron;

    /**
     * 是否同步
     */
    private Boolean isSync;

    /**
     * 任务描述
     */
    private String description;

    /**
     * 服务id
     */
    private String serviceId;

    /**
     * 定时任务地址url
     */
    private String url;


    private Timestamp gmtCreate;

    /**
     * 任务参数
     */
    @JsonIgnore
    private Map<String, String> params;

    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Boolean getSync() {
        return isSync;
    }

    public void setSync(Boolean sync) {
        isSync = sync;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
