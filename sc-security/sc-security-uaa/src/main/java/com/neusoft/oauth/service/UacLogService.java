package com.neusoft.oauth.service;

import com.neusoft.oauth.dao.UacLogDao;
import com.neusoft.oauth.entity.UaaLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>系统日志service</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service
public class UacLogService {

    @Resource
    private UacLogDao uacLogDao;

    /**
     * 保存日志
     *
     * @param uaaLog 日志信息
     * @return 保存结果
     */
    public int saveLog(UaaLog uaaLog) {
        return uacLogDao.saveLog(uaaLog);
    }
}
