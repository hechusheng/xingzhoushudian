package com.neusoft.job.dao;

import com.neusoft.job.entity.JobExecutionLog;
import com.neusoft.job.entity.ScheduleJob;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>job执行日志dao接口</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface JobDao {

    /**
     * 获取任务集合
     *
     * @param jobName 查询条件，任务名称
     * @return 任务集合
     */
    List<ScheduleJob> listScheduleJob(@Param("jobName") String jobName);


    /**
     * 根据任务id获取任务详情
     *
     * @param jobId 任务id
     * @return 任务详情
     */
    ScheduleJob getScheduleJobById(@Param("jobId") String jobId);

    /**
     * 保存定时任务
     *
     * @param scheduleJob 定时任务参数
     */
    void saveScheduleJob(ScheduleJob scheduleJob);

    /**
     * 保存定时任务的附加参数
     *
     * @param jobId  定时任务id
     * @param params 附加参数
     */
    void saveScheduleJobParams(@Param("jobId") String jobId, @Param("params") Map<String, String> params);

    /**
     * 删除定时任务
     *
     * @param jobId 任务id
     */
    void deleteScheduleJob(@Param("jobId") String jobId);

    /**
     * 根据任务id修改任务状态
     *
     * @param jobId  任务id
     * @param status 任务状态
     */
    void updateJobStatus(@Param("jobId") String jobId, @Param("status") String status);

    /**
     * 保存任务执行日志
     *
     * @param jobExecutionLog 任务日志参数
     */
    void saveJobExecutionLog(JobExecutionLog jobExecutionLog);

    /**
     * 更新日志信息
     *
     * @param jobExecutionLog 日志信息
     */
    void updateJobExecutionLog(JobExecutionLog jobExecutionLog);

    /**
     * 修改任务cron表达式
     *
     * @param jobId          任务id
     * @param cronExpression cron表达式
     */
    void updateJobCronExpression(@Param("jobId") String jobId, @Param("cronExpression") String cronExpression);

    /**
     * 获取任务执行日志
     * @return 任务执行日志
     */
    List<JobExecutionLog> listJobExecutionLog();
}
