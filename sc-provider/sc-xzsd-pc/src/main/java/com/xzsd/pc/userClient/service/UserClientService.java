package com.xzsd.pc.userClient.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.userClient.dao.UserClientDao;
import com.xzsd.pc.userClient.entity.UserClientInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-30
 */
@Service
public class UserClientService {
    @Resource
    private UserClientDao userClientDao;

    /**
     * 查询客户列表
     * @param userClientInfo
     * @return
     */
    public AppResponse listUserClient(UserClientInfo userClientInfo) {
        //查询客户
        List<UserClientInfo> userClientInfos = userClientDao.listUserClientByPage(userClientInfo);
        return AppResponse.success("查询客户成功",userClientInfos);
    }
}
