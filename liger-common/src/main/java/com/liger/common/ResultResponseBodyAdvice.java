package com.liger.common;

import com.liger.common.common.result.Result;
import com.liger.common.common.result.ResultException;
import com.liger.common.common.result.ResultResponseBody;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

@RestControllerAdvice
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Class<? extends Annotation> RESULT_ANNOTATION = ResultResponseBody.class;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), RESULT_ANNOTATION)
                || returnType.hasMethodAnnotation(RESULT_ANNOTATION);
    }

    /**
     * 当类或者方法使用了 @ResultResponseBody 就会调用这个方法
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        }
        return Result.ok(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<Result<?>> exceptionHandler(IllegalArgumentException e) {
        HttpHeaders headers = new HttpHeaders();
        Result<?> body = Result.of(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(ResultException.class)
    public final ResponseEntity<Result<?>> exceptionHandler(ResultException e) {
        HttpHeaders headers = new HttpHeaders();
        Result<?> body = Result.of(e.getHttpStatus().value(), e.getMessage());
        HttpStatus status = e.getHttpStatus();
        return new ResponseEntity<>(body, headers, status);
    }

    /**
     * 提供对标准Spring MVC异常的处理
     *
     * @param ex the target exception
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Result<?>> exceptionHandler(Exception ex) {
        HttpHeaders headers = new HttpHeaders();
        return this.handleException(ex, headers);
    }

    private ResponseEntity<Result<?>> handleException(Exception ex, HttpHeaders headers) {
        Result<?> body = Result.error(ex);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(body, headers, status);
    }

}
