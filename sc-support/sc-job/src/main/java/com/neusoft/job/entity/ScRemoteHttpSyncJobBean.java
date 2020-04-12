package com.neusoft.job.entity;

import org.quartz.DisallowConcurrentExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>远程服务调用同步服务类</p>
 * <p>创建日期：2018-03-08</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@DisallowConcurrentExecution
public class ScRemoteHttpSyncJobBean extends ScRemoteHttpAsyncJobBean {

    /**
     * 重写父类logger
     */
    protected Logger logger = LoggerFactory.getLogger(ScRemoteHttpSyncJobBean.class);

}
