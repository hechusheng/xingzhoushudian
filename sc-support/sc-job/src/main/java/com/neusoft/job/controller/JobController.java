package com.neusoft.job.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.page.PageUtils;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.job.entity.JobExecutionLog;
import com.neusoft.job.entity.RemoteHttpJobBean;
import com.neusoft.job.entity.ScheduleJob;
import com.neusoft.job.service.ISchedulerService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>定时任务接口</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@RestController
@RequestMapping()
@Validated
@Api(value = "定时任务接口", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
public class JobController {

    private static final Logger logger = LoggerFactory.getLogger(JobController.class);

    @Resource(name = "schedulerServiceImpl")
    private ISchedulerService iSchedulerService;

    @ApiOperation("获取定时任务列表")
    @ApiImplicitParam(value = "任务名称，模糊查询使用", name = "jobName", paramType = "query")
    @GetMapping(value = "listJobs", produces = MediaType.APPLICATION_JSON)
    public AppResponse listJobs(String jobName) {
        try {
            List<ScheduleJob> list = iSchedulerService.listJobs(jobName);
            return AppResponse.success("任务列表获取成功", PageUtils.getPageInfo(list));

        } catch (Exception e) {
            logger.error("任务列表获取失败", e);
            throw new ScServerException("任务列表获取失败");
        }
    }

    /**
     * 添加定时任务
     *
     * @param params 任务参数
     * @return 操作结果
     */
    @ApiOperation("添加定时任务")
    @PostMapping(value = "addJob", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
    public AppResponse addJob(@Validated RemoteHttpJobBean params) {

        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobName(params.getJobName());
        scheduleJob.setDescription(params.getDescription());
        scheduleJob.setCron(params.getCron());
        scheduleJob.setSync(params.isSync());
        scheduleJob.setServiceId(params.getServiceId());
        scheduleJob.setUrl(params.getUrl());
        //设置任务的运行状态
        scheduleJob.setStatus("1");
        scheduleJob.setGmtCreate(new Timestamp(System.currentTimeMillis()));

        //设置任务附加参数
        scheduleJob.setParams(params.getParams());

        //添加定时任务
        boolean result = iSchedulerService.saveJob(scheduleJob);
        return result ? AppResponse.success("定时任务添加成功") : AppResponse.bizError("该任务已经存在");

    }

    /**
     * 暂停任务
     *
     * @param jobId 任务id
     * @return 操作结果
     */
    @ApiOperation("暂停任务")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "任务id", name = "jobId", paramType = "query", required = true)
    })
    @GetMapping(value = "pauseJob", produces = MediaType.APPLICATION_JSON)
    public AppResponse pauseJob(@NotNull(message = "任务id不能为空") String jobId) {
        try {

            boolean result = iSchedulerService.pauseJob(jobId);

            return result ? AppResponse.success("暂停任务成功") : AppResponse.bizError("任务不存在");
        } catch (Exception e) {
            logger.error("暂停任务错误", e);
            throw new ScServerException("暂停任务错误");
        }
    }

    /**
     * 恢复任务
     *
     * @param jobId 任务id
     * @return 操作结果
     */
    @ApiOperation("恢复任务")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "任务id", name = "jobId", paramType = "query", required = true)
    })
    @GetMapping(value = "resumeJob", produces = MediaType.APPLICATION_JSON)
    public AppResponse resumeJob(@NotNull(message = "任务id不能为空") String jobId) {
        try {

            boolean result = iSchedulerService.resumeJob(jobId);

            return result ? AppResponse.success("恢复任务成功") : AppResponse.bizError("任务不存在");
        } catch (Exception e) {
            logger.error("恢复任务错误", e);
            throw new ScServerException("恢复任务错误");
        }
    }

    /**
     * 删除任务
     *
     * @param jobId 任务id
     * @return 操作结果
     */
    @ApiOperation("删除任务")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "任务id", name = "jobId", paramType = "query", required = true)
    })
    @GetMapping(value = "removeJob", produces = MediaType.APPLICATION_JSON)
    public AppResponse removeJob(@NotNull(message = "任务id不能为空") String jobId) {
        try {

            boolean result = iSchedulerService.removeJob(jobId);

            return result ? AppResponse.success("删除任务成功") : AppResponse.bizError("任务不存在");
        } catch (Exception e) {
            logger.error("删除任务错误", e);
            throw new ScServerException("删除任务错误");
        }
    }

    /**
     * 修改cron表达式
     *
     * @param jobId 任务id
     * @param cron  cron表达式
     * @return 操作结果
     */
    @ApiOperation("修改cron表达式")
    @PostMapping(value = "updateCron", consumes = MediaType.APPLICATION_FORM_URLENCODED, produces = MediaType.APPLICATION_JSON)
    public AppResponse updateCron(@NotNull(message = "任务id不能为空") @ApiParam(value = "任务id", required = true) String jobId,
                                  @NotNull(message = "cron表达式不能为空") @ApiParam(value = "cron表达式", required = true) String cron) {
        try {

            boolean result = iSchedulerService.updateCronExpression(jobId, cron);

            return result ? AppResponse.success("修改cron表达式成功") : AppResponse.bizError("任务不存在");
        } catch (Exception e) {
            logger.error("修改cron表达式错误", e);
            throw new ScServerException("修改cron表达式错误");
        }
    }

    /**
     * 任务立即执行一次
     *
     * @param jobId 任务id
     * @return 操作结果
     */
    @ApiOperation("任务立即执行一次")
    @ApiImplicitParam(value = "任务id", paramType = "query", name = "jobId")
    @GetMapping(value = "runOnce", produces = MediaType.APPLICATION_JSON)
    public AppResponse runOnce(@NotNull(message = "任务名称不能为空") String jobId) {
        try {

            boolean result = iSchedulerService.runOnce(jobId);

            return result ? AppResponse.success("任务执行成功") : AppResponse.bizError("任务不存在");
        } catch (Exception e) {
            logger.error("任务立即执行错误", e);
            throw new ScServerException("任务立即执行错误");
        }
    }


    /**
     * 获取任务的执行日志
     *
     * @return 执行日志
     */
    @ApiOperation("获取任务的执行日志")
    @GetMapping(value = "listJobExecutionLog", produces = MediaType.APPLICATION_JSON)
    public AppResponse listJobExecutionLog() {
        try {
            List<JobExecutionLog> jobExecutionLogs = iSchedulerService.listJobExecutionLog();
            return AppResponse.success("获取任务的执行日志成功", PageUtils.getPageInfo(jobExecutionLogs));
        } catch (Exception e) {
            logger.error("获取任务执行日志错误", e);
            throw new ScServerException("获取任务执行日志错误");
        }
    }

}
