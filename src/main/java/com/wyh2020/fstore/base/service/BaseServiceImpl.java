package com.wyh2020.fstore.base.service;

import com.wyh2020.fstore.base.condition.BaseCondition;
import com.wyh2020.fstore.base.exception.BaseRuntimeException;
import com.wyh2020.fstore.base.mapper.BaseMapper;
import com.wyh2020.fstore.base.response.PageResponse;
import com.wyh2020.fstore.base.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.Page;

import java.util.List;


/**
 * Created by hzh on 2018/3/31.
 */
public abstract class BaseServiceImpl<T,C extends BaseCondition, M extends BaseMapper<T, C>> implements BaseService<T, C> {
    // Class <T>  entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @Autowired
    private M mapper;

    @Override
    public T query(Object id) {
        T o = mapper.select(id);
        return o;
    }

    @Override
    public T queryWithValid(Object id) {
        T o = mapper.select(id);
        if (o == null){
            throw new BaseRuntimeException(id + "对应的记录为空");
        }
        return o;
    }

    @Override
    public List<T> queryList(C condition) {
        PageHelperUtil.startPage(condition.getPageNum(),condition.getPageSize());
        List<T> list = mapper.selectList(condition);
        return list;
    }

    @Override
    public int queryCount(C condition) {
        return mapper.count(condition);
    }

    @Override
    public PageResponse queryPage(C condition) {
        Page page = PageHelperUtil.startPage(condition.getPageNum(),condition.getPageSize(), true);
        List<T> list = mapper.selectList(condition);
        PageResponse<T> pageResponse = new PageResponse(page.getTotal(), list);
        return pageResponse;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(T po) {
        int row = mapper.update(po);
        return row;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateWithValid(T po) {
        int row = mapper.update(po);
        if (row == 0) {
            throw new BaseRuntimeException("修改失败");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insert(T po) {
        mapper.insert(po);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Object id) {
        mapper.delete(id);
    }



    /**
     * 返回对应的Mapper
     *
     * @return
     */
    protected M getMapper() {
        return mapper;
    }
}
