package com.md.mp.framwork.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface SuperMapper<T> extends BaseMapper<T> {

    /**
     * 根据map统计
     *
     * @param params
     * @return
     */
    long countEntity(Map<String, Object> params);

    /**
     * 根据map条件搜索
     *
     * @param params
     * @return
     */
    List<T> searchEntity(Map<String, Object> params);

}
