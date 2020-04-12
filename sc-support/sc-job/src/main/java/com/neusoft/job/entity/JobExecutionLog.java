package com.neusoft.job.entity;

import java.sql.Timestamp;

/**
 * <p>job运行日志实体类</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class JobExecutionLog {

    private String id;

    private String jobId;

    private String jobName;

    private String triggerName;

    private String failureCause;

    private String isSuccess;

    private Timestamp startTime;

    private Timestamp completeTime;

    private Integer returnStatusCode;

    private String remoteUrl;

    private String resultMsg;

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getFailureCause() {
        return failureCause;
    }

    public void setFailureCause(String failureCause) {
        this.failureCause = failureCause;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public Integer getReturnStatusCode() {
        return returnStatusCode;
    }

    public void setReturnStatusCode(Integer returnStatusCode) {
        this.returnStatusCode = returnStatusCode;
    }
}
