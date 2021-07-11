package com.liger.common.common.result;

import lombok.Data;

import static org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.commons.httpclient.HttpStatus.SC_OK;

/**
 * 返回值
 *
 * @param <T>
 */
@Data
public class Result<T> {

    /** 编码 */
    private Integer code;
    /** 数据 */
    private T data;
    /** 信息 */
    private String msg;

    Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static Result<?> of(Integer code, String msg) {
        return of(code, null, msg);
    }

    public static <T> Result<T> of(Integer code, T data, String msg) {
        return new Result<>(code, data, msg);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(SC_OK, data, null);
    }

    public static Result<?> ok() {
        return ok(null);
    }

    public static Result<?> error(String msg) {
        return new Result<>(SC_INTERNAL_SERVER_ERROR, null, msg);
    }

    public static Result<?> error(Throwable throwable) {
        return error(throwable.getMessage());
    }

}
