package com.wyh2020.fstore.base.request;


import com.wyh2020.fstore.base.bean.role.Role;
import com.wyh2020.fstore.base.util.ParamChecker;

public abstract class BaseRoleRequest extends BaseRequest {


    /**
     * 获取用户数据权限身份
     *
     * @return
     */
    protected abstract Role getRole();

    /**
     * 入参校验
     * - 校验失败时，统一返回 IllegalArgumentException 异常
     */
    public void checkParam() {
        super.checkParam();
        ParamChecker.nonNull(getRole(), "role 不能为空");
    }
}
