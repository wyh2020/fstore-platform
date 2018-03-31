package com.wyh2020.fstore.base.response;

import com.wyh2020.fstore.base.BaseSerializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created by hzh on 2018/3/31.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity<T> extends BaseSerializable {

    /**
     * 状态: ok 成功, fail 失败
     */
    private String result;
    /**
     * 状态码: 200 成功, 201 失败, 202 需要登陆
     */
    private Integer  rescode;
    /**
     * 备注原因
     */
    private String msg;
    /**
     * 返回对象
     */
    private T data;

}
