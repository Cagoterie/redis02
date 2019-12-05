package com.aaa.service.user.impl;

import com.aaa.mapper.user.UserInfoMapper;
import com.aaa.model.UserInfo;
import com.aaa.service.user.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private static Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> queryUserInfo(String userName, String userPassword) {
        List<UserInfo> userInfoList = userInfoMapper.queryUserInfo(userName,userPassword);
        if (userInfoList.size() > 0){
            logger.info("成功获取到用户信息");
            return userInfoList;
        }else {
            logger.info("未获取到用户数据");
            return null;
        }
    }

    @Override
    public UserInfo queryUserInfoByUserName(String principal) {
        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(principal);
        if (userInfo==null) {
            return null;
        }
        return userInfo;
    }
}
