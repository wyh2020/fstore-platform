package com.wyh2020.fstore.base.service;


import com.wyh2020.fstore.base.condition.BaseCondition;
import com.wyh2020.fstore.base.response.PageResponse;

import java.util.List;


/**
 * Created by hzh on 2018/3/31.
 */
public interface BaseService<T,C extends BaseCondition> {
    /**
     * 查询详情
     * @param id
     * @return
     */
    T query(Object id);

    /**
     * 查询验证的详情,查不到则抛BaseRunTimeException
     * @param id
     * @return
     */
    T queryWithValid(Object id);

    /**
     * 查询列表
     * @param condition
     * @return
     */
    List<T> queryList(C condition);

    /**
     * 查询数量
     * @param condition
     * @return
     */
    int queryCount(C condition);

    /**
     * 查询带分页的数据
     *
     * @param condition
     * @return
     */
    PageResponse queryPage(C condition);

    /**
     * 修改
     *
     * @param po
     * @return
     */
    int update(T po);

    /**
     * 修改,失败则抛BaseRunTimeException
     *
     * @param po
     */
    void updateWithValid(T po);

    /**
     * 新增
     *
     * @param po
     */
    void insert(T po);

    /**
     * 删除
     * @param id
     */
    void delete(Object id);
}
