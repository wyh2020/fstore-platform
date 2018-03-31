package com.wyh2020.fstore.base.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


/**
 * Created by hzh on 2018/3/31.
 */
public class PageHelperUtil {

    /**
     * 默认分页不查询count
     * @param pageNo
     * @param pageSize
     * @param <E>
     * @return
     */
    public static <E> Page<E> startPage(int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo + 1, pageSize, false);
    }

    /**
     *
     * @param pageNo
     * @param pageSize
     * @param count true 先查询count
     * @param <E>
     * @return
     */
    public static <E> Page<E> startPage(int pageNo, int pageSize, boolean count) {
        return PageHelper.startPage(pageNo + 1, pageSize, count);
    }
}
