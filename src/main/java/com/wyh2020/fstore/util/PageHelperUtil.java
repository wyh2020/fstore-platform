package com.wyh2020.fstore.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * Created by caowei on 2017/4/25.
 */
public class PageHelperUtil {

    public static <E> Page<E> startPage(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum + 1, pageSize, false);
    }
}
