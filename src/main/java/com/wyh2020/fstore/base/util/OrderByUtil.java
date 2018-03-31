package com.wyh2020.fstore.base.util;


import com.wyh2020.fstore.base.form.SortInfo;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;


/**
 * Created by hzh on 2018/3/31.
 */
public class OrderByUtil {
    /**
     * 获得排序字段
     * @param sortInfoList
     * @param orderByField
     * @return
     */
    public static String getOrderBy(List<SortInfo> sortInfoList , Map<String,String> orderByField) {
        StringBuffer orderBy = new StringBuffer();
        if (sortInfoList != null && sortInfoList.size() != 0){
            for (int i = 0 ; i < sortInfoList.size() ; i++){
                SortInfo sortInfo = sortInfoList.get(i);
                String feild = orderByField.get(sortInfo.getField());
                if (StringUtils.isBlank(feild)){
                    continue;
                }
                orderBy.append(feild);
                orderBy.append(" ");
                String sort;
                if (StringUtils.isBlank(sortInfo.getSort())) {
                    sort = "ASC";
                } else if (sortInfo.getSort().equalsIgnoreCase("DESC")) {
                    sort = "DESC";
                } else if (sortInfo.getSort().equalsIgnoreCase("ASC")) {
                    sort = "ASC";
                } else {
                    sort = "ASC";
                }

                orderBy.append(sort).append(",");
            }
            return StringUtils.isBlank(orderBy.toString()) ? null : orderBy.substring(0,orderBy.length()-1);
        }
        return null;
    }
}
