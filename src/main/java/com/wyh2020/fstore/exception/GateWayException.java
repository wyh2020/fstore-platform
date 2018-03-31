package com.wyh2020.fstore.exception;

import com.wyh2020.fstore.base.exception.BaseException;

/**
 * Created by hzh on 2018/3/31.
 */
public class GateWayException extends BaseException {

    private static final long serialVersionUID = -6202759931628287239L;


    public GateWayException(){
        super();
    }

    public GateWayException(String msg) {
        super(msg);
    }
    public GateWayException(int errCode, String msg) {
        super(errCode, msg);
    }

    public GateWayException(String msg, Throwable e) {
        super(msg,e);
    }

    public GateWayException(int errCode, String msg, Throwable e) {
        super(errCode, msg, e);
    }


}
