package com.wyh2020.fstore.base.request;

import com.wyh2020.fstore.base.bean.role.AgentRole;
import com.wyh2020.fstore.base.util.ParamChecker;
import lombok.Data;


/**
 * Created by hzh on 2018/3/31.
 */

@Data
public abstract class BaseAgentRequest extends BaseRequest {

    private static final long serialVersionUID = -9006756271101001041L;


    private AgentRole role;


    /**
     * 入参校验
     * - 校验失败时，统一返回 IllegalArgumentException 异常
     */
    public void checkParam() {
        ParamChecker.nonNull(role, "role 不能为空");
        super.checkParam();
    }

}
