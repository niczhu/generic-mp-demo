package com.md.mp.framwork.base.model;


import lombok.Getter;
import lombok.Setter;

/**
 * AbstractBean
 *
 * @author zhuhaipeng6 in 2020/7/13 9:46
 * @version 1.0
 **/
@Getter
@Setter
public abstract class AbstractVo {

    private long currentPage = 0;

    private long pageSize = 100;
}
