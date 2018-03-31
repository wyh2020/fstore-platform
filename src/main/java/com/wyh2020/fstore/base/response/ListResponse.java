package com.wyh2020.fstore.base.response;


import com.wyh2020.fstore.base.BaseSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
@AllArgsConstructor
public class ListResponse<T> extends BaseSerializable {
    private List<T> dataList;

}
