package com.xzsd.pc.userClient.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.userClient.entity.UserClientInfo;
import com.xzsd.pc.userClient.service.UserClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改User
 * @Date 2020-03-30
 */

@RestController
@RequestMapping("/userClient")
public class UserClientController {

    private static final Logger logger = LoggerFactory.getLogger(UserClientController.class);

    @Resource
    private UserClientService userClientService;


    /**
     * demo 客户列表(分页)
     * @param userClientInfo
     * @return AppResponse
     * @author hechusheng
     * @Date 2020-03-30
     */
    @RequestMapping(value = "listUserClientByPage")
    public AppResponse listUserClientByPage(UserClientInfo userClientInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            userClientInfo.setUserId(userId);
            return userClientService.listUserClient(userClientInfo);
        } catch (Exception e) {
            logger.error("查询客户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
