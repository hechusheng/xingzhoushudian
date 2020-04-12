package com.neusoft.oauth.service;

import com.neusoft.oauth.entity.UaaLog;
import com.neusoft.oauth.enums.LogTypeEnum;
import com.neusoft.security.core.entity.SecurityUser;
import com.neusoft.util.request.RequestUtils;
import nl.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.concurrent.Executor;

/**
 * <p>用户相关服务类¬</p>
 * <p>创建日期：2018-04-27</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Service
public class UaaUserService {

    private static final Logger logger = LoggerFactory.getLogger(UaaUserService.class);

    @Resource(name = "taskExecutor")
    private Executor executor;

    @Resource
    private UacLogService uacLogService;

    public void handlerLoginData(OAuth2AccessToken token, final SecurityUser principal, HttpServletRequest request) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取客户端操作系统
        final String os = userAgent.getOperatingSystem().getName();
        //获取客户端浏览器
        final String browser = userAgent.getBrowser().getName();
        //获取请求ip
        final String remoteAddr = RequestUtils.getRemoteAddr(request);

        UaaLog log = new UaaLog();
        log.setBrowser(browser);
        log.setOs(os);
        log.setRequestUrl(request.getRequestURI());
        log.setIp(remoteAddr);
        log.setLogType(LogTypeEnum.LOGIN_LOG.getType());
        log.setLogName(LogTypeEnum.LOGIN_LOG.getName());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        log.setGmtCreate(now);
        log.setGmtModified(now);
        log.setCreatorId(principal.getId());
        log.setCreator(principal.getUsername());
        log.setLastOperatorId(principal.getId());
        log.setLastOperator(principal.getUsername());

        executor.execute(() -> {
            //保存
            uacLogService.saveLog(log);
            logger.info("保存登录日志成功 {}", log);

        });
    }

}
