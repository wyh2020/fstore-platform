package com.wyh2020.fstore.base.form;

import com.wyh2020.fstore.base.BaseSerializable;
import com.wyh2020.fstore.base.util.ParamChecker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortInfo extends BaseSerializable {
    public String field;

    public String sort;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortInfo{");
        sb.append("field='").append(field).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void checkParam() {
        ParamChecker.notBlank(field, "field 不能为空");
        ParamChecker.notBlank(sort, "sort 不能为空");


        if (!sort.equalsIgnoreCase("asc") && !sort.equalsIgnoreCase("desc")) {
            throw new IllegalArgumentException("排序只能是asc或desc");
        }
    }
}
