package com.xzsd.pc.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-24
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * demo 新增用户
     * @param userInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //校验账号是否存在
        int countUserAccount = userDao.countUserAccount(userInfo);
        if(0 != countUserAccount){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setIsDelete(0);
       //新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return
     * @author hechusheng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserByCode(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countUserAcctount = userDao.countUserAccount(userInfo);
        if(countUserAcctount != 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        int count = userDao.updateUserByCode(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    public AppResponse listUsersByPage(UserInfo userInfo) {
       // PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        // 包装Page对象
       // PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！",userInfoList);
    }
    /**
     * demo 删除用户
     * @param userCode
     * @param userId
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = userDao.deleteUser(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询用户详情
     * @param userCode
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    public AppResponse findUserByCode (String userCode) {
        UserInfo userInfo = userDao.findUserByCode(userCode);
        return AppResponse.success("查询成功",userInfo);
    }

    /**
     * demo 用户登录
     * @param
     * @return
     * @Author hechusheng
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse userLogin(String userAccount,String userPassword) {
        //查询登录用户信息
        UserInfo userInfo = userDao.userLogin(userAccount,userPassword);
        return AppResponse.success("查询成功",userInfo);
    }
}
