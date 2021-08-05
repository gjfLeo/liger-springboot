package com.liger.common.request.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.liger.common.common.result.Result;
import com.liger.common.common.util.HttpRequestUtils;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/request")
public class HttpRequestController {

    /**
     * @param url    请求地址
     * @param method 请求方式，默认为get
     * @param format 返回格式，默认为json
     * @param raw    是否直接返回源结果，默认为否（返回{@link Result}）
     * @return {@link Result}或源结果字符串
     */
    @GetMapping
    public Object request(String url, String method, String format, String raw) {
        if (StringUtils.isEmpty(url)) {
            return Result.of(HttpStatus.SC_BAD_REQUEST, "Param 'url' must not be empty.");
        }
        try {
            // 根据请求地址和请求方式获取请求结果
            String resultStr;
            switch (StringUtils.defaultIfBlank(method, "get").toLowerCase()) {
                case "get":
                    resultStr = HttpRequestUtils.doGet(url);
                    break;
                case "post":
                    return Result.of(HttpStatus.SC_NOT_IMPLEMENTED, "Method POST has not been implemented.");
                default:
                    return Result.of(HttpStatus.SC_BAD_REQUEST, "Param 'format' must match /get|post/i or be empty.");
            }
            // 转换为所需要的类型
            Object resultObj;
            switch (StringUtils.defaultIfBlank(format, "json").toLowerCase()) {
                case "text":
                    resultObj = resultStr;
                    break;
                case "json":
                    try {
                        resultObj = JSON.parse(resultStr);
                    } catch (JSONException e) {
                        return Result.error("JSON format cannot be applied.");
                    }
                    break;
                default:
                    return Result.of(HttpStatus.SC_BAD_REQUEST, "Param 'format' must match /json|text/i or be empty.");
            }
            if (StringUtils.isBlank(raw)) {
                return Result.ok(resultObj);
            }
            return resultObj;
        } catch (Exception e) {
            return Result.error(e);
        }
    }
}
