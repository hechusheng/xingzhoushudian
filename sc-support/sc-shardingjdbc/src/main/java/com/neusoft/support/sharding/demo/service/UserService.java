package com.neusoft.support.sharding.demo.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.support.sharding.demo.dao.UserDao;
import com.neusoft.support.sharding.demo.entity.UserInfo;
import com.neusoft.support.sharding.utils.PasswordUtils;
import com.neusoft.util.StringUtil;
import com.neusoft.util.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName UserService
 * @Description 用户管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;


    /**
     * 部门：南京软件研发中心
     * 功能：新增用户
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/3
     */

    @Transactional(rollbackFor = Exception.class)
    public AppResponse saveUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("新增成功！");

        // 密码加密 默认为123456
        String pwd = PasswordUtils.generatePassword("123456");
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setUserPwd(pwd);
        userInfo.setDelFlag(0);
        userInfo.setUuid(UUIDUtils.getUUID());
        // 新增用户
        int count = userDao.saveUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        // 新增用户部门
        return appResponse;
    }




    /**
     * 通过用户代码查找用户
     *
     * @param userCode 用户代码
     * @return 用户信息
     */
    public UserInfo getUserById(String userCode) {
        return userDao.getUserById(userCode);
    }


    /**
     * 部门：南京软件研发中心
     * 功能：获取用户列表
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/29
     */
    public AppResponse listUsers(UserInfo userInfo) {
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        if(CollectionUtils.isEmpty(userInfoList)) {
            return AppResponse.notFound();
        }

        return AppResponse.success("查询成功！", getPageInfo(userInfoList));
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改用户信息
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/8/3
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");

        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }



}
