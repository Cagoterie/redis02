package com.aaa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/11/8
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class RolePermInfo implements Serializable {
    private Integer rolePermId;
    private Integer roleId;
    private Integer permId;
}
