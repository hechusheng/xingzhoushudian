package com.neusoft.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.neusoft.core.restful.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * <p>限流控制器</p>
 * <p>创建日期：2018-01-18</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Configuration
public class RequestLimitFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestLimitFilter.class);

    /**
     * 限流请求等待时间
     */
    public static final int WAIT_TIME = 5;

    @Value("${request.limit.max-connections}")
    private Integer maxConn;

    @Value("${request.limit.enabled}")
    private Boolean limitEnabled;

    /**
     * 令牌桶算法，每秒允许最大并发限制
     */
    private RateLimiter limiter;

    private static final String SERVERS_ARE_TOO_BUSY;

    static {
        SERVERS_ARE_TOO_BUSY = AppResponse.serversAreTooBusy("server Are Too Busy").toJson();
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //是否开启限流控制
        return limitEnabled != null && limitEnabled;
    }

    @PostConstruct
    public void init() {
        if (maxConn != null && maxConn > 0) {
            limiter = RateLimiter.create(maxConn);
        }
    }

    @Override
    public Object run() {
        if (limiter != null) {
            if (!limiter.tryAcquire(WAIT_TIME, TimeUnit.SECONDS)) {
                RequestContext requestContext = RequestContext.getCurrentContext();
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.OK.value());
                requestContext.setResponseBody(SERVERS_ARE_TOO_BUSY);
                return null;
            }
        }
        return null;
    }
}
