package com.neusoft.job.service;

import com.neusoft.job.dao.JobDao;
import com.neusoft.job.entity.JobExecutionLog;
import com.neusoft.job.entity.ScheduleJob;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>定时任务service.</p>
 * <p>创建日期：2018-03-19</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service
public class JobService {

    @Resource
    private JobDao jobDao;


    /**
     * 根据jobId获取任务信息
     *
     * @param jobId 任务id
     * @return
     */
    public ScheduleJob getScheduleJobById(String jobId) {
        return jobDao.getScheduleJobById(jobId);
    }

    /**
     * 获取任务集合
     *
     * @param jobName 查询条件，任务名称
     * @return
     */
    public List<ScheduleJob> listScheduleJobByPage(String jobName) {
        return jobDao.listScheduleJob(jobName);
    }

    /**
     * 保存任务信息
     *
     * @param scheduleJob 任务信息
     * @return 任务id
     */
    public String saveScheduleJob(ScheduleJob scheduleJob) {
        jobDao.saveScheduleJob(scheduleJob);
        //如果附加参数不为空，保存
        if (MapUtils.isNotEmpty(scheduleJob.getParams())) {
            jobDao.saveScheduleJobParams(scheduleJob.getId(), scheduleJob.getParams());
        }
        return scheduleJob.getId();
    }

    /**
     * 根据任务id删除任务
     *
     * @param jobId 任务id
     */
    public void deleteScheduleJob(String jobId) {
        jobDao.deleteScheduleJob(jobId);
    }


    /**
     * 更新任务状态
     *
     * @param jobId  任务id
     * @param status 任务状态
     */
    public void updateJobStatus(String jobId, String status) {
        jobDao.updateJobStatus(jobId, status);
    }

    /**
     * 保存任务执行日志
     *
     * @param jobExecutionLog 日志信息
     */
    public void saveJobExecutionLog(JobExecutionLog jobExecutionLog) {
        jobDao.saveJobExecutionLog(jobExecutionLog);
    }

    /**
     * 更新任务执行信息
     *
     * @param jobExecutionLog 日志信息
     */
    public void updateJobExecutionLog(JobExecutionLog jobExecutionLog) {
        jobDao.updateJobExecutionLog(jobExecutionLog);
    }

    /**
     * 更新任务cron表达式
     *
     * @param jobId          任务id
     * @param cronExpression cron表达式
     */
    public void updateJobCronExpression(String jobId, String cronExpression) {
        jobDao.updateJobCronExpression(jobId, cronExpression);
    }

    public List<JobExecutionLog> listJobExecutionLogByPage() {
        return jobDao.listJobExecutionLog();
    }
}
