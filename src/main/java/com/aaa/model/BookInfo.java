package com.aaa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author qy105小仙女
 * @version 1.0
 * @Date 2019/10/30
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class BookInfo implements Serializable {
    private Long bookId;
    private String bookName;
    private Integer bookStore;
    private BigDecimal bookPrice;

}
