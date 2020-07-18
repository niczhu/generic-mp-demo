package com.md.mp.framwork.base.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.md.mp.framwork.base.mapper.SuperMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * BaseRepository
 *
 * @author zhuhaipeng6 in 2020/5/11 15:35
 * @version 1.0
 **/
@Slf4j
public abstract class AbstractRepository<M extends SuperMapper<T>, T, V> extends ServiceImpl<M, T> implements BaseRepository<T, V> {

    /**
     * mybatis-plus查询条件
     *
     * @param bean
     * @return
     */
    protected abstract QueryWrapper<T> whereCondition(V bean);

}
