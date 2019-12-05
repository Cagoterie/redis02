package com.aaa.service.user;

import com.aaa.model.UserInfo;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */
public interface UserInfoService {
    /**
     * 根据用户名和密码查询用户信息
     * @param userName
     * @param userPassword
     * @return
     */

    List<UserInfo> queryUserInfo(String userName, String userPassword);

    /**
     * 根据用户名查询用户信息
     * @param principal
     * @return
     */

    UserInfo queryUserInfoByUserName(String principal);
}
