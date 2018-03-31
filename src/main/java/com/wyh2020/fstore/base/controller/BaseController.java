package com.wyh2020.fstore.base.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.wyh2020.fstore.base.condition.BaseCondition;
import com.wyh2020.fstore.base.exception.ArgumentException;
import com.wyh2020.fstore.base.exception.BaseCenterException;
import com.wyh2020.fstore.base.exception.BaseException;
import com.wyh2020.fstore.base.exception.BaseRuntimeException;
import com.wyh2020.fstore.base.form.BaseQueryForm;
import com.wyh2020.fstore.base.request.BaseQueryRequest;
import com.wyh2020.fstore.base.response.CentreCutPageResponse;
import com.wyh2020.fstore.base.response.CentreListResponse;
import com.wyh2020.fstore.base.response.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 场景:控制层基类.
 * </p>
 *
 * @version 1.0
 * @since 18/03/31下午2:07
 */
public class BaseController {
    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 200;
    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 201;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 中心异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseCenterException.class)
    public ResponseEntity BaseCenterExceptionHandler(BaseCenterException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getErrCode(), e.getMessage());
    }


    /**
     * 业务异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity BaseExceptionHandler(BaseException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getErrCode(), e.getMessage());
    }



    /**
     * 业务异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ArgumentException.class)
    public ResponseEntity BaseArgumentExceptionHandler(ArgumentException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getErrCode(), e.getMessage());
    }


    /**
     * 业务异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseRuntimeException.class)
    public ResponseEntity BaseRuntimeExceptionHandler(BaseRuntimeException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getErrCode(), e.getMessage());
    }

    /**
     * 运行期异常控制
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity runtimeExceptionHandler(RuntimeException e, HttpServletResponse response) {
        response.setStatus(500);
        if (e instanceof HttpMessageNotReadableException){
            logger.warn(e.getLocalizedMessage());
            return this.getFailResult("请求体不可读:" + e.getMessage());
        }

        logger.error("发生系统异常", e);
        return this.getFailResult("系统异常，请和管理员联系：" + e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity bindExceptionHandler(BindException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult("");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        logger.warn(e.getLocalizedMessage());
        return this.getFailResult(e.getBindingResult().getFieldError().getDefaultMessage());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity ExceptionHandler(Exception e) {
        if (e instanceof JsonParseException){
            logger.warn("请求体json转化出错", e);
            return this.getFailResult("请求体json转化出错");
        }
        if (e instanceof HttpMediaTypeNotSupportedException){
            logger.warn("http媒体类型不支持异常", e);
            return this.getFailResult("http媒体类型不支持异常:" + e.getMessage());
        }
        if (e instanceof MissingServletRequestParameterException) {
            logger.warn("缺少参数",e.getLocalizedMessage());
            return this.getFailResult("缺少参数:" + e.getMessage());
        }
        logger.error("发生异常", e);
        return this.getFailResult("请求出错");
    }

    /**
     * 描述：获取成功结果
     *
     * @param obj
     * @return
     * @advised {@link #getSuccessResult(Object)}
     */
    protected <T> ResponseEntity<T> getSuccessResult(T obj) {
        return new ResponseEntity<T>("ok", RESCODE_OK, "操作成功", obj);
    }

    /**
     * 获取成功信息.
     *
     * @param msg
     * @return
     * @advised
     * @author 
     */
    protected ResponseEntity getSuccessResult(String msg) {
        return new ResponseEntity("ok", RESCODE_OK, msg, Collections.EMPTY_MAP);
    }


    /**
     * 获取成功信息.
     *
     * @param msg
     * @param obj
     * @return
     * @advised
     * @author
     */
    protected <T> ResponseEntity<T> getSuccessResult(String msg, T obj) {
        return new ResponseEntity("ok", RESCODE_OK, msg, obj);
    }


    /**
     * 获取默认ajax成功信息.
     *
     * @return
     * @advised {@link #getSuccessResult()}
     * @author 
     */
    protected ResponseEntity getSuccessResult() {
        return getSuccessResult("操作成功");
    }

    /**
     * 描述：获取失败结果 创建人：fengsen 创建时间：2012-8-22 备注：.
     * 已移除,不要再使用
     *
     * @param msg
     * @return
     */
    protected ResponseEntity getFailResult(String msg) {
        return this.getFailResult(RESCODE_FAIL, msg);
    }

    /**
     * 描述：获取失败结果 创建人：fengsen 创建时间：2012-8-22 备注：.
     * 已移除,不要再使用
     *
     * @param msg
     * @return
     */
    protected ResponseEntity getFailResult(int errCode, String msg) {
        return new ResponseEntity("fail", errCode, msg, Collections.EMPTY_MAP);
    }


    /**
     * 转换为返回的不带分页的数据列表
     *
     * @param dataList
     * @return
     */
    protected <T> CentreListResponse<T> getListResponse(List<T> dataList) {
        return new CentreListResponse<>(dataList);
    }


    /**
     * 转换为返回的带分页数据
     *
     * @param queryRequest
     * @param totalCount
     * @param dataList
     * @return
     */
    protected <T> CentreCutPageResponse<T> getPageResponse(BaseQueryRequest queryRequest, long totalCount, List<T> dataList) {
        return new CentreCutPageResponse<>(queryRequest.getPageNum(), queryRequest.getPageSize(), totalCount, dataList);
    }

    /**
     * 转换为返回的带分页数据
     *
     * @param condition
     * @param totalCount
     * @param dataList
     * @return
     */
    protected <T> CentreCutPageResponse<T> getPageResponse(BaseCondition condition, long totalCount, List<T> dataList) {
        return new CentreCutPageResponse<>(condition.getPageNum(), condition.getPageSize(), totalCount, dataList);
    }

    /**
     * 转换为返回的带分页数据
     *
     * @param form
     * @param totalCount
     * @param dataList
     * @return
     */
    protected <T> CentreCutPageResponse<T> getPageResponse(BaseQueryForm form, long totalCount, List<T> dataList) {
        return new CentreCutPageResponse<>(form.getPageNum(), form.getPageSize(), totalCount, dataList);
    }

    /**
     * 转换为返回的带分页数据
     *
     * @param pageNum
     * @param pageSize
     * @param totalCount
     * @param dataList
     * @return
     */
    protected <T> CentreCutPageResponse<T> getPageResponse(int pageNum, int pageSize, long totalCount, List<T> dataList) {
        return new CentreCutPageResponse<>(pageNum, pageSize, totalCount, dataList);
    }

}
