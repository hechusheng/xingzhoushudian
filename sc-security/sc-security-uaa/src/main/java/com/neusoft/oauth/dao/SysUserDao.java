package com.neusoft.oauth.dao;

import com.neusoft.oauth.entity.SysUser;
import org.springframework.data.repository.query.Param;

/**
 * <p>用户查询数据库接口</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public interface SysUserDao {

    /**
     * 根据用户名称获取用户信息
     *
     * @param username 用户名称
     * @return 用户信息
     */
    SysUser getUserInfoByUsername(@Param("username") String username);

}
