package com.xzsd.pc.userClient.dao;

import com.xzsd.pc.userClient.entity.UserClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserClientDao {
    /**
     * 客户列表查询
     * @param userClientInfo
     * @return
     */
    List<UserClientInfo> listUserClientByPage (UserClientInfo userClientInfo);
}
