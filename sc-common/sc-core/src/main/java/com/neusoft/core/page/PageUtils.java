package com.neusoft.core.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>分页工具类</p>
 * <p>创建日期：2018-03-06</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PageUtils {

    /**
     * 处理分页方法结果，如果是分页后的数据，返回pageInfo，否则返回原数据
     *
     * @param obj 分页方法后的参数
     * @return 处理后的结果
     */
    public static Object getPageInfo(Object obj) {
        if (obj instanceof Page) {
            return new PageInfo<>((List) obj);
        }
        return obj;
    }


}
