package com.neusoft.core.page;

/**
 * <p>分页参数容器</p>
 * <p>创建日期：2017-06-05</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class PaginationContext {

    /**
     * 保存pageNum
     */
    private static ThreadLocal<Integer> pageNum = new ThreadLocal<>();
    /**
     * 保存pageSize
     */
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();
    /**
     * 是否进行分页
     */
    private static ThreadLocal<Boolean> isPage = new ThreadLocal<>();

    /**
     * 获取分页页码
     *
     * @return 分页页码
     */
    public static Integer getPageNum() {
        Integer pn = pageNum.get();
        if (pn == null) {
            return 0;
        }
        return pn;
    }

    public static void setIsPage(boolean flag) {
        isPage.set(flag);
    }

    public static Boolean isPage() {
        return isPage.get();
    }

    public static void setPageNum(int pageNumValue) {
        pageNum.set(pageNumValue);
    }

    public static void removePageNum() {
        pageNum.remove();
    }

    /**
     * 获取pageSize
     *
     * @return pageSize
     */
    public static Integer getPageSize() {
        Integer ps = pageSize.get();
        if (ps == null) {
            return 0;
        }
        return ps;
    }

    public static void setPageSize(int pageSizeValue) {
        pageSize.set(pageSizeValue);
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void removeIsPage() {
        isPage.remove();
    }

    public static void clear() {
        pageSize.remove();
        pageNum.remove();
        isPage.remove();
    }
}

