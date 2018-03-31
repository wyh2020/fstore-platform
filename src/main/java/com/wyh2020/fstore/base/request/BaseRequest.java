package com.wyh2020.fstore.base.request;

import com.wyh2020.fstore.base.BaseSerializable;
import lombok.Data;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
public abstract class BaseRequest extends BaseSerializable {
    /**
     * 触发该请求的客户端IP地址
     */
    private String requestIp;

    /**
     * 触发该请求的系统,由调用方自己定义名称传入
     */
    private String systemSource;

    /**
     * 初始化BaseRequest里的requestIp和systemSource
     *
     * @param requestIp
     * @param systemSource
     */
    public void appendBaseRequest(String requestIp, String systemSource) {
        this.requestIp = requestIp;
        this.systemSource = systemSource;
    }
    /**
     * 入参校验
     * - 校验失败时，统一返回 IllegalArgumentException 异常
     */
    public void checkParam() {
        /*ParamChecker.notBlank(requestIp, "requestIp 不能为空");
        ParamChecker.nonNull(systemSource, "systemSource 不能为空");*/
    }
}
