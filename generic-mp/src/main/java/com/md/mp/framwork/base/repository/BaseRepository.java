package com.md.mp.framwork.base.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * BaseRepository
 *
 * @author zhuhaipeng6 in 2020/5/11 14:40
 * @version 1.0
 * @param <T> entity
 * @param <V>  vo
 */
public interface BaseRepository<T, V> extends IService<T> {

    /**
     * 根据id查询vo
     *
     * @param id
     * @return
     */
    V getVoById(Integer id);

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    boolean deleteVoById(Integer id);

    /**
     * 根据vo查询列表
     *
     * @param v
     * @return
     */
    List<V> search(V v);

    /**
     * 根据map查询vo
     *
     * @param queryParams
     * @return
     */
    List<V> search(Map<String, Object> queryParams);

    /**
     * 分页查询
     *
     * @param v
     * @return
     */
    Page page(V v);

    /**
     * 新增或更新vo
     *
     * @param v
     * @return
     */
    V saveUpdateVo(V v);

    /**
     * 批量更新vo
     *
     * @param v
     * @return
     */
    boolean SaveUpdateBatchVo(List<V> v);

    /**
     * 根据vo统计
     *
     * @param v
     * @return
     */
    long countByVo(V v);

}
