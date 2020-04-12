package com.neusoft.job.service.impl;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.job.entity.JobExecutionLog;
import com.neusoft.job.entity.ScRemoteHttpAsyncJobBean;
import com.neusoft.job.entity.ScRemoteHttpSyncJobBean;
import com.neusoft.job.entity.ScheduleJob;
import com.neusoft.job.service.ISchedulerService;
import com.neusoft.job.service.JobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * <p>定时任务服务实现类</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service("schedulerServiceImpl")
public class SchedulerServiceImpl implements ISchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerServiceImpl.class);

    @Resource
    private Scheduler scheduler;

    @Resource
    private JobService jobService;

    @Override
    public List<ScheduleJob> listJobs(String jobName) {

        return jobService.listScheduleJobByPage(jobName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveJob(ScheduleJob scheduleJob) throws ScServerException {

        //校验任务是否存在
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        try {
            boolean flag = scheduler.checkExists(jobKey);
            if (flag) {
                return false;
            }
        } catch (SchedulerException e) {
            logger.error("校验任务是否存在失败", e);
            throw new ScServerException("校验任务是否存在失败");
        }

        //设置传递的参数
        JobDataMap jobDataMap = new JobDataMap(scheduleJob.getParams() != null ? scheduleJob.getParams() : new HashMap<>(1));

        //该任务是否为同步任务
        Class<? extends QuartzJobBean> clazz = scheduleJob.getSync() ? ScRemoteHttpSyncJobBean.class : ScRemoteHttpAsyncJobBean.class;




        //表达式调度构建器
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCron()).withMisfireHandlingInstructionDoNothing();

        //创建调度器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(scheduleJob.getJobName())
                .withSchedule(scheduleBuilder)
                .build();
        String jobId = null;
        //保存定时任务
        try {
            jobId = jobService.saveScheduleJob(scheduleJob);
            jobDataMap.put("jobId", jobId);
        } catch (Exception e) {
            logger.error("定时任务保存数据库失败", e);
            throw new ScServerException("定时任务添加失败");
        }

        try {
            //创建任务
            JobDetail jobDetail = JobBuilder.newJob(clazz)
                    .withIdentity(scheduleJob.getJobName())
                    .withDescription(scheduleJob.getDescription())
                    .setJobData(jobDataMap)
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            logger.error("定时任务添加失败", e);
            throw new ScServerException("定时任务添加失败");
        }

        return true;
    }

    @Override
    public boolean pauseJob(String jobId) throws SchedulerException {

        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);

        if (scheduleJob == null) {
            return false;
        }
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        boolean flag = scheduler.checkExists(jobKey);
        if (flag) {
            scheduler.pauseJob(jobKey);
            //更新数据库中任务的状态
            jobService.updateJobStatus(jobId, "2");
        }
        return flag;
    }

    @Override
    public boolean resumeJob(String jobId) throws SchedulerException {

        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);
        if (scheduleJob == null) {
            return false;
        }
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        boolean flag = scheduler.checkExists(jobKey);
        if (flag) {
            scheduler.resumeJob(jobKey);
            //更新数据库中任务的状态
            jobService.updateJobStatus(jobId, "1");
        }
        return flag;
    }

    @Override
    public boolean removeJob(String jobId) throws SchedulerException {
        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);
        if (scheduleJob == null) {
            return false;
        }
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        boolean flag = scheduler.checkExists(jobKey);
        if (flag) {
            scheduler.deleteJob(jobKey);
            //删除任务信息
            jobService.deleteScheduleJob(jobId);
        }
        return flag;
    }

    @Override
    public boolean updateCronExpression(String jobId, String cronExpression) throws SchedulerException {
        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);
        if (scheduleJob == null) {
            return false;
        }
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        TriggerKey triggerKey = new TriggerKey(scheduleJob.getJobName());
        //判断jobDetail和trigger是否同时存在
        boolean flag = scheduler.checkExists(jobKey) && scheduler.checkExists(triggerKey);

        if (flag) {

            Trigger trigger = scheduler.getTrigger(triggerKey);
            if (trigger instanceof CronTrigger) {
                //表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).withMisfireHandlingInstructionDoNothing();

                //创建调度器
                Trigger newTrigger = TriggerBuilder.newTrigger()
                        .withIdentity(scheduleJob.getJobName())
                        .withSchedule(scheduleBuilder)
                        .build();

                scheduler.rescheduleJob(triggerKey, newTrigger);
                jobService.updateJobCronExpression(jobId, cronExpression);
            }
        }
        return flag;
    }

    @Override
    public boolean runOnce(String jobId) throws SchedulerException {
        ScheduleJob scheduleJob = jobService.getScheduleJobById(jobId);
        if (scheduleJob == null) {
            return false;
        }
        JobKey jobKey = new JobKey(scheduleJob.getJobName());
        boolean flag = scheduler.checkExists(jobKey);
        if (flag) {
            scheduler.triggerJob(jobKey);
        }
        return flag;
    }

    @Override
    public List<JobExecutionLog> listJobExecutionLog() {
        return jobService.listJobExecutionLogByPage();
    }

}
