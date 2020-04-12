package com.neusoft.log.dao;

import com.neusoft.log.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>日志持久化类</p>
 * <p>创建日期：2018-03-16</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface LogDao extends JpaRepository<LogEntity, Long> {
}
