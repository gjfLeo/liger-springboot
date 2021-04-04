package com.liger.common.common.result;

import lombok.Data;

import static org.apache.commons.httpclient.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.apache.commons.httpclient.HttpStatus.SC_OK;
import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * 返回值
 *
 * @param <T>
 */
@Data
public class LigerResult<T> {

    /** 编码 */
    private Integer code;
    /** 数据 */
    private T data;
    /** 信息 */
    private String msg;

    LigerResult(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static LigerResult<?> of(Integer code, String msg) {
        return of(code, null, msg);
    }

    public static <T> LigerResult<T> of(Integer code, T data, String msg) {
        return new LigerResult<>(code, data, msg);
    }

    public static <T> LigerResult<T> ok(T data) {
        return new LigerResult<>(SC_OK, data, EMPTY);
    }

    public static LigerResult<?> ok() {
        return ok(null);
    }

    public static LigerResult<?> error(String msg) {
        return new LigerResult<>(SC_INTERNAL_SERVER_ERROR, null, msg);
    }

    public static LigerResult<?> error(Throwable throwable) {
        return error(throwable.getMessage());
    }

}
