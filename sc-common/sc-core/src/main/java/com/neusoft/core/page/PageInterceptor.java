package com.neusoft.core.page;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>分页拦截器</p>
 * <p>创建日期：2016-11-26</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PageInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int pageNum, pageSize;
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        if (StringUtils.isAnyBlank(pageNumStr, pageNumStr)) {
            logger.debug("page params is empty");
            PaginationContext.setIsPage(false);

            return true;
        }
        try {
            pageNum = Integer.parseInt(pageNumStr);
            pageSize = Integer.parseInt(pageSizeStr);

            PaginationContext.setPageNum(pageNum);
            PaginationContext.setPageSize(pageSize);
            PaginationContext.setIsPage(true);

        } catch (Exception e) {
            PaginationContext.setIsPage(false);
            logger.debug("page params is not number", e);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        PaginationContext.clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
