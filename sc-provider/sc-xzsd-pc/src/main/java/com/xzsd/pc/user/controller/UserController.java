package com.xzsd.pc.user.controller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改User
 * @Date 2020-03-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * demo 新增用户
     * @param userInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-24
     */
    @PostMapping("addUser")
    public AppResponse addUser(UserInfo userInfo){
        try{
            //获取用户编号
            String userCode = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser(userCode);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-25
     */
    @PostMapping("updateUserByCode")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userCode = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser(userCode);
            userInfo.setUpdateUser(userCode);
            return userService.updateUserByCode(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 用户列表(分页)
     * @param userInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "listUsersByPage")
    public AppResponse listUsersByPage(UserInfo userInfo) {
        try {
            return userService.listUsersByPage(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除用户
     * @param userCode
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return userService.deleteUser(userCode,userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户详情
     * @param userCode
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-25
     */
    @RequestMapping(value = "findUserByCode")
    public AppResponse findUserByCode (String userCode) {
        try{
            return userService.findUserByCode(userCode);
        }catch(Exception e) {
            logger.error("查询用户失败",e);
            System.out.println(e.toString());
            throw e;
        }

    }

    /**
     * demo 用户登录
     * @param
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-26
     */
    @RequestMapping(value = "userLogin")
    public AppResponse userLogin (String userAccount, String userPassword) {

        try {
            return userService.userLogin(userAccount,userPassword);
        }catch (Exception e) {
            logger.error("用户登录失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
