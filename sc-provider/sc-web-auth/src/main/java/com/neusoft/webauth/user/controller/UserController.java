package com.neusoft.webauth.user.controller;

import com.neusoft.core.exception.ScServerException;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.webauth.user.entity.UserInfo;
import com.neusoft.webauth.user.entity.UserSettingDTO;
import com.neusoft.webauth.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserController
 * @Description 用户管理
 * @Author zhu.qf@neusoft.com
 * @Date 2018/11/28
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 部门：南京软件研发中心
     * 功能：新增用户
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/26 10:58
     */
//    @SystemLog1(operation = "新增用户信息测试操作。。。。。")
    @PostMapping("saveUser")
    public AppResponse saveUser(@Valid UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            AppResponse appResponse = userService.saveUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户注册失败", e);
            throw new ScServerException(e);
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：获取用户列表
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/29
     */
//    @SystemLog1(operation = "获取用户列表。。。。。")
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("用户获取异常", e);
            throw new ScServerException("查询错误，请重试");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：删除用户信息
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/30
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(UserSettingDTO userSettingDTO) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userSettingDTO.setLastModifiedBy(userId);
            return userService.deleteUser(userSettingDTO);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            throw new ScServerException("用户删除错误");
        }
    }
    /**
     * 部门：南京软件研发中心
     * 功能：修改密码
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/30
     */
    @PostMapping("updatePwd")
    public AppResponse updatePwd(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setLastModifiedBy(userId);
            return userService.updatePwd(userInfo);
        } catch (Exception e) {
            logger.error("修改异常", e);
            throw new ScServerException("修改密码失败，请重试");
        }
    }

    /**
     * 部门：南京软件研发中心
     * 功能：修改用户 TODO
     * 描述：略
     * 作成者：朱庆锋
     * 作成时间：2018/11/30
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(@Valid UserInfo userInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateBy(userId);
            userInfo.setLastModifiedBy(userId);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            throw new ScServerException("系统错误，请重试");
        }
    }


    /**
     * 根据用户代码获取用户信息
     *
     * @param userCode 用户代码
     * @return 用户信息
     */
    @RequestMapping(value = "getUserByUserCode")
    public AppResponse getUserByUserCode(@NotNull(message = "用户代码不能为空") String userCode) {

        UserInfo userInfo = null;
        try {
            userInfo = userService.getUserById(userCode);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            throw new ScServerException("查询错误，请重试");
        }
        if (userInfo == null) {
            return AppResponse.notFound("无查询结果");
        }

        return AppResponse.success("查询成功", userInfo);
    }
}
