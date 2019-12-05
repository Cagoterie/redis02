package com.aaa.mapper.user;

import com.aaa.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */
@Mapper
@Repository
public interface UserInfoMapper {

    /**
     * 根据用户名和密码查询用户信息
     * @param userName
     * @param userPassword
     * @return
     */
    @Select("select * from user_Info where user_name = #{userName} and user_password = #{userPassword}")
    List<UserInfo> queryUserInfo(String userName, String userPassword);

    /**
     * get an userInfo by the username
     * @param userName
     * @return
     */
    @Select("select * from user_info where user_name = #{userName}")
    UserInfo getUserInfoByUserName(String userName);
}
