package com.neusoft.job.listener;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScSchedulerListener implements SchedulerListener {

    private static final Logger logger = LoggerFactory.getLogger(ScSchedulerListener.class);

    @Override
    public void jobScheduled(Trigger trigger) {
        logger.info("job调度完成,jobKey为 {}",trigger.getJobKey());
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {

    }

    @Override
    public void triggerFinalized(Trigger trigger) {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String triggerGroup) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String triggerGroup) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {

    }

    @Override
    public void jobDeleted(JobKey jobKey) {

    }

    @Override
    public void jobPaused(JobKey jobKey) {

    }

    @Override
    public void jobsPaused(String jobGroup) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {

    }

    @Override
    public void jobsResumed(String jobGroup) {

    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {

    }

    @Override
    public void schedulerInStandbyMode() {
        logger.info("------定时任务以单点模式运行------");
    }

    @Override
    public void schedulerStarted() {
        logger.info("------调度器启动完成------");
    }

    @Override
    public void schedulerStarting() {
        logger.info("------调度器正在启动------");

    }

    @Override
    public void schedulerShutdown() {
        logger.info("------调度器停止完成------");
    }

    @Override
    public void schedulerShuttingdown() {
        logger.info("------调度器正在停止------");

    }

    @Override
    public void schedulingDataCleared() {
        logger.info("------调度器数据清除完成------");
    }

}
