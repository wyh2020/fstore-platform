package com.wyh2020.fstore.base.form;

import lombok.Data;

import java.util.List;

/**
 * Created by hzh on 2018/3/31.
 */
@Data
public class BaseQueryForm {
    public Integer pageSize = 20;

    public Integer pageNum = 0;

    public List<SortInfo> sortInfos;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseForm{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", pageNum=").append(pageNum);
        sb.append('}');
        return sb.toString();
    }
}
