package com.liger.common.common.result;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class ResultException extends RuntimeException {

    @Getter
    @Setter
    private HttpStatus httpStatus;

    public ResultException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
