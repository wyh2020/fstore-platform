package com.wyh2020.fstore.base.common;

/**
 * Created with wyh.
 * Date: 2017/7/12
 * Time: 下午2:30
 */
public class FstoreException extends Exception {

    private static final long serialVersionUID = -6202759931628287239L;
    private static final int DEFAULT_ERROR_CODE = 201;


    /* 错误码,用于返回接口code */
    private int errCode;

    public FstoreException(){
        super();
    }

    public FstoreException(String msg) {
        super(msg);
        this.errCode = DEFAULT_ERROR_CODE;
    }
    public FstoreException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
    }

    public FstoreException(String msg, Throwable e) {
        super(msg,e);
        this.errCode = DEFAULT_ERROR_CODE;
    }

    public FstoreException(int errCode, String msg, Throwable e) {
        super(msg, e);
        this.errCode = errCode;
    }


    public int getErrCode() {
        return errCode;
    }
}
