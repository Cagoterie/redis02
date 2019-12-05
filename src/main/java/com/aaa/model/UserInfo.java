package com.aaa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */

@ToString
@Setter
@Getter
@EqualsAndHashCode/*重写方法，防止hashcode值重复*/
public class UserInfo implements Serializable {
    private Long userId;
    private String userName;
    private String userPassword;
    private Integer userStatus;
}
