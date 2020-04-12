package com.neusoft.oauth.util;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>权限工具类</p>
 * <p>创建日期：2018-01-01</p>
 *
 * @author 杨洲 yangzhou@neusoft.com
 */
public class SecurityUtils {

    /**
     * 获取当前用户
     *
     * @return
     */
    public static String getCurrentUserUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        return currentUserName;
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = encoder.encode("abc123");
        System.out.println(password);
    }

}
