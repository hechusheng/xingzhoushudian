package com.neusoft.job.entity;

import com.neusoft.job.service.JobService;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Map;

/**
 * <p>远程服务调用异步服务类</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class ScRemoteHttpAsyncJobBean extends QuartzJobBean {

    protected Logger logger = LoggerFactory.getLogger(ScRemoteHttpAsyncJobBean.class);

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private JobService jobService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        JobKey jobKey = context.getJobDetail().getKey();
        Trigger trigger = context.getTrigger();

        //开始执行任务
        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String jobId = jobDataMap.getString("jobId");

        if (StringUtils.isEmpty(jobId)) {
            logger.error("jobId为空");
            return;
        }
        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);
        if (scheduleJob == null) {
            logger.error("jobId为 {} 的任务信息为空", jobId);
            return;
        }

        String remoteUrl = StringUtils.join("http://", scheduleJob.getServiceId(), "/", scheduleJob.getUrl());

        //保存任务日志
        JobExecutionLog jobExecutionLog = new JobExecutionLog();
        jobExecutionLog.setJobId(scheduleJob.getId());
        jobExecutionLog.setJobName(jobKey.getName());
        jobExecutionLog.setTriggerName(trigger.getKey().getName());
        jobExecutionLog.setStartTime(new Timestamp(System.currentTimeMillis()));
        jobExecutionLog.setIsSuccess("0");
        jobExecutionLog.setRemoteUrl(remoteUrl);
        jobService.saveJobExecutionLog(jobExecutionLog);

        HttpHeaders headers = new HttpHeaders();
        //  请勿轻易改变此提交方式，大部分的情况下，提交方式都是表单提交
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        if (MapUtils.isNotEmpty(scheduleJob.getParams())) {
            for (Map.Entry<String, String> entry : scheduleJob.getParams().entrySet()) {
                params.add(entry.getKey(), entry.getValue());
            }
        }

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);

        //开始执行任务
        try {
            ResponseEntity<String> responseBody = restTemplate.postForEntity(remoteUrl, requestEntity, String.class);
            String appResponse = responseBody.getBody();
            //保存返回内容
            if (HttpStatus.OK == responseBody.getStatusCode()) {
                //保存成功的返回消息
                jobExecutionLog.setResultMsg(appResponse);
                jobExecutionLog.setIsSuccess("1");
                jobExecutionLog.setResultMsg(appResponse);
            } else {
                jobExecutionLog.setIsSuccess("-1");
                //如果返回码不为200，说明http请求错误，将返回的body保存到失败原因
                jobExecutionLog.setFailureCause(appResponse);
            }
        } catch (Exception e) {
            //更新任务执行日志
            logger.error("远程调用失败", e);
            jobExecutionLog.setIsSuccess("-1");
            jobExecutionLog.setFailureCause(e.getMessage());
        } finally {
            jobExecutionLog.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            jobService.updateJobExecutionLog(jobExecutionLog);
        }
    }

}
