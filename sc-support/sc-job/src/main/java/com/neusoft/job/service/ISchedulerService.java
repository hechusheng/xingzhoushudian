package com.neusoft.job.service;

import com.neusoft.job.entity.JobExecutionLog;
import com.neusoft.job.entity.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * <p>定时任务服务接口</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface ISchedulerService {

    /**
     * 获取定时任务列表
     *
     * @param jobName 查询条件，任务名称
     * @return 定时任务列表
     */
    List<ScheduleJob> listJobs(String jobName);

    /**
     * 新增任务
     *
     * @param scheduleJob 任务信息实体
     * @return 操作结果，true：添加成功，false：任务已经存在
     */
    boolean saveJob(ScheduleJob scheduleJob);

    /**
     * 暂停任务
     *
     * @param jobName 任务名称
     * @return 操作结果，true：暂停成功，false：任务不存在
     * @throws SchedulerException 任务暂停异常
     */
    boolean pauseJob(String jobName) throws SchedulerException;

    /**
     * 恢复任务
     *
     * @param jobName 任务名称
     * @return 操作结果，true：恢复成功，false：任务不存在
     * @throws SchedulerException 任务恢复异常
     */
    boolean resumeJob(String jobName) throws SchedulerException;

    /**
     * 删除任务
     *
     * @param jobName 任务名称
     * @return 操作结果，true：删除成功，false：任务不存在
     * @throws SchedulerException 任务删除异常
     */
    boolean removeJob(String jobName) throws SchedulerException;

    /**
     * 修改任务运行时间
     *
     * @param jobName        任务名称
     * @param cronExpression cron表达式
     * @return 操作结果，true：修改任务运行时间，false：任务不存在
     * @throws SchedulerException 任务运行时间异常
     */
    boolean updateCronExpression(String jobName, String cronExpression) throws SchedulerException;

    /**
     * 立即执行任务
     *
     * @param jobName 任务名称
     * @return 操作结果，true：执行成功，false：任务不存在
     * @throws SchedulerException 任务立即触发异常
     */
    boolean runOnce(String jobName) throws SchedulerException;

    /**
     * 获取任务的执行日志
     *
     * @return 执行日志
     */
    List<JobExecutionLog>  listJobExecutionLog();
}
