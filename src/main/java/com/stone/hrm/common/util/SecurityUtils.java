package com.stone.hrm.common.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * SecurityUtils:
 *
 * @author Stone
 * @version V1.0
 * @date 2020/1/29
 **/
public class SecurityUtils {
    public static UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    /**
     * 获取系统用户名称
     * @return 系统用户名称
     */
    public static String getUsername(){
        return getUserDetails().getUsername();
    }
}
