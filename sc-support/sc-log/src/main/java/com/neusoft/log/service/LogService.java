package com.neusoft.log.service;

import com.neusoft.log.dao.LogDao;
import com.neusoft.log.entity.LogEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>log服务类</p>
 * <p>创建日期：2018-03-16</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service
public class LogService {

    @Resource
    private LogDao logDao;

    /**
     * 保存日志内容
     *
     * @param logInfo 日志内容
     */
    public void saveLogInfo(List<LogEntity> logInfo) {
        logDao.save(logInfo);
    }
}
