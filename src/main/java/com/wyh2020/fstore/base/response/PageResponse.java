package com.wyh2020.fstore.base.response;


import lombok.Data;

import java.util.List;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
public class PageResponse<T> extends ListResponse<T> {
    private long totalCount;

    public PageResponse(long totalCount, List<T> dataList){
        super(dataList);
        this.totalCount = totalCount;
    }
}
