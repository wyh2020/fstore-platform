package com.wyh2020.fstore.base.request;

import com.wyh2020.fstore.base.util.ParamChecker;
import lombok.Data;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
public abstract class BaseQueryRequest extends BaseRequest {
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 条数 为0即查出全部
     */
    private int pageSize = 20;
    /**
     * 排序规则
     */
    private String orderBy;

    /**
     * 入参校验
     * - 校验失败时，统一返回 IllegalArgumentException 异常
     */
    public void checkParam() {
        super.checkParam();
        ParamChecker.expectTrue(pageNum >= 0, "pageNum 不能为负");
        ParamChecker.expectTrue(pageSize > 0, "pageSize 不能小于1");
    }

}
