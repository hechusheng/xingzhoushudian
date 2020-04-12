package com.neusoft.util;

import java.util.UUID;

/**
 * <p>UUID工具类</p>
 * <p>创建日期：2018-03-06</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

}
