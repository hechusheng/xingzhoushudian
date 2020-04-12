package com.neusoft.web.hello.service;

import com.neusoft.service.api.helloservice.service.HelloServiceRemoteApi;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * <p>测试远程服务调用接口</p>
 * <p>创建日期：2018-01-10</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@FeignClient(value = "sc-service")
public interface HelloBackgroundService extends HelloServiceRemoteApi {
}
