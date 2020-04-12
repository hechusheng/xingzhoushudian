package com.neusoft.oauth.dao;

import com.neusoft.oauth.entity.UaaLog;

/**
 * <p>日志相关dao</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface UacLogDao {

    /**
     * 保存log
     *
     * @param uaaLog log信息
     * @return 保存结果
     */
    int saveLog(UaaLog uaaLog);

}
