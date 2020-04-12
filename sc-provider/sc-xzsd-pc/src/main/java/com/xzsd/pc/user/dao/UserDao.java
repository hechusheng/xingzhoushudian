package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description Demo
 * @Author hechusheng
 * @Date 2020-03-24
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAccount(UserInfo userInfo);

    /**
     * 新增用户
     * @param userInfo 用户信息
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 修改用户
     * @param userInfo 用户信息
     * @return 修改结果
     */
    int updateUserByCode(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return 用户信息
     */
    UserInfo findUserByCode(@Param("userCode") String userCode);

    /**
     * 用户登录
     * @param userAccount
     * @param userPassword
     * @return
     */
    UserInfo userLogin(@Param("userAccount") String userAccount, @Param("userPassword") String userPassword);


}
