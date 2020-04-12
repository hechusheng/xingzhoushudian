package com.neusoft.core.page;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * <p>分页拦截器</p>
 * <p>创建日期：2017-06-05</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
@Component
@Aspect
public class PageAdvices {

    @Before("execution(* *ByPage(..))")
    public void before(JoinPoint jp) {
        if (PaginationContext.isPage() != null && PaginationContext.isPage()) {
            int pageNum = PaginationContext.getPageNum();
            int pageSize = PaginationContext.getPageSize();
            PageHelper.startPage(pageNum, pageSize);
        }
    }

}
