package com.neusoft.util.time;

import java.sql.Timestamp;

/**
 * <p>timestamp工具类</p>
 * <p>创建日期：2018-05-15</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class TimestampUtils {

    private TimestampUtils() {

    }

    /**
     * 返回当前时间
     *
     * @return 当前时间
     */
    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }

}
